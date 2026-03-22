import java.util.ArrayList;
import java.util.List;

public class Kelompok {
    private int idKelompok;
    private String namaKelompok;
    private String topikPresentasi;
    private List<Mahasiswa> anggota;

    public Kelompok(int idKelompok, String namaKelompok, String topikPresentasi) {
        this.idKelompok = idKelompok;
        this.namaKelompok = namaKelompok;
        this.topikPresentasi = topikPresentasi;
        this.anggota = new ArrayList<>();
    }

    // Getters
    public int getIdKelompok() {
        return idKelompok;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public String getTopikPresentasi() {
        return topikPresentasi;
    }

    public List<Mahasiswa> getAnggota() {
        return anggota;
    }

    // Methods based on Diagram
    public void tambahAnggota(Mahasiswa mahasiswa) {
        if (!anggota.contains(mahasiswa)) {
            anggota.add(mahasiswa);
            System.out.println(mahasiswa.getNama() + " ditambahkan ke kelompok " + namaKelompok);
        }
    }

    public void hapusAnggota(Mahasiswa mahasiswa) {
        if (anggota.remove(mahasiswa)) {
            System.out.println(mahasiswa.getNama() + " dihapus dari kelompok " + namaKelompok);
        }
    }

    public void ubahTopikPresentasi(String newTopik) {
        this.topikPresentasi = newTopik;
        System.out.println("Topik presentasi kelompok " + namaKelompok + " diubah menjadi: " + newTopik);
    }

    public void tampilkanInfoKelompok() {
        System.out.println("--- Info Kelompok ---");
        System.out.println("ID: " + idKelompok);
        System.out.println("Nama: " + namaKelompok);
        System.out.println("Topik: " + topikPresentasi);
        System.out.print("Anggota: ");
        if (anggota.isEmpty()) {
            System.out.println("Tidak ada anggota");
        } else {
            for (int i = 0; i < anggota.size(); i++) {
                System.out.print(anggota.get(i).getNama() + (i < anggota.size() - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Kelompok [ID: " + idKelompok + ", Nama: " + namaKelompok + "]";
    }
}
