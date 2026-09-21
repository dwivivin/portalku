package id.ac.polinema.lumajang.portalku.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/config-test")
public class ConfigTestController {

    private final AppProperties appProperties;

    public ConfigTestController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping
    public Map<String, Object> getConfig() {
        Map<String, Object> response = new HashMap<>();
        response.put("nama", appProperties.getNama());
        response.put("versi", appProperties.getVersi());
        response.put("maksItem", appProperties.getMaksItem());
        response.put("pesanSambutan", appProperties.getPesanSambutan());
        return response;
    }
}