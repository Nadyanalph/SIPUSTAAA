package model;

public class Majalah extends Koleksi implements Terarsip {
    private final int edisi;
    private final String bulanTerbit;
    private final String nomorRak;
    private final int lantai;
    private final boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, String nomorRak, int lantai,
                   boolean edisiTerbaru) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String alasanTidakLayak() {
        return "majalah ini adalah edisi terbaru dan belum boleh dibawa pulang";
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Majalah, edisi " + edisi + " (" + bulanTerbit + ") | " + ringkasanArsip();
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public int lokasiLantai() { return lantai; }

    public int getEdisi() { return edisi; }
    public String getBulanTerbit() { return bulanTerbit; }
    public boolean isEdisiTerbaru() { return edisiTerbaru; }
}
