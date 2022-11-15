package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource({ "classpath:application.properties" })
public class ServiceConfig {

    @Value("${prsdalsrvconproducto.service.url}")
    private String productoServiceUrl;
}
