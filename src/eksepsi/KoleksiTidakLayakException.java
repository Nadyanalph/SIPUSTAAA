package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul, String kode, String alasan) {
        super("Maaf, \"" + judul + "\" (" + kode + ") belum bisa dipinjam karena "
                + alasan + ".");
    }
}
