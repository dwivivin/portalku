package id.ac.polinema.lumajang.portalku.prodi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdiController {
    private Integer id;
    private String kode;
    private String nama;
    private Prodi.Jenjang jenjang;
    private int jumlahKurikulum;

    public ProdiController() {
    }

    public ProdiController(Integer id, String kode, String nama, Prodi.Jenjang jenjang, int jumlahKurikulum) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.jenjang = jenjang;
        this.jumlahKurikulum = jumlahKurikulum;
    }
}