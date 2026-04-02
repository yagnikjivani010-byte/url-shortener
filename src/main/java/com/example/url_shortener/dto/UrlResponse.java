package com.example.url_shortener.dto;

public class UrlResponse {
    private String shortUrl;

    public String getShortUrl(){
        return shortUrl;
    }

    public UrlResponse(String shortUrl){
        this.shortUrl = shortUrl;
    }
}
