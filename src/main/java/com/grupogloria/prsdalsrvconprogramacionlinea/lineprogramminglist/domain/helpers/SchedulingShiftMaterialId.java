package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain.helpers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingShiftMaterialId implements Serializable {

    private Long programacion;

    private String turno;

    private Long idMaterial;
}
