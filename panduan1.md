# Panduan Akses dan Konfigurasi MySQL di VM

Panduan ini mencakup langkah-langkah untuk:
1. Mengecek akses MySQL di VM.
2. Melakukan konfigurasi MySQL di DBeaver.
3. Menjalankan DDL dan DML untuk pembuatan database dan tabel.

## 1. Mengecek Akses MySQL di VM

Langkah awal adalah memastikan akses ke MySQL di dalam VM. Ikuti langkah berikut:

### a) Akses VM via SSH
Jika Anda mengakses VM menggunakan SSH, buka terminal pada mesin lokal dan gunakan perintah berikut untuk masuk ke VM:

```bash
ssh username@VM_IP_Address
```

Catatan: Gantilah username dan VM_IP_Address dengan kredensial yang sesuai untuk VM.

### b) Cek Akses MySQL
Setelah berhasil masuk ke VM, cek akses ke MySQL dengan menjalankan perintah berikut di dalam VM:

```bash
mysql -u root -p
```

Masukkan password yang sesuai saat diminta. Jika login berhasil, Anda akan masuk ke MySQL CLI.

Catatan: Jika Anda menggunakan user selain root, gantilah -u root dengan username yang sesuai.

## 2. Konfigurasi MySQL di DBeaver

Setelah memastikan akses ke MySQL di VM, Anda bisa menghubungkannya ke DBeaver untuk kemudahan manajemen database.

a. Buka DBeaver dan Buat Koneksi Baru

b. Buka aplikasi DBeaver.

c. Pilih opsi untuk membuat New Database Connection.

d. Pilih MySQL sebagai jenis koneksi.

### Isi Detail Koneksi
Masukkan detail koneksi sebagai berikut:

- Host: IP dari VM atau localhost jika Anda berada di dalam VM.
- Port: 3306 (port default untuk MySQL).
- Database: (kosongkan jika belum ada database).
- Username: Masukkan username MySQL, seperti root atau - user_bank (jika sudah dibuat sebelumnya).
- Password: Masukkan password sesuai user MySQL.

### Tes Koneksi

Klik Test Connection untuk memastikan DBeaver dapat terhubung dengan MySQL di VM. Jika koneksi berhasil, klik Finish untuk menyimpan konfigurasi.

Catatan: Jika koneksi dilakukan dari luar VM, pastikan port 3306 terbuka di firewall VM.

## 3. Menjalankan DDL dan DML di MySQL

a) Buat Database

Gunakan perintah berikut untuk membuat database baru, misalnya bank_db:

```sql
CREATE DATABASE bank_db;
```

b) Pilih Database

Aktifkan database yang baru dibuat dengan perintah:

```sql
USE bank_db;
```

c) Buat Tabel

```sql
CREATE TABLE nasabah (
    id_nasabah INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL
);
```

d) Menambahkan Data ke Tabel (DML)

```sql
INSERT INTO nasabah (nama, saldo) VALUES ('John Doe', 100000.00);
INSERT INTO nasabah (nama, saldo) VALUES ('Jane Doe', 150000.00);
```

e) Cek Data di Tabel

Untuk memastikan data berhasil dimasukkan, gunakan perintah berikut:

```sql
SELECT * FROM nasabah;
```

## Pastikan hal-hal berikut untuk kelancaran akses dan konfigurasi MySQL di VM:

- Kredensial: Pastikan username dan password untuk MySQL sudah sesuai.
- Port dan Firewall: Pastikan port 3306 tidak terblokir, terutama jika mengakses dari luar VM.
- Hak Akses User: Pastikan user memiliki hak akses yang cukup untuk melakukan operasi DDL dan DML pada database.

Silahkan ditanyakan jika nanti ada trouble ya dilampirkan screenshoot