package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAdvanceSummaryDto {

    private List<ResponseLineProgrammingDto> lineas;
}
