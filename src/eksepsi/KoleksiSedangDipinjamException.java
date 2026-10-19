package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul, String kode) {
        super("Maaf, \"" + judul + "\" (" + kode + ") sedang dipinjam orang lain. "
                + "Silakan coba lagi setelah koleksi ini dikembalikan.");
    }
}
