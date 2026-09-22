package id.ac.polinema.lumajang.portalku.prodi;

import id.ac.polinema.lumajang.portalku.kurikulum.Kurikulum;
import id.ac.polinema.lumajang.portalku.kurikulum.KurikulumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class DataAwalProdiKurikulum implements CommandLineRunner {

    private final ProdiRepository prodiRepository;
    private final KurikulumRepository kurikulumRepository;

    public DataAwalProdiKurikulum(ProdiRepository prodiRepository, KurikulumRepository kurikulumRepository) {
        this.prodiRepository = prodiRepository;
        this.kurikulumRepository = kurikulumRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (prodiRepository.count() == 0) {
            // 1. Buat Data Prodi
            Prodi prodiD4 = new Prodi();
            prodiD4.setKode("TRPL");
            prodiD4.setNama("Teknologi Rekayasa Perangkat Lunak");
            prodiD4.setJenjang("D4");

            // 2. Buat Data Kurikulum & Hubungkan ke Prodi
            Kurikulum k1 = new Kurikulum("Kurikulum 2020", 2020, prodiD4);
            Kurikulum k2 = new Kurikulum("Kurikulum Merdeka 2024", 2024, prodiD4);

            prodiD4.tambahKurikulum(k1);
            prodiD4.tambahKurikulum(k2);

            // 3. Simpan Prodi (Kurikulum otomatis tersimpan via CascadeType.ALL)
            prodiRepository.save(prodiD4);
        }
    }
}