package com.codigo.infrastructure.client.feign;

import com.codigo.infrastructure.client.dto.SunatResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "sunat-client",
        url = "https://api.apis.net.pe/v2/sunat/ruc/full"
)
public interface SunatClientFeign {

    @GetMapping
    SunatResponse getEmpresaPorRuc(
            @RequestParam("numero") String ruc,
            @RequestHeader("Authorization") String token
    );
}
