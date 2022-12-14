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
public class ResponseMaterialCategoryDto {

    // @Length(min = 3, max = 3)
    private String codCatMaterial;

    private String categoriaMaterial;

    private Boolean flgAnulado;

}
