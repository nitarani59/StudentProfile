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
## Positive Scenarios
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

## Negative Scenarios

---

### ➤ Duplicate Student ID

**POST** `http://localhost:8080/v1/createProfile`

**Scenario:** Creating student with existing `studentId`

Response Body:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Student Id 8 already exist."
}
```

---

### ➤ Student Not Found (Get by ID)

**GET** `http://localhost:8080/v1/getProfile/100`

**Scenario:** Student ID does not exist

Response Body:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Student id 100 not exist"
}
```

---

### ➤ Student Not Found (Update)

**PUT** `http://localhost:8080/v1/updateProfile/100`

**Scenario:** Updating non-existing student

Response Body:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Student id 100 not exist"
}
```

---

### ➤ Student Not Found (Delete)

**DELETE** `http://localhost:8080/v1/deleteProfile/100`

**Scenario:** Deleting non-existing student

Response Body:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Student id 100 not exist"
}
```

---

### ➤ Invalid Request Body

**POST** `http://localhost:8080/v1/createProfile`

**Scenario:** Missing required fields 'Student Name'

Request Body:

```json
{
  "studentId": 94,
  "age":22,
  "emailId":"nitarani440@gmail.com",
  "course":"Btech"
}
```

Response Body:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Student Name is required"
}
```

---

### ➤ Excel File Open During Operation

**Scenario:** Excel file is open while API is writing

Response:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "C:\\SpringBoot-Project\\StudentProfile\\studentprofile.xlsx (The process cannot access the file because it is being used by another process)"
}
```

---

### ➤ Invalid Email Id

**Scenario:** Provided email id is invalid

Request Body

```json
{
    "studentId": 92,
    "studentName":"Jai Prakash",
    "age":22,
    "emailId":"nitarani440",
    "course":"Btech"
}
```
Response:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "Invalid email format"
}
```

### ➤ Student id is null

**Scenario:** Provided null for non-null field

Request Body

```json
{
  "studentId": null,
  "studentName":"Jai Prakash",
  "age":22,
  "emailId":"nitarani440@gmail.com",
  "course":"Btech"
}
```
Response:

```json
{
  "errorCode": "400 BAD_REQUEST",
  "errorMessage": "JSON parse error: studentId is marked non-null but is null"
}
```
---

## ▶️ How to Run

1. Clone the project
2. Run Spring Boot application
3. Use Postman to test APIs
