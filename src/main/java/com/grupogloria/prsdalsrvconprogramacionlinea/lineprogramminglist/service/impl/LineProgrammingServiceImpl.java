package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.hibernate.exception.JDBCConnectionException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.aop.logging.ElkLogger;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.client.ProductClient;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain.LineProgrammingEntity;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.exception.SqlException;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.repository.LineProgrammingRepository;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.service.LineProgrammingService;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.Util;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseAdvanceSummaryDto;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseLineProgrammingDto;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseMaterialDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LineProgrammingServiceImpl implements LineProgrammingService {

    @Autowired
    LineProgrammingRepository LineProgrammingRepository;

    @Autowired
    private ProductClient productClient;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseAdvanceSummaryDto getAdvanceLineProgrammingByFilters(String productionDate)
            throws SqlException, Exception {

        try {

            List<ResponseLineProgrammingDto> linesProgramming = getLinesProgrammingByFilters(productionDate);

            return ResponseAdvanceSummaryDto
                    .builder()
                    .lineas(linesProgramming)
                    .build();

        } catch (CannotCreateTransactionException | JDBCConnectionException ex) {
            ElkLogger.log(Level.ERROR, ElkLogger.getStackTrace(ex), this.getClass().getName(), ex);
            throw new SqlException("Connection Falied Please Try Later");
        } catch (Exception e) {
            ElkLogger.log(Level.ERROR, ElkLogger.getStackTrace(e), this.getClass().getName(), e);
            throw new SqlException("Data Issue Please Try Later");
        }
    }

    @Override
    public List<ResponseLineProgrammingDto> getLinesProgrammingByFilters(String productionDate)
            throws SqlException, Exception {

        try {
            List<LineProgrammingEntity> linesProgramming = LineProgrammingRepository
                    .findAllByFilters(Util.transformDate(productionDate));

            return linesProgramming
                    .stream()
                    .map(lineProgramming -> {
                        ResponseLineProgrammingDto res = modelMapper.map(lineProgramming,
                                ResponseLineProgrammingDto.class);

                        res.getTurnos().stream().forEach(turn -> {
                            try {
                                ResponseMaterialDto material = productClient
                                        .findMaterial(turn.getIdMaterial());
                                turn.setMaterial(material);
                            } catch (Exception e) {
                                throw new RuntimeException(e.getMessage());
                            }

                        });

                        return res;
                    })
                    .collect(Collectors.toList());

        } catch (CannotCreateTransactionException | JDBCConnectionException ex) {
            ElkLogger.log(Level.ERROR, ElkLogger.getStackTrace(ex), this.getClass().getName(), ex);
            throw new SqlException("Connection Falied Please Try Later");
        } catch (Exception e) {
            ElkLogger.log(Level.ERROR, ElkLogger.getStackTrace(e), this.getClass().getName(), e);
            throw new SqlException("Data Issue Please Try Later");
        }
    }

}
