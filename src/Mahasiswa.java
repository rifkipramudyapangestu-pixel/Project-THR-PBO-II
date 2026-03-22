public class Mahasiswa extends Pengguna {
    private String nim;
    private String kelas;
    private String prodi;
    private String angkatan;

    public Mahasiswa(String idPengguna, String nama, String email, String password, String nim, String kelas, String prodi, String angkatan) {
        super(idPengguna, nama, email, password);
        this.nim = nim;
        this.kelas = kelas;
        this.prodi = prodi;
        this.angkatan = angkatan;
    }

    // Getters
    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getProdi() {
        return prodi;
    }

    public String getAngkatan() {
        return angkatan;
    }

    // Setters
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    // Methods
    public void daftarKelompok(String namaKelompok) {
        System.out.println(getNama() + " (" + nim + ") mendaftar ke kelompok: " + namaKelompok);
    }

    public void lihatJadwalPresentasi() {
        System.out.println(getNama() + " (" + nim + ") melihat jadwal presentasi.");
    }

    public void uploadMateriPresentasi(String judulMateri) {
        System.out.println(getNama() + " (" + nim + ") mengunggah materi: " + judulMateri);
    }

    @Override
    public String toString() {
        return "Mahasiswa [NIM: " + nim + ", Nama: " + getNama() + ", Kelas: " + kelas + ", Prodi: " + prodi + ", Angkatan: " + angkatan + "]";
    }
}
