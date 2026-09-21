package id.ac.polinema.lumajang.portalku.prodi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prodi")
public class ProdiController {

    private final ProdiRepository prodiRepository;

    public ProdiController(ProdiRepository prodiRepository) {
        this.prodiRepository = prodiRepository;
    }

    @GetMapping("/{id}")
    public ProdiRingkasDto getProdiById(@PathVariable Integer id) {
        Prodi prodi = prodiRepository.findByIdWithKurikulum(id)
                .orElseThrow(() -> new RuntimeException("Prodi tidak ditemukan"));

        return new ProdiRingkasDto(
                prodi.getId(),
                prodi.getKode(),
                prodi.getNama(),
                prodi.getJenjang(),
                prodi.getDaftarKurikulum().size()
        );
    }
}