package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ResponseSchedulingShiftMaterialDto {

    private ResponseTurnDto turno;

    private ResponseSupervisorDto supervisor;

    private ResponseMaterialDto material;

    private Long idMaterial;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaFinal;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaInicio;

    private String idEstadoProgramacion;

    private Integer ingreso;

    private Integer produccion;

    private String teorico;

    private Integer minutosJust;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaProduccion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaDocumento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaContabilizacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaVencimiento;

    private Integer velocidad;

    private Integer tiempoCNV;

    private Integer tiempoTD;

    private Integer tiempoPP;

    private Integer tiempoPNP;

    private Integer tiempoTTT;

    private String codCargaData;

    private Boolean flgAnulado;
}
