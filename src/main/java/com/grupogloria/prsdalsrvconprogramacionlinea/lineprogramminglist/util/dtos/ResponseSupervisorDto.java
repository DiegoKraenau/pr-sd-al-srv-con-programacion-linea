package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class ResponseSupervisorDto {

    private Long codSupervisor;

    private String nombre;

    private String abrev;

    private Boolean flgAnulado;
}
