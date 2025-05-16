package com.codigo.infrastructure.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SunatResponse {
    private String razonSocial;
    private String numeroDocumento;
    private String estado;
    private String condicion;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito;
    private String actividadEconomica;
    private int numeroTrabajadores;
}
