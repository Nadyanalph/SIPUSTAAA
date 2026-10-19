package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    //Memproses seluruh koleksi secara polimorfik (tanpa percabangan tipe). 
    public void cetakStatus() {
        for (Koleksi k : daftar) {
            String status = k.layakDipinjam() ? "LAYAK DIPINJAM" : "TIDAK LAYAK";
            System.out.println(k.deskripsi() + " => " + status);
        }
    }

    //Aturan pengurutan ditentukan dari luar lewat Comparator.
    public void urut(Comparator<? super Koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul(), k.getKode());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul(), k.getKode(), k.alasanTidakLayak());
        }
        k.setSedangDipinjam(true);
    }

    public void kembalikan(String kode) throws PustakaException {
        cari(kode).setSedangDipinjam(false);
    }

    private Koleksi cari(String kode) throws PustakaException {
        for (Koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
    }
}
