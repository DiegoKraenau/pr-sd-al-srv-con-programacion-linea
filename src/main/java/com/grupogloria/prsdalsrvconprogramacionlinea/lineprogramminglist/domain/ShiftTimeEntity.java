package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain.helpers.ShiftTimeId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turno_hora")
@JsonInclude(Include.NON_EMPTY)
@IdClass(ShiftTimeId.class)
public class ShiftTimeEntity extends AuditEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_turno", nullable = false)
    @JsonManagedReference
    private TurnEntity turno;

    @Id
    @Column(name = "hora_inicio", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp horaInicio;

    @Column(name = "hora_final", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaFinal;

    @Column(name = "desc_hora")
    @Length(max = 15)
    private String descHora;

    @Column(name = "orden_hora")
    private Integer ordenHora;

    @Column(name = "flg_anulado")
    private Boolean flgAnulado;

}
