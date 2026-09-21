package id.ac.polinema.lumajang.portalku.prodi;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.ac.polinema.lumajang.portalku.kurikulum.Kurikulum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "program_studi")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prodi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 25, unique = true)
    private String kode;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false, length = 5)
    public String jenjang; // ubah dari private String jenjang;

    @OneToMany(mappedBy = "prodi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Kurikulum> daftarKurikulum = new ArrayList<>();

    public Prodi(String kode, String nama, String jenjang) {
        this.kode = kode;
        this.nama = nama;
        this.jenjang = jenjang;
    }

    public void tambahKurikulum(Kurikulum kurikulum) {
        daftarKurikulum.add(kurikulum);
        kurikulum.setProdi(this);
    }
}