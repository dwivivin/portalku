package id.ac.polinema.lumajang.portalku.kurikulum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.ac.polinema.lumajang.portalku.prodi.Prodi;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kurikulum")
@Getter
@Setter
@NoArgsConstructor
public class Kurikulum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nama;

    @Column(nullable = false)
    private Integer tahun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodi_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Prodi prodi;

    // Konstruktor ini yang akan menghilangkan garis merah di DataAwalProdiKurikulum.java
    public Kurikulum(String nama, Integer tahun, Prodi prodi) {
        this.nama = nama;
        this.tahun = tahun;
        this.prodi = prodi;
    }
}