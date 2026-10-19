package model;

/**
 * Kelas induk (abstract) untuk seluruh jenis koleksi perpustakaan.
 */
public abstract class Koleksi {
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    /** Aturan kelayakan pinjam, berbeda untuk setiap jenis koleksi. */
    public abstract boolean layakDipinjam();

    /** Alasan dalam bahasa awam mengapa koleksi tidak layak dipinjam. */
    public String alasanTidakLayak() {
        return "belum memenuhi syarat peminjaman";
    }

    /** Deskripsi dasar; diperluas oleh setiap turunan memakai super. */
    public String deskripsi() {
        return kode + " | \"" + judul + "\" (" + tahunTerbit + ")";
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }
    public void setSedangDipinjam(boolean sedangDipinjam) { this.sedangDipinjam = sedangDipinjam; }
}
