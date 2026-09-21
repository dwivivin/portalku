package id.ac.polinema.lumajang.portalku.prodi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ProdiRepository extends JpaRepository<Prodi, Integer> {

    @Query("SELECT p FROM Prodi p LEFT JOIN FETCH p.daftarKurikulum WHERE p.id = :id")
    Optional<Prodi> findByIdWithKurikulum(@Param("id") Integer id);
}