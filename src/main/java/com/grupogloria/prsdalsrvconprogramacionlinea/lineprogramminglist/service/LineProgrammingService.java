package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.service;

import java.util.List;

import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.exception.SqlException;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseAdvanceSummaryDto;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseLineProgrammingDto;

public interface LineProgrammingService {

        ResponseAdvanceSummaryDto getAdvanceLineProgrammingByFilters(
                        String productionDate)
                        throws SqlException, Exception;

        List<ResponseLineProgrammingDto> getLinesProgrammingByFilters(
                        String productionDate)
                        throws SqlException, Exception;
}
