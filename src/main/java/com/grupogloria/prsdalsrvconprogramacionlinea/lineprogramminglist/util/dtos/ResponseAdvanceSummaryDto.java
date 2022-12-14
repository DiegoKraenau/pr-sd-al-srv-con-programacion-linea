package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import java.util.List;

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
public class ResponseAdvanceSummaryDto {

    private List<ResponseLineProgrammingDto> lineas;
}
