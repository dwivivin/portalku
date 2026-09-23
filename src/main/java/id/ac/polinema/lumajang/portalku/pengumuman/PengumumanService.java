package id.ac.polinema.lumajang.portalku.pengumuman;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import id.ac.polinema.lumajang.portalku.pengumuman.dto.PengumumanResponseDto;

@Service
public class PengumumanService {

    @Autowired
    private PengumumanRepository pengumumanRepository;

    @Transactional(readOnly = true)
    public List<PengumumanResponseDto> ambilSemuaPengumumanDto() {
        List<Pengumuman> daftarPengumuman = pengumumanRepository.findAllWithKategoriAndLampiran();

        // Mapping dari Entity ke DTO
        return daftarPengumuman.stream().map(p -> new PengumumanResponseDto(
                p.getId(),
                p.getJudul(),
                p.getIsi(),
                p.getTanggalTerbit(),
                p.getJumlahDilihat(),
                p.getKategori() != null ? p.getKategori().getNama() : null,
                p.getDaftarLampiran() != null ? p.getDaftarLampiran().size() : 0
        )).toList();
    }
}