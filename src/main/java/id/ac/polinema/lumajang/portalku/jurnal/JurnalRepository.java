package id.ac.polinema.lumajang.portalku.jurnal;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurnalRepository extends JpaRepository<jurnal, Integer> {
    List<jurnal> findByPenerbit(String penerbit);
    List<jurnal> findByJudulContainingIgnoreCase(String kataKunci);
}