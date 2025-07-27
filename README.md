# 📸 Golden Photo Studio – Backend API

This is the backend REST API for **Golden Photo Studio**, built using **Spring Boot**. It allows clients to book photography sessions, upload sample images, and lets the admin manage bookings. The application uses **JWT-based authentication** and supports role-based access control.

---

## 🚀 Features

- ✅ User registration & login with JWT
- 📅 Book a photo shoot with preferred date/time
- 🔐 Admin & Client role separation
- 🖼️ Image upload with generated public URLs
- 🔄 RESTful API endpoints
- 🧩 DTOs for clean API design
- 📁 Uploads stored in `uploads/` folder

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA
- MySQL (or H2 for dev)
- Lombok
- Validation API

---

## 📂 Project Structure

src/
├── config/ # Security configurations
├── controller/ # API endpoints (Auth, Bookings)
├── dto/ # Data Transfer Objects
├── entity/ # JPA entities
├── repository/ # JPA repositories
├── service/ # Business logic layer
├── utils/ # JWT utilities
└── GoldenPhotoStudioApplication.java 



---

## 🧪 API Endpoints

### 🔐 Authentication

| Method | Endpoint            | Description              |
|--------|---------------------|--------------------------|
| POST   | `/api/v1/auth/signup` | Register new user       |
| POST   | `/api/v1/auth/signin` | Login & receive JWT     |

### 📸 Booking

| Method | Endpoint                   | Description                       |
|--------|----------------------------|-----------------------------------|
| POST   | `/api/v1/bookings`         | Create a new booking              |
| GET    | `/api/v1/bookings`         | Get all bookings (Admin only)     |
| GET    | `/api/v1/bookings/{id}`    | Get booking by ID (Admin only)    |

### 🖼️ Image Upload

| Method | Endpoint                            | Description                     |
|--------|-------------------------------------|---------------------------------|
| POST   | `/api/v1/bookings/upload-image`     | Upload image to `/uploads/`     |

---

## 📋 Booking Request Format

```json
{
  "name": "Sufiyan",
  "email": "example@email.com",
  "phone": "1234567890",
  "shootType": "Wedding",
  "date": "2025-07-27",
  "time": "14:00:00",
  "message": "Need candid photography"
}

##  ⚙️ Getting Started
##  1. Clone the Repository

git clone https://github.com/Sufi111729/Golden-photo-Studio-backend.git
cd Golden-photo-Studio-backend


## 2. Configure Database
## Update src/main/resources/application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
file.upload-dir=uploads
3. Run the App
bash
Copy
Edit
./mvnw spring-boot:run
🔐 JWT Authentication
When a user logs in, a JWT token is returned.

Use it in the Authorization header for protected routes:

http
Copy
Edit
Authorization: Bearer <your_token_here>
🗃️ Uploading Files
Endpoint: POST /api/v1/bookings/upload-image

Accepts multipart/form-data

Stores file in /uploads/ and returns public URL

📦 Dependencies
spring-boot-starter-web

spring-boot-starter-security

spring-boot-starter-data-jpa

jjwt (JWT auth)

lombok

spring-boot-starter-validation

mysql-connector-java

🧪 Testing (To Add)
You can write test cases for:

Booking creation

Auth login/signup

JWT token validation

🛡️ Role-Based Access
Two roles are defined:

ROLE_USER → Can create bookings

ROLE_ADMIN → Can manage all bookings

Use @PreAuthorize on controller methods for access control.

📁 Sample .env or application.properties
properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/golden
spring.datasource.username=root
spring.datasource.password=admin
jwt.secret=your_jwt_secret_key
file.upload-dir=uploads
🚀 Deployment
Ensure file storage is handled for cloud (S3, etc.)

Set environment variables securely

Build using:

bash
Copy
Edit
./mvnw clean install
🙌 Author
Muhammad Sufiyan
🔗 GitHub Profile

📄 License
This project is licensed under the MIT License.

📌 TODO (Suggestions)
Add Swagger/OpenAPI documentation

Integrate email confirmation on bookings

Add file type validation for uploads

Rate limiting on auth endpoints

⭐️ Star this repo
If you find this useful, consider giving it a ⭐️ on GitHub to support the project.


---

Let me know if you'd like a `README.md` file added directly into the repo (PR), or a Swagger/OpenAPI documentation file for your API.
