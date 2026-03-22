public class Pengguna {
    private String idPengguna;
    private String nama;
    private String email;
    private String password;

    public Pengguna(String idPengguna, String nama, String email, String password) {
        this.idPengguna = idPengguna;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getIdPengguna() {
        return idPengguna;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Methods
    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(nama + " berhasil logout.");
    }

    public void ubahProfil(String newNama, String newEmail) {
        this.nama = newNama;
        this.email = newEmail;
        System.out.println("Profil " + idPengguna + " berhasil diubah.");
    }

    @Override
    public String toString() {
        return "ID: " + idPengguna + ", Nama: " + nama + ", Email: " + email;
    }
}
