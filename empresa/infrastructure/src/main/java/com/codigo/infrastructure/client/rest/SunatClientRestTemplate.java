package com.codigo.infrastructure.client.rest;

import com.codigo.infrastructure.client.dto.SunatResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SunatClientRestTemplate {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL_SUNAT = "https://api.apis.net.pe/v2/sunat/ruc/full?numero={numero}";
    private static final String TOKEN = "Bearer apis-token-15065.GzfyrVK1NmEhrQbDwpWaXgpOGofuTJRN";

    public SunatResponse getEmpresa(String numeroRuc) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", TOKEN);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<SunatResponse> response = restTemplate.exchange(
                URL_SUNAT,
                HttpMethod.GET,
                entity,
                SunatResponse.class,
                numeroRuc
        );

        return response.getBody();
    }
}
