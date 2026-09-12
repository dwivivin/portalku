package id.ac.polinema.lumajang.portalku.jurnal;

import java.util.List;
import lombok.RequiredArgsConstructor; 
import org.springframework.stereotype.Service; 
  
@Service 
@RequiredArgsConstructor 
public class JurnalService { 
  
    private final JurnalRepository jurnalRepository; 
  
    public List<jurnal> cariSemua() { 
        return jurnalRepository.findAll(); 
    } 
  
    public jurnal cariSatu(Integer id) { 
        return jurnalRepository.findById(id) 
                .orElseThrow(() -> new JurnalTidakDitemukanException(id)); 
    } 
  
    public jurnal tambah(jurnal jurnal) { 
        jurnal.setId(null);          // id selalu ditentukan oleh penyimpanan 
        return jurnalRepository.save(jurnal); 
    } 
  
    public void hapus(Integer id) { 
        if (!jurnalRepository.deleteById(id)) { 
            throw new JurnalTidakDitemukanException(id); 
        } 
    } 
} 
