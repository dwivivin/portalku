package id.ac.polinema.lumajang.portalku.prodi;

public class ProdiRingkasDto {
    private Integer id;
    private String kode;
    private String nama;
    private String jenjang;
    private int jumlahKurikulum;

    public ProdiRingkasDto(Integer id, String kode, String nama, String jenjang, int jumlahKurikulum) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.jenjang = jenjang;
        this.jumlahKurikulum = jumlahKurikulum;
    }

    public Integer getId() { return id; }
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getJenjang() { return jenjang; }
    public int getJumlahKurikulum() { return jumlahKurikulum; }
}