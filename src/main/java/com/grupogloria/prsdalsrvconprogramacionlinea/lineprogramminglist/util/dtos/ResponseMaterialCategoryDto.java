package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMaterialCategoryDto {

    // @Length(min = 3, max = 3)
    private String codCatMaterial;

    private String materialCategory;

    private Boolean canceledFlag;

}
