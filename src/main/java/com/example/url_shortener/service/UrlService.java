package com.example.url_shortener.service;

import com.example.url_shortener.model.Url;
import com.example.url_shortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String longUrl) {

        Optional<Url> existing = urlRepository.findByLongUrl(longUrl);

        if (existing.isPresent()) {
            return "http://localhost:8082/" + existing.get().getShortCode();
        }

        Url url = new Url();
        url.setLongUrl(longUrl);

        // ✅ First save to get ID
        url = urlRepository.save(url);

        String shortCode = encodeBase62(url.getId());

        url.setShortCode(shortCode);

        // ✅ Save again with shortCode
        urlRepository.save(url);

        return "http://localhost:8082/" + shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);

        return url.getLongUrl();
    }

    // ✅ Base62 encoding
    private String encodeBase62(Long num) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int rem = (int) (num % 62);
            sb.append(chars.charAt(rem));
            num = num / 62;
        }

        return sb.reverse().toString();
    }
}
