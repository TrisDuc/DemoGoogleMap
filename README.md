# 📍 Demo Google Map API - Quản lý vị trí cứu hộ

Dự án này là một ứng dụng web (Servlet) dùng để hiển thị và quản lý vị trí thời gian thực của các đội cứu hộ và người dân trên Google Maps. Dự án nằm trong hệ thống website bán kính mắt (Eyeglasses Website) nhằm hỗ trợ các dịch vụ giao hàng hoặc cứu hộ liên quan.

---

## 📸 Hình ảnh minh họa
Ở đây bạn có thể chèn ảnh chụp màn hình cơ sở dữ liệu hoặc giao diện web của bạn:

### Cấu trúc Database
![Database Schema](./images/db_structure.png)

### Dữ liệu mẫu
![Sample Data](./images/sample_data.png)

---

## 🛠 Công nghệ sử dụng
* **Backend:** Java Servlet
* **Database:** Microsoft SQL Server
* **Frontend:** HTML, CSS, JavaScript, Google Maps API
* **Version Control:** Git & GitHub

---

## 🗄 Cấu trúc Database
Bảng `UserLocations` lưu trữ tọa độ:
| Column Name | Data Type | Allow Nulls |
| :--- | :--- | :---: |
| **UserID** | nvarchar(50) | No |
| **UserType** | nvarchar(20) | Yes |
| **Latitude** | decimal(10, 8) | Yes |
| **Longitude** | decimal(11, 8) | Yes |
| **LastUpdate** | datetime | Yes |

---

## 🚀 Cách cài đặt và chạy
1. **Clone dự án:**
   ```bash
   git clone [https://github.com/TrisDuc/DemoGoogleMap.git](https://github.com/TrisDuc/DemoGoogleMap.git)
