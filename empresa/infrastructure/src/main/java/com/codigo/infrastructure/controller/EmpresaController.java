package com.codigo.infrastructure.controller;

import com.codigo.infrastructure.client.dto.SunatResponse;
import com.codigo.infrastructure.client.feign.SunatClientFeign;
import com.codigo.infrastructure.client.rest.SunatClientRestTemplate;
import com.codigo.infrastructure.client.retrofit.SunatClientRetrofit;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    private final SunatClientRestTemplate sunatRestTemplate;
    private final SunatClientFeign sunatFeign;
    private final SunatClientRetrofit sunatRetrofit;

    public EmpresaController(SunatClientRestTemplate sunatRestTemplate,
                             SunatClientFeign sunatFeign,
                             SunatClientRetrofit sunatRetrofit) {
        this.sunatRestTemplate = sunatRestTemplate;
        this.sunatFeign = sunatFeign;
        this.sunatRetrofit = sunatRetrofit;
    }

    @GetMapping("/resttemplate/{ruc}")
    public SunatResponse obtenerEmpresaRestTemplate(@PathVariable String ruc) {
        return sunatRestTemplate.getEmpresa(ruc);
    }

    @GetMapping("/feign/{ruc}")
    public SunatResponse obtenerEmpresaFeign(@PathVariable String ruc) {
        String token = "Bearer apis-token-15065.GzfyrVK1NmEhrQbDwpWaXgpOGofuTJRN";
        return sunatFeign.getEmpresaPorRuc(ruc, token);
    }

    @GetMapping("/retrofit/{ruc}")
    public SunatResponse obtenerEmpresaRetrofit(@PathVariable String ruc) {
        String token = "Bearer apis-token-15065.GzfyrVK1NmEhrQbDwpWaXgpOGofuTJRN";
        try {
            return sunatRetrofit.getEmpresa(ruc, token).execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
