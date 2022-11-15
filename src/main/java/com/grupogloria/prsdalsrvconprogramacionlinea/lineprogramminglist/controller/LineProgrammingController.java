package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.aop.logging.LogMethodCall;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.constants.GlobalConstants;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.exception.SqlException;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.service.LineProgrammingService;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.CustomResponse;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.Util;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseAdvanceSummaryDto;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin
@Api(tags = "Line Programming API")
public class LineProgrammingController {

    @Autowired
    private LineProgrammingService lineProgrammingService;

    @LogMethodCall
    @GetMapping("/line-programming/advance")
    public CustomResponse<ResponseAdvanceSummaryDto> getAdvanceLineProgramming(
            @RequestParam(name = "fechaProduccion") String productionDate,
            HttpServletRequest request, HttpServletResponse response)
            throws SqlException, Exception {
        ResponseAdvanceSummaryDto advance;
        try {
            advance = lineProgrammingService.getAdvanceLineProgrammingByFilters(productionDate);

        } catch (Exception e) {
            response.setStatus(GlobalConstants.INTERNAL_ERROR);
            return new CustomResponse<>(
                    GlobalConstants.INTERNAL_ERROR,
                    Util.getStatusCode(GlobalConstants.INTERNAL_ERROR),
                    Util.getStatusCodeErrorDescription(GlobalConstants.INTERNAL_ERROR, e.getMessage()),
                    request.getHeader(GlobalConstants.ID_TRANSACTION),
                    Util.getDate());
        }

        return new CustomResponse<>(
                GlobalConstants.OK,
                Util.getStatusCode(GlobalConstants.OK),
                "Avance linea de programacion",
                request.getHeader(GlobalConstants.ID_TRANSACTION),
                Util.getDate(),
                advance);
    }

}
