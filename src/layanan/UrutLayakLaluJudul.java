package layanan;

import model.Koleksi;

import java.util.Comparator;

/** Koleksi layak pinjam tampil lebih dulu, kemudian diurutkan berdasarkan judul. */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private final Comparator<Koleksi> berlapis =
            Comparator.comparing((Koleksi k) -> !k.layakDipinjam())   // false (layak) lebih dulu
                      .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return berlapis.compare(a, b);
    }
}
