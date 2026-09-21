package id.ac.polinema.lumajang.portalku.kurikulum;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KurikulumRepository extends JpaRepository<Kurikulum, Integer> {

    List<Kurikulum> findByProdiId(Integer idProdi);

    @Query("SELECT k FROM Kurikulum k JOIN FETCH k.prodi")
    List<Kurikulum> findAllWithProdi();
}