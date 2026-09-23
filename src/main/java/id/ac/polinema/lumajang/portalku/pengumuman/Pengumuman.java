package id.ac.polinema.lumajang.portalku.pengumuman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Impor entitas lain jika berada di package terpisah (sesuaikan jika diperlukan)
import id.ac.polinema.lumajang.portalku.prodi.Prodi;

@Entity
@Table(name = "pengumuman")
@Getter
@Setter
@NoArgsConstructor
public class Pengumuman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String judul;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String isi;

    @Column(name = "tanggal_terbit", nullable = false)
    private LocalDate tanggalTerbit;

    @Column(name = "jumlah_dilihat", nullable = false)
    private Integer jumlahDilihat = 0;

    // Relasi ManyToOne ke Kategori (Sisi pemilik relasi)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_kategori", nullable = false)
    private Kategori kategori;

    // Relasi OneToMany ke Lampiran dengan Cascade & Orphan Removal
    @OneToMany(mappedBy = "pengumuman", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Lampiran> daftarLampiran = new ArrayList<>();

    // Relasi ManyToMany ke Prodi (Tanpa Cascade.REMOVE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pengumuman_prodi",
        joinColumns = @JoinColumn(name = "id_pengumuman"),
        inverseJoinColumns = @JoinColumn(name = "id_prodi")
    )
    private Set<Prodi> prodiTujuan = new HashSet<>();

    // Metode Bantu Konsistensi Lampiran
    public void tambahLampiran(Lampiran lampiran) {
        daftarLampiran.add(lampiran);
        lampiran.setPengumuman(this);
    }

    public void hapusLampiran(Lampiran lampiran) {
        daftarLampiran.remove(lampiran);
        lampiran.setPengumuman(null);
    }
}