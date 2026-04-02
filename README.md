
# 🔗 URL Shortener (Spring Boot + MySQL)

A simple and scalable **URL Shortener** built using **Java Spring Boot** and **MySQL**, similar to Bit.ly.

---

## 🚀 Features

* 🔗 Shorten long URLs
* 🔁 Redirect to original URL
* 📊 Click count tracking
* ♻️ Prevent duplicate URLs
* 💾 MySQL database integration
* ⚡ Base62 encoding for short codes

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 📁 Project Structure

```
src/
 └── main/
     ├── java/com/example/url_shortener/
     │    ├── controller/
     │    ├── service/
     │    ├── repository/
     │    └── model/
     └── resources/
          ├── application.properties
```

---

## ⚙️ Setup Instructions

### 1. Clone Repository

```
git clone https://github.com/YOUR_USERNAME/url-shortener.git
cd url-shortener
```

---

### 2. Configure Environment Variables

Create a `.env` file in the root:

```
DB_USERNAME=root
DB_PASSWORD=yourpassword
```

---

### 3. Configure Application

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
server.port=8082
```

---

### 4. Run Application

```
./mvnw spring-boot:run
```

---

## 📡 API Endpoints

### 🔹 Shorten URL

**POST** `/shorten`

Body:

```json
{
  "longUrl": "https://google.com"
}
```

Response:

```
http://localhost:8082/abc123
```

---

### 🔹 Redirect

**GET** `/{shortCode}`

Example:

```
http://localhost:8082/abc123
```

➡️ Redirects to original URL

---

## 🧠 How It Works

1. User sends long URL
2. URL stored in database
3. Unique ID generated
4. ID converted to Base62 → short code
5. Short URL returned
6. On access → redirect + increment click count

---

## 🔐 Security Note

* `.env` file is ignored using `.gitignore`
* No sensitive data (DB credentials) is pushed to GitHub

---

## 🚀 Future Improvements

* Custom short URLs
* URL expiry
* Analytics dashboard
* Redis caching
* Rate limiting

---

## 👨‍💻 Author

Built by YOU 🚀

---

## ⭐ If you like this project

Give it a star on GitHub ⭐
