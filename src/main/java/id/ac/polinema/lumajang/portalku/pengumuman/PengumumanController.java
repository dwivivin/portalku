package id.ac.polinema.lumajang.portalku.pengumuman;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import id.ac.polinema.lumajang.portalku.pengumuman.dto.PengumumanResponseDto;

@RestController
@RequestMapping("/api/pengumuman")
public class PengumumanController {

    @Autowired
    private PengumumanService pengumumanService;

    @GetMapping
    public ResponseEntity<List<PengumumanResponseDto>> daftarPengumuman() {
        List<PengumumanResponseDto> list = pengumumanService.ambilSemuaPengumumanDto();
        return ResponseEntity.ok(list);
    }
}
