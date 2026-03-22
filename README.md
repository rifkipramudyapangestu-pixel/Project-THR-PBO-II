Sistem Pengelolaan Jadwal Presentasi Kelompok Tugas 1 – Pemrograman Berorientasi Objek (PBO)

BAGIAN 1 – Analisis Sistem Deskripsi Analisis sistem ini bertujuan untuk mengidentifikasi komponen-komponen utama dalam Sistem Pengelolaan Jadwal Presentasi Kelompok menggunakan pendekatan berorientasi objek. Fokus utama adalah pada identifikasi kelas, atribut, metode, penerapan konsep inheritance, serta hubungan antar kelas.

Class, Atribut, dan Method

Pengguna (Superclass) Atribut : -idPengguna -nama -email -password Method : -login() -logout() -ubahProfil()

Mahasiswa (Subclass) Atribut: -nim -kelas -prodi -angkatan Method : -daftarKelompok() -lihatJadwalPresentasi() -uploadMateriPresentasi()

Dosen (Subclass) Atribut : -nidn -departemen Method : -verifikasiKelompok() -aturJadwalPresentasi() -beriNilaiPresentasi()

Kelompok Atribut : -idKelompok -namaKelompok -topikKelompok -anggota Method : -tambahAnggota() -hapusAnggota() -ubahTopikAnggota() -tampilkanInfoKelompok()

Presentasi Atribut : -idPresentasi -tanggal -waktuMulai -waktuSelesai -lokasi -materiPresentasi -dosenPenguji -nilai Method : -buatJadwal() -ubahJadwal() -hapusJadwal() -unggahMateri() -beriNilai()

Penerapan Inheritance Konsep inheritance diterapkan pada class Pengguna. Class Mahasiswa dan Dosen mewarisi atribut serta method dari class Pengguna, kemudian menambahkan atribut dan method yang sesuai dengan perannya masing-masing.

Hubungan Antar Class

Pengguna – Mahasiswa Hubungan inheritance, di mana Mahasiswa mewarisi atribut dan method dari Pengguna.
Pengguna – Dosen Hubungan inheritance, di mana Dosen juga mewarisi atribut dan method dari Pengguna.
Kelompok – Mahasiswa Hubungan aggregation, di mana satu kelompok terdiri dari beberapa mahasiswa sebagai anggota.
Presentasi – Kelompok Hubungan association, karena setiap presentasi dilakukan oleh satu kelompok.
Presentasi – Dosen Hubungan association, karena setiap presentasi dinilai oleh seorang dosen.
Dosen – Presentasi Hubungan one-to-many, di mana satu dosen dapat mengatur dan menilai beberapa presentasi.
BAGIAN 3 – Analisis Konsep PBO Penerapan Class dan Object Konsep class pada program diterapkan melalui beberapa kelas seperti Pengguna, Mahasiswa, Dosen, Kelompok, dan Presentasi. Dan setiap class adalah blueprint yang mendefinisikan atribut dan method. Sedangkan Object adalah wujud nyata dari sebuah class yang dibuat menggunakan keyword new. Misalnya saat pengguna menambah data mahasiswa baru, program membuat object Mahasiswa baru dan menyimpannya ke ArrayList. Setiap data mahasiswa, dosen, kelompok, dan presentasi yang tersimpan dalam sistem adalah object dari class nya masing-masing.

Penerapan Enkapsulasi Enkapsulasi diterapkan dengan cara:

Semua atribut dideklarasikan private atau protected sehingga tidak bisa diakses langsung dari luar class. Atribut di Class Pengguna menggunakan protected agar bisa diwarisi subclass, sedangkan atribut lebih spesifik seperti nim di Mahasiswa dan nidn di Dosen menggunakan private.
Akses data hanya melalui method yang sudah ditentukan, misalnya getNama(), getNim(), dan setIdKelompok(). Jadi pihak luar tidak bisa mengubah data secara langsung.
Perubahan data dikontrol melalui method khusus, contohnya topik kelompok hanya bisa diubah melalui ubahTopikPresentasi() di class Kelompok, nilai presentasi hanya bisa diberikan melalui beriNilai() di class Presentasi, dan jadwal hanya bisa dikelola melalui buatJadwal() dan ubahJadwal(). Untuk memastikan setiap perubahan data melewati logika yang sudah ditentukan di dalam class.
Alasan Pendekatan PBO Pendekatan PBO lebih baik karena sistem ini melibatkan banyak entitas berbeda yang masing-masing memiliki data dan perilaku tersendiri. Dengan PBO, setiap class seperti Mahasiswa, Dosen, Kelompok, dan Presentasi mengelola datanya secara mandiri sehingga perubahan pada satu class tidak mengganggu bagian dari class lain. Selain itu, konsep inheritance memungkinkan atribut dan method umum cukup ditulis sekali, contohnya di class Pengguna lalu diwariskan ke class Mahasiswa dan Dosen, untuk menghindari duplikasi kode. Hal ini membuat sistem lebih terstruktur, mudah dipelihara, dan mudah dikembangkan dibandingkan pendekatan prosedural yang semua fungsi dan datanya tercampur tanpa pemisahan yang jelas.

BAGIAN 4 – Refleksi

Bagian yang paling sulit dalam mengerjakan tugas ini Bagian yang paling sulit pada tugas kali ini adalah menentukan class apa saja yang akan digunakan dalam sistem ini, dikarenakan dalam satu kelompok itu tidak boleh sama pada bagian class nya. Dan memastikan setiap class memiliki atribut dan method yang sesuai dengan fungsinya dalam sistem.
Hal baru yang dipelajari tentang konsep PBO Hal baru yang saya pelajari adalah bagaimana konsep PBO seperti class, object, inheritance, dan enkapsulasi dapat digunakan untuk merancang sistem yang lebih terstruktur. Saya juga memahami bahwa setiap objek dalam sistem dapat merepresentasikan entitas nyata seperti mahasiswa, dosen, kelompok, dan presentasi.
Fitur yang Akan dikembangkan dari sistem ini Jika sistem ini dikembangkan lebih lanjut, fitur yang akan ditambahkan adalah sistem notifikasi otomatis kepada mahasiswa dan dosen ketika jadwal presentasi dibuat atau mengalami perubahan. Upload dan penyimpanan file materi secara online, Dan fitur rekap nilai presentasi per kelompok juga akan berguna bagi dosen agar bisa melihat riwayat penilaian secara keseluruhan dalam satu tampilan yang terstruktur. Dan bagi mahasiswa agar dapat melihat hasil penilaian dengan lebih mudah.