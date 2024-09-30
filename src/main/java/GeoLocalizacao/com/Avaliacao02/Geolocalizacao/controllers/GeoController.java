package GeoLocalizacao.com.Avaliacao02.Geolocalizacao.controllers;

import GeoLocalizacao.com.Avaliacao02.Geolocalizacao.services.GeoServices;
import GeoLocalizacao.com.Avaliacao02.Geolocalizacao.Coordenadas;
import GeoLocalizacao.com.Avaliacao02.Geolocalizacao.Localizacao;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/geolocaliza")
public class GeoController {

    @Autowired
    private GeoServices geoServices;

    // ENDPOINT PARA USAR COORDENADA COMO PARAMETRO, OU SEJA VOCÊ PASSA A LATITUDE E LONGITUDE E RECEBE O PAIS CIDADE E ESTADO.
    @GetMapping("/reverse")
    public JsonNode getPaisEstadoCidade(@RequestParam double lat, @RequestParam double lon) {
        return geoServices.getPaisEstadoCidade(lat, lon);
    }
    // ENDPOINT PARA USAR COORDENADA COMO JSON, OU SEJA VOCÊ PASSA A LATITUDE E LONGITUDE E RECEBE O PAIS CIDADE E ESTADO.
    @PostMapping("/reverse")
    public JsonNode getPaisEstadoCidadePost(@RequestBody Coordenadas coordinates) {
        return geoServices.getPaisEstadoCidade(coordinates.getLat(), coordinates.getLon());
    }

/*    // ENDPOINT PASSANDO CIDADE ESTADO E PAIS COMO PARAMETROS, E RECEBE A COORDENADA LONGITUDE E LATITUDE.
    @GetMapping("/geocode")
    public JsonNode geocode(@RequestParam String state, @RequestParam String city, @RequestParam String country) {
        return geoServices.geocodificar(state, city, country);
    }*/

/*    // ENDPOINT PASSANDO CIDADE ESTADO E PAIS COMO JSON, E RECEBE A COORDENADA LONGITUDE E LATITUDE.
    @PostMapping("/geocode")
    public JsonNode geocode(@RequestBody Localizacao localizacao) {
        return geoServices.geocodificar(localizacao.getEstado(), localizacao.getCidade(), localizacao.getPais());
    }*/
}