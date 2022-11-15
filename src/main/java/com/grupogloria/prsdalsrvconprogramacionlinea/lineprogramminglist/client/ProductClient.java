package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.configuration.ServiceConfig;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.exception.SqlException;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.CustomResponse;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.util.dtos.ResponseMaterialDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProductClient {

    private RestTemplate restTemplate;

    @Autowired
    private ServiceConfig config;

    public ProductClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public ResponseMaterialDto findMaterial(Long id) throws SqlException, Exception {
        CustomResponse<ResponseMaterialDto> customResult;
        try {
            customResult = restTemplate.exchange(config.getProductoServiceUrl() + "material/{id}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<CustomResponse<ResponseMaterialDto>>() {
                    }, id).getBody();
        } catch (Exception ex) {
            throw ex;
        }
        return customResult.getData();
    }
}
