import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {

    private static List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private static List<Kelompok> daftarKelompok = new ArrayList<>();
    private static List<Dosen> daftarDosen = new ArrayList<>();
    private static List<Presentasi> daftarPresentasi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private static int nextKelompokId = 1;
    private static int nextPresentasiId = 1;

    public static void main(String[] args) {
        inisialisasiDataAwal();

        int pilihanUtama;
        do {
            tampilkanMenuUtama();
            System.out.print("Pilih Menu Utama: ");
            pilihanUtama = inputInt();

            switch (pilihanUtama) {
                case 1: menuMahasiswa(); break;
                case 2: menuKelompok(); break;
                case 3: menuPresentasi(); break;
                case 4: menuPenilaian(); break;
                case 0: System.out.println("Terima kasih! Program selesai."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihanUtama != 0);
    }

    private static void inisialisasiDataAwal() {
        daftarMahasiswa.add(new Mahasiswa("U001", "Messi", "messi@univ.com", "123", "12345", "1A", "Teknik Informatika", "2025"));
        daftarMahasiswa.add(new Mahasiswa("U002", "Ronaldo", "ronaldo@univ.com", "123", "12346", "1A", "Teknik Informatika", "2025"));
        daftarDosen.add(new Dosen("D001", "Alexander, S.Kom., M.Kom.", "alex@univ.ac.id", "dosen123", "001", "Ilmu Komputer"));
        System.out.println("Sistem Siap. Data awal berhasil dimuat.");
    }

    private static int inputInt() {
        try {
            int val = scanner.nextInt();
            scanner.nextLine(); 
            return val;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n===============================================");
        System.out.println("   SISTEM PENGELOLAAN JADWAL PRESENTASI");
        System.out.println("===============================================");
        System.out.println("1. Manajemen Mahasiswa");
        System.out.println("2. Manajemen Kelompok");
        System.out.println("3. Manajemen Jadwal Presentasi");
        System.out.println("4. Manajemen Penilaian");
        System.out.println("0. Keluar");
        System.out.println("-----------------------------------------------");
    }

    // --- MANAJEMEN MAHASISWA ---
    private static void menuMahasiswa() {
        int pil;
        do {
            System.out.println("\n--- MANAJEMEN MAHASISWA ---");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Daftar Mahasiswa");
            System.out.println("3. Edit Data Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pil = inputInt();

            switch (pil) {
                case 1: tambahMahasiswa(); break;
                case 2: tampilkanDaftarMahasiswa(); break;
                case 3: editMahasiswa(); break;
                case 4: hapusMahasiswa(); break;
            }
        } while (pil != 0);
    }

    private static void tambahMahasiswa() {
        System.out.println("\n[Tambah Mahasiswa]");
        System.out.print("Nama: "); String nama = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("NIM: "); String nim = scanner.nextLine();
        System.out.print("Kelas: "); String kelas = scanner.nextLine();
        System.out.print("Prodi: "); String prodi = scanner.nextLine();
        System.out.print("Angkatan: "); String angkatan = scanner.nextLine();
        String id = "U" + (daftarMahasiswa.size() + 1);
        daftarMahasiswa.add(new Mahasiswa(id, nama, email, "pass", nim, kelas, prodi, angkatan));
        System.out.println("Berhasil menambahkan " + nama);
    }

    private static void tampilkanDaftarMahasiswa() {
        System.out.println("\n--- DAFTAR MAHASISWA ---");
        if (daftarMahasiswa.isEmpty()) System.out.println("Kosong.");
        for (Mahasiswa m : daftarMahasiswa) {
            System.out.println("NIM: " + m.getNim() + " | Nama: " + m.getNama() + " | Kelas: " + m.getKelas() + " | Prodi: " + m.getProdi());
        }
    }

    private static void editMahasiswa() {
        System.out.print("\nMasukkan NIM Mahasiswa yang akan diedit: ");
        String nim = scanner.nextLine();
        Mahasiswa m = null;
        for (Mahasiswa item : daftarMahasiswa) {
            if (item.getNim().equals(nim)) { m = item; break; }
        }

        if (m != null) {
            System.out.println("Data saat ini: " + m.getNama());
            System.out.print("Nama Baru (kosongkan jika tidak diubah): ");
            String nama = scanner.nextLine();
            if (!nama.isEmpty()) m.setNama(nama);

            System.out.print("Kelas Baru (kosongkan jika tidak diubah): ");
            String kelas = scanner.nextLine();
            if (!kelas.isEmpty()) m.setKelas(kelas);

            System.out.print("Prodi Baru (kosongkan jika tidak diubah): ");
            String prodi = scanner.nextLine();
            if (!prodi.isEmpty()) m.setProdi(prodi);

            System.out.println("Data berhasil diperbarui!");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    private static void hapusMahasiswa() {
        System.out.print("\nMasukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getNim().equals(nim)) {
                daftarMahasiswa.remove(i);
                System.out.println("Mahasiswa berhasil dihapus.");
                return;
            }
        }
        System.out.println("NIM tidak ditemukan.");
    }

    // --- MANAJEMEN KELOMPOK ---
    private static void menuKelompok() {
        int pil;
        do {
            System.out.println("\n--- MANAJEMEN KELOMPOK ---");
            System.out.println("1. Buat Kelompok Baru (+ Anggota)");
            System.out.println("2. Lihat Info Kelompok");
            System.out.println("3. Edit Topik Kelompok");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pil = inputInt();
            switch (pil) {
                case 1: buatKelompokLengkap(); break;
                case 2: tampilkanDaftarKelompok(); break;
                case 3: ubahTopikKelompok(); break;
            }
        } while (pil != 0);
    }

    private static void buatKelompokLengkap() {
        System.out.println("\n[Buat Kelompok Baru]");
        System.out.print("Nama Kelompok: "); String nama = scanner.nextLine();
        System.out.print("Topik: "); String topik = scanner.nextLine();
        Kelompok k = new Kelompok(nextKelompokId++, nama, topik);
        System.out.println("Pilih Anggota (ketik NIM, 'selesai' untuk berhenti):");
        tampilkanDaftarMahasiswa();
        while (true) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            if (nim.equalsIgnoreCase("selesai")) break;
            Mahasiswa found = null;
            for (Mahasiswa m : daftarMahasiswa) { if (m.getNim().equals(nim)) { found = m; break; } }
            if (found != null) k.tambahAnggota(found);
            else System.out.println("NIM tidak ditemukan.");
        }
        daftarKelompok.add(k);
        System.out.println("Kelompok " + nama + " dibuat.");
    }

    private static void tampilkanDaftarKelompok() {
        System.out.println("\n--- DAFTAR KELOMPOK ---");
        if (daftarKelompok.isEmpty()) System.out.println("Kosong.");
        for (Kelompok k : daftarKelompok) k.tampilkanInfoKelompok();
    }

    private static void ubahTopikKelompok() {
        System.out.print("ID Kelompok: ");
        int id = inputInt();
        for (Kelompok k : daftarKelompok) {
            if (k.getIdKelompok() == id) {
                System.out.print("Topik Baru: ");
                k.ubahTopikPresentasi(scanner.nextLine());
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    // --- MANAJEMEN JADWAL ---
    private static void menuPresentasi() {
        int pil;
        do {
            System.out.println("\n--- MANAJEMEN JADWAL PRESENTASI ---");
            System.out.println("1. Buat Jadwal Presentasi");
            System.out.println("2. Lihat Semua Jadwal");
            System.out.println("3. Unggah Materi Presentasi");
            System.out.println("4. Hapus Jadwal");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pil = inputInt();
            switch (pil) {
                case 1: buatJadwalPresentasi(); break;
                case 2: tampilkanJadwalPresentasi(); break;
                case 3: unggahMateriJadwal(); break;
                case 4: hapusJadwalPresentasi(); break;
            }
        } while (pil != 0);
    }

    private static void buatJadwalPresentasi() {
        if (daftarKelompok.isEmpty()) { System.out.println("Buat kelompok dulu!"); return; }
        System.out.println("\n[Pilih Kelompok]");
        for (Kelompok k : daftarKelompok) System.out.println(k.getIdKelompok() + ". " + k.getNamaKelompok());
        System.out.print("ID Kelompok: ");
        int idK = inputInt();
        Kelompok selK = null;
        for (Kelompok k : daftarKelompok) { if (k.getIdKelompok() == idK) { selK = k; break; } }
        if (selK == null) return;

        System.out.print("Tanggal (dd/mm/yyyy): ");
        String tglStr = scanner.nextLine();
        Date tgl;
        try { tgl = dateFormat.parse(tglStr); } catch (Exception e) { tgl = new Date(); }

        System.out.print("Lokasi: "); String lok = scanner.nextLine();
        System.out.print("Waktu (HH:MM): "); String jam = scanner.nextLine();
        
        System.out.println("Pilih Dosen Penguji:");
        for (int i = 0; i < daftarDosen.size(); i++) {
            System.out.println((i+1) + ". " + daftarDosen.get(i).getNama());
        }
        System.out.print("Pilih Nomor Dosen: ");
        int idxD = inputInt() - 1;
        Dosen d = (idxD >= 0 && idxD < daftarDosen.size()) ? daftarDosen.get(idxD) : daftarDosen.get(0);
        
        Presentasi p = new Presentasi(nextPresentasiId++, tgl, jam, jam, lok, selK, d);
        daftarPresentasi.add(p);
        p.buatjadwal();
    }

    private static void tampilkanJadwalPresentasi() {
        System.out.println("\n--- JADWAL PRESENTASI LENGKAP ---");
        if (daftarPresentasi.isEmpty()) System.out.println("Kosong.");
        for (Presentasi p : daftarPresentasi) {
            System.out.println("-----------------------------------------------");
            System.out.println("ID Presentasi: " + p.getIdPresentasi());
            System.out.println("Kelompok     : " + p.getKelompok().getNamaKelompok());
            System.out.println("Topik        : " + p.getKelompok().getTopikPresentasi());
            System.out.println("Tanggal      : " + dateFormat.format(p.getTanggal()));
            System.out.println("Lokasi       : " + p.getLokasi());
            System.out.println("Dosen Penguji: " + p.getDosenPenguji().getNama());
            System.out.println("Materi       : " + p.getMateriPresentasi());
            System.out.println("-----------------------------------------------");
        }
    }

    private static void unggahMateriJadwal() {
        tampilkanJadwalPresentasi();
        System.out.print("Masukkan ID Presentasi untuk unggah materi: ");
        int id = inputInt();
        for (Presentasi p : daftarPresentasi) {
            if (p.getIdPresentasi() == id) {
                System.out.print("Masukkan Nama File/Link Materi: ");
                p.unggahMateri(scanner.nextLine());
                return;
            }
        }
        System.out.println("ID tidak ditemukan.");
    }

    private static void hapusJadwalPresentasi() {
        System.out.print("ID Presentasi: ");
        int id = inputInt();
        for (int i = 0; i < daftarPresentasi.size(); i++) {
            if (daftarPresentasi.get(i).getIdPresentasi() == id) {
                daftarPresentasi.get(i).hapusJadwak();
                daftarPresentasi.remove(i);
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    // --- MANAJEMEN PENILAIAN ---
    private static void menuPenilaian() {
        int pil;
        do {
            System.out.println("\n--- MANAJEMEN PENILAIAN ---");
            System.out.println("1. Beri Nilai Kelompok");
            System.out.println("2. Lihat Nilai Semua Kelompok");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");
            pil = inputInt();
            switch (pil) {
                case 1: beriNilaiKelompok(); break;
                case 2: lihatNilaiKelompok(); break;
            }
        } while (pil != 0);
    }

    private static void beriNilaiKelompok() {
        tampilkanJadwalPresentasi();
        System.out.print("ID Presentasi untuk dinilai: ");
        int id = inputInt();
        for (Presentasi p : daftarPresentasi) {
            if (p.getIdPresentasi() == id) {
                System.out.print("Masukkan Nilai (0-100): ");
                p.beriNilai((float) scanner.nextDouble());
                return;
            }
        }
        System.out.println("Tidak ditemukan.");
    }

    private static void lihatNilaiKelompok() {
        System.out.println("\n--- DAFTAR NILAI PRESENTASI ---");
        if (daftarPresentasi.isEmpty()) System.out.println("Belum ada data nilai.");
        for (Presentasi p : daftarPresentasi) {
            System.out.println("Kelompok: " + p.getKelompok().getNamaKelompok() + 
                               " | Topik: " + p.getKelompok().getTopikPresentasi() +
                               " | Dosen: " + p.getDosenPenguji().getNama() +
                               " | Nilai: " + (p.getNilai() == 0 ? "Belum Dinilai" : p.getNilai()));
        }
    }
}
