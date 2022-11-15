package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSupervisorDto {

    private Long codSupervisor;

    private String nombre;

    private String abrev;

    private Boolean flgAnulado;
}
