# StudentProfile

## 📌 Overview

This project is a **Spring Boot REST API** that manages student profiles.
All data is stored in an **Excel file (`.xlsx`)** using Apache POI.

---

## 🚀 Features

* Create student profile
* Fetch student by ID
* Fetch all student profile
* Update student details
* Delete student profile

---

## 🛠️ Tech Stack

* Spring Boot
* Apache POI (for Excel handling)

---
## 🔗 API Endpoints

### ➤ Create Student

**POST** `http://localhost:8080/v1/createProfile`

Request Body:

```json
{
  "studentId": 9,
  "studentName":"Jai Prakash",
  "age":22,
  "emailId":"nitarani440@gmail.com",
  "course":"Btech"
}
```

Response Body:

```json
{
    "age": 22,
    "course": "Btech",
    "emailId": "nitarani440@gmail.com",
    "studentId": 9,
    "studentName": "Jai Prakash"
}
```
---

### ➤ Get Student by ID

**GET** `http://localhost:8080/v1/getProfile/9`

Response Body:

```json
{
  "age": 22,
  "course": "Btech",
  "emailId": "nitarani440@gmail.com",
  "studentId": 9,
  "studentName": "Jai Prakash"
}
```

---

---

### ➤ Fetch All Student

**GET** `http://localhost:8080/v1/getAllProfile`

Response Body:

```json
[
  {
    "age": 22,
    "course": "Btech",
    "emailId": "nitarani440@gmail.com",
    "studentId": 5,
    "studentName": "Jai Prakash"
  },
  {
    "age": 22,
    "course": "Btech",
    "emailId": "nitarani440@gmail.com",
    "studentId": 4,
    "studentName": "Jai Prakash"
  },
  {
    "age": 22,
    "course": "Btech",
    "emailId": "nitarani440@gmail.com",
    "studentId": 2,
    "studentName": "Jai Prakash"
  },
  {
    "age": 22,
    "course": "B.A",
    "emailId": "nitarani440@gmail.com",
    "studentId": 1,
    "studentName": "Jai Prakash"
  },
  {
    "age": 22,
    "course": "B.A",
    "emailId": "nitarani440@gmail.com",
    "studentId": 0,
    "studentName": "Jai Prakash"
  }
]
```

---

### ➤ Update Student

**PUT** `http://localhost:8080/v1/updateProfile/9`

Request Body:

```json
{
  "studentName":"Jai Prakash",
  "age":22,
  "course":"B.A"
}
```

Response Body

```
Updated Successfully
```
---

### ➤ Delete Student Profile

**DELETE** `http://localhost:8080/v1/deleteProfile/9`

---
## ▶️ How to Run

1. Clone the project
2. Run Spring Boot application
3. Use Postman to test APIs
