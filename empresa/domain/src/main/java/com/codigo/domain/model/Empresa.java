package com.codigo.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empresa {
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
