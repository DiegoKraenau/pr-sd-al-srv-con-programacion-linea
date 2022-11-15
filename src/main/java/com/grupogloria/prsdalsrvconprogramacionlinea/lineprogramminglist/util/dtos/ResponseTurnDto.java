package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTurnDto {
    private String codTurno;

    private Integer sec;

    private String turno;

    private Timestamp horaInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaFin;

    private Boolean flgAnulado;
}
