package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turno")
@JsonInclude(Include.NON_EMPTY)
public class TurnEntity {

    @Id
    @Column(name = "cod_turno")
    @Length(max = 1)
    private String codTurno;

    @Column(name = "sec")
    private Integer sec;

    @Column(name = "turno")
    @Length(max = 10)
    private String turno;

    @Column(name = "hora_inicio", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaInicio;

    @Column(name = "hora_fin", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaFin;

    @Column(name = "flg_anulado")
    private Boolean flgAnulado;

}
