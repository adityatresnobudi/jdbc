# Panduan Implementasi JDBC dengan MySQL di VM

Panduan ini menjelaskan cara menghubungkan aplikasi Java dengan MySQL di VM menggunakan JDBC. Langkah-langkah mencakup:

1. Mengonfigurasi proyek Java untuk koneksi MySQL.
2. Mencoba menjalankan koneksi database untuk memastikan koneksi berhasil.

## Mengonfigurasi Proyek Java di IntelliJ IDEA
Setelah menyiapkan database dan user di VM, lanjutkan dengan konfigurasi proyek Java di IntelliJ IDEA.

a) Buat Proyek Baru dengan Gradle

- Buka IntelliJ IDEA dan pilih New Project.
- Pilih Java sebagai tipe proyek, kemudian pilih Gradle sebagai build system.
- Pastikan SDK yang dipilih adalah Java 17.
- Beri nama proyek, misalnya BankingAppJDBCGradle, dan klik Finish.

b) Tambahkan MySQL JDBC Driver ke `build.gradle`

- Buka file `build.gradle`
- Tambahkan dependensi `MySQL JDBC Driver` sebagai berikut:
```sql
dependencies {
    implementation 'mysql:mysql-connector-java:8.0.29'
}
```

- Sinkronkan proyek Gradle dengan memilih Reload All Gradle Projects untuk mengunduh dependensi.


c) Buat Kelas DatabaseConnection.java

Buat kelas `DatabaseConnection.java` di dalam proyek untuk mengelola koneksi database. Berikut adalah contohnya:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://VM_IP_Address:3306/bank_app";
    private static final String USER = "user_bank";
    private static final String PASSWORD = "password123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return connection;
    }
}
```

**Catatan: Gantilah VM_IP_Address dengan IP address dari VM yang Anda gunakan.**


3. Menjalankan Koneksi Database

Setelah konfigurasi selesai, coba jalankan koneksi untuk memastikan aplikasi Java dapat terhubung ke MySQL di VM.

a) Buat Kelas Main.java untuk Menguji Koneksi

Tambahkan kelas Main.java untuk menjalankan koneksi database:

```java
public class Main {
    public static void main(String[] args) {
        DatabaseConnection.getConnection();
    }
}
```

b) Jalankan Program
Klik kanan pada Main.java dan pilih Run untuk menjalankan program.

Periksa console untuk output. Jika koneksi berhasil, Anda akan melihat pesan:

```bash
Koneksi ke database berhasil!
```

### 4. Tambahan Penting untuk Pengecekan

- Periksa Kredensial: Pastikan username, password, dan nama database di kelas DatabaseConnection.java sesuai dengan yang sudah dibuat di MySQL di VM.
- Port dan Firewall: Jika aplikasi berjalan di luar VM, pastikan port 3306 terbuka dan dapat diakses.
- Exception Handling: Pastikan Anda menangani SQLException dengan baik untuk informasi lebih lanjut saat terjadi kesalahan.




Silahkan ditanyakan jika nanti ada trouble ya dilampirkan screenshoot