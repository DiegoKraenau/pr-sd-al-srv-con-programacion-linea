package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "supervisor")
@JsonInclude(Include.NON_EMPTY)
public class SupervisorEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_supervisor")
    private Long codSupervisor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "abrev")
    private String abrev;

    @Column(name = "flg_anulado")
    private Boolean flgAnulado;

    // TODO: Falta id_seccion_produccion
}
