package GeoLocalizacao.com.Avaliacao02.Geolocalizacao.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.IOException;

@Service
public class GeoServices {

    private final RestTemplate restTemplate;

    public GeoServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JsonNode getPaisEstadoCidade(double latitude, double longitude) {
        String url = UriComponentsBuilder.fromHttpUrl("https://nominatim.openstreetmap.org/reverse")
                .queryParam("format", "json")
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        return extrairInformacoes(response);
    }

    private JsonNode extrairInformacoes(String jsonResponse) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);
            JsonNode address = root.path("address");

            return mapper.createObjectNode()
                    .put("pais", address.path("country").asText())
                    .put("estado", address.path("state").asText())
                    .put("cidade", address.path("city").asText("Não disponível"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}