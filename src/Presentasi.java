import java.util.Date;

public class Presentasi {
    private int idPresentasi;
    private Date tanggal;
    private String waktuMulai;
    private String waktuSelesai;
    private String lokasi;
    private String materiPresentasi;
    private Dosen dosenPenguji;
    private float nilai;
    private Kelompok kelompok; // Relationship based on "untuk"

    public Presentasi(int idPresentasi, Date tanggal, String waktuMulai, String waktuSelesai, String lokasi, Kelompok kelompok, Dosen dosenPenguji) {
        this.idPresentasi = idPresentasi;
        this.tanggal = tanggal;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.lokasi = lokasi;
        this.kelompok = kelompok;
        this.dosenPenguji = dosenPenguji;
        this.materiPresentasi = "Belum diunggah";
        this.nilai = 0.0f;
    }

    // Getters
    public int getIdPresentasi() {
        return idPresentasi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public Kelompok getKelompok() {
        return kelompok;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public float getNilai() {
        return nilai;
    }

    public String getMateriPresentasi() {
        return materiPresentasi;
    }

    public Dosen getDosenPenguji() {
        return dosenPenguji;
    }

    // Methods based on Diagram
    public void buatjadwal() {
        System.out.println("Jadwal presentasi kelompok " + kelompok.getNamaKelompok() + " telah dibuat.");
    }

    public void ubahJadwal(Date newTanggal, String newWaktuMulai, String newWaktuSelesai, String newLokasi) {
        this.tanggal = newTanggal;
        this.waktuMulai = newWaktuMulai;
        this.waktuSelesai = newWaktuSelesai;
        this.lokasi = newLokasi;
        System.out.println("Jadwal presentasi kelompok " + kelompok.getNamaKelompok() + " telah diubah.");
    }

    public void hapusJadwak() { // Correcting to match the diagram's typo: "hapusJadwak()"
        System.out.println("Jadwal presentasi kelompok " + kelompok.getNamaKelompok() + " telah dihapus.");
    }

    public void unggahMateri(String materi) {
        this.materiPresentasi = materi;
        System.out.println("Materi presentasi untuk " + kelompok.getNamaKelompok() + " berhasil diunggah.");
    }

    public void beriNilai(float nilai) {
        this.nilai = nilai;
        System.out.println("Presentasi kelompok " + kelompok.getNamaKelompok() + " telah diberi nilai: " + nilai);
    }

    @Override
    public String toString() {
        return "Presentasi [ID: " + idPresentasi + ", Kelompok: " + kelompok.getNamaKelompok() + ", Lokasi: " + lokasi + ", Nilai: " + nilai + "]";
    }
}
