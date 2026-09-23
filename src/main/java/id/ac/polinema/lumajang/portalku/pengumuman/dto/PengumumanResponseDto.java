package id.ac.polinema.lumajang.portalku.pengumuman.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PengumumanResponseDto {
    private Long id;              // Harus Long (bukan Integer)
    private String judul;
    private String isi;
    private LocalDate tanggalTerbit;
    private Integer jumlahDilihat;
    private String namaKategori;
    private int jumlahLampiran;   // Harus int (bukan long)
}