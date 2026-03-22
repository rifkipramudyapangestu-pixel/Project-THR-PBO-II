public class Dosen extends Pengguna {
    private String nidn;
    private String departemen;

    public Dosen(String idPengguna, String nama, String email, String password, String nidn, String departemen) {
        super(idPengguna, nama, email, password);
        this.nidn = nidn;
        this.departemen = departemen;
    }

    // Getters
    public String getNidn() {
        return nidn;
    }

    public String getDepartemen() {
        return departemen;
    }

    // Setters
    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    // Methods
    public void verifikasiKelompok(Kelompok kelompok) {
        System.out.println(getNama() + " (" + nidn + ") memverifikasi kelompok: " + kelompok.getNamaKelompok());
    }

    public void aturJadwalPresentasi(Presentasi presentasi, String newTanggal, String newWaktuMulai, String newWaktuSelesai, String newLokasi) {
        // Simulasi pengaturan jadwal, dalam implementasi nyata akan memanggil method di kelas Presentasi
        System.out.println(getNama() + " (" + nidn + ") mengatur jadwal presentasi untuk kelompok " + presentasi.getKelompok().getNamaKelompok() + ".");
        // presentasi.ubahJadwal(new Date(newTanggal), newWaktuMulai, newWaktuSelesai, newLokasi);
    }

    public void beriNilaiPresentasi(Presentasi presentasi, float nilai) {
        presentasi.beriNilai(nilai);
        System.out.println(getNama() + " (" + nidn + ") memberikan nilai " + nilai + " untuk presentasi kelompok " + presentasi.getKelompok().getNamaKelompok());
    }

    @Override
    public String toString() {
        return "Dosen [NIDN: " + nidn + ", Nama: " + getNama() + ", Departemen: " + departemen + "]";
    }
}
