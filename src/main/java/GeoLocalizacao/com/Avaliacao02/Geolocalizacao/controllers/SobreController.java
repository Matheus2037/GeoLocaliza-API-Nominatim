package GeoLocalizacao.com.Avaliacao02.Geolocalizacao.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SobreController {

    @GetMapping("/sobre")
    public Map<String, String> sobre() {
        Map<String, String> dados = new HashMap<>();
        dados.put("estudante", "Matheus da Silva Gastaldi");
        dados.put("projeto", "Geolocalizacao");
        return dados;
    }
}
