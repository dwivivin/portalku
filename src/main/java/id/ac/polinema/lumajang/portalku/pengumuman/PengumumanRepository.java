package id.ac.polinema.lumajang.portalku.pengumuman;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PengumumanRepository extends JpaRepository<Pengumuman, Integer> {

    // Metode repository dengan JOIN FETCH untuk menghindari masalah N+1
    @Query("SELECT p FROM Pengumuman p JOIN FETCH p.kategori LEFT JOIN FETCH p.daftarLampiran")
    List<Pengumuman> findAllWithKategoriAndLampiran();
}