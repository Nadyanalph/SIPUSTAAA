package layanan;

import model.Koleksi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        List<Koleksi> daftar = katalog.getDaftar();

        int lebarJudul = "Judul".length();
        int lebarJenis = "Jenis".length();
        for (Koleksi k : daftar) {
            lebarJudul = Math.max(lebarJudul, k.getJudul().length());
            lebarJenis = Math.max(lebarJenis, k.getClass().getSimpleName().length());
        }
        String format = "%-8s %-" + lebarJenis + "s %-" + lebarJudul + "s %-6s %-14s%n";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(format, "Kode", "Jenis", "Judul", "Tahun", "Status");
            out.println("-".repeat(8 + 1 + lebarJenis + 1 + lebarJudul + 1 + 6 + 1 + 14));
            for (Koleksi k : daftar) {
                out.printf(format,
                        k.getKode(),
                        k.getClass().getSimpleName(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.layakDipinjam() ? "Layak" : "Tidak Layak");
            }
        }
    }
}
