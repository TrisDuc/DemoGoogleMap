# 📍 Google Maps API Demo – Rescue Location Management

This project is a **Java Servlet–based web application** that displays and manages **real-time locations** of rescue teams and civilians on **Google Maps**.

The project is part of an **Eyeglasses Website system**, where the map feature supports **delivery tracking and emergency rescue services**.

---

## 📸 Screenshots

### Database Structure
![Database Schema](./images/db_structure.png)

### Sample Data
![Sample Data](./images/sample_data.png)

---

## 🛠 Technologies Used
- **Backend:** Java Servlet
- **Frontend:** HTML, CSS, JavaScript
- **Map Service:** Google Maps API
- **Database:** Microsoft SQL Server
- **Server:** Apache Tomcat 9
- **Version Control:** Git & GitHub

---

## 🗄 Database Design

The `UserLocations` table stores user location data:

| Column Name  | Data Type         | Allow Nulls |
|-------------|-------------------|-------------|
| **UserID**      | nvarchar(50)     | No          |
| **UserType**    | nvarchar(20)     | Yes         |
| **Latitude**    | decimal(10,8)    | Yes         |
| **Longitude**   | decimal(11,8)    | Yes         |
| **LastUpdate**  | datetime         | Yes         |

---

## 🔧 Prerequisites / Required Downloads

To run this project locally, please download and install the following software and libraries.

#### 🧑‍💻 Development Tools

* **Apache NetBeans 13 (Windows x64)**
  👉 [Download from Google Drive](https://drive.google.com/drive/folders/1-o-26cV1B0YvS_QCc-L3dLvUD78nGFRn?usp=sharing)
  *(File: `Apache-NetBeans-13-bin-windows-x64.exe`)*

* **JDK 8 (64-bit)**
  👉 [Download from Google Drive](https://drive.google.com/drive/folders/1-o-26cV1B0YvS_QCc-L3dLvUD78nGFRn?usp=sharing)
  *(File: `jdk-8u202-windows-x64.exe`)*

#### 🌐 Application Server

* **Apache Tomcat 9.0.113**
  👉 [Download from Google Drive](https://drive.google.com/drive/folders/1-o-26cV1B0YvS_QCc-L3dLvUD78nGFRn?usp=sharing)
  *(File: `apache-tomcat-9.0.113.exe`)*

#### 📦 Required Libraries (JAR files)

Download the following JAR files and add them to your project’s `WEB-INF/lib` folder:

* **JSTL 1.2**
  👉 [Download from Google Drive](https://drive.google.com/drive/folders/1-o-26cV1B0YvS_QCc-L3dLvUD78nGFRn?usp=sharing)
  *(File: `jstl-1.2.jar`)*

* **SQL Server JDBC Driver**
  👉 [Download from Google Drive](https://drive.google.com/drive/folders/1-o-26cV1B0YvS_QCc-L3dLvUD78nGFRn?usp=sharing)
  *(File: `sqljdbc4.jar`)*

---

## 🚀 Installation & Run

### 1. Clone the repository
```bash
git clone https://github.com/TrisDuc/DemoGoogleMap.git
