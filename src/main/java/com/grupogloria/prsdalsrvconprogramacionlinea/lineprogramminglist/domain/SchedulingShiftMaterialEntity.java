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
import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain.helpers.SchedulingShiftMaterialId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programacion_turno_material")
@JsonInclude(Include.NON_EMPTY)
@IdClass(SchedulingShiftMaterialId.class)
public class SchedulingShiftMaterialEntity extends AuditEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_programacion", nullable = false)
    @JsonManagedReference
    private LineProgrammingEntity programacion;

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_turno", nullable = false)
    @JsonManagedReference
    private TurnEntity turno;

    // TODO: Ver si se pone el entity aqui
    @Id
    @Column(name = "id_material")
    private Long idMaterial;

    @Column(name = "hora_final", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaFinal;

    @Column(name = "hora_inicio", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp horaInicio;

    @Column(name = "id_estado_programacion", nullable = false)
    @Length(max = 2)
    private String idEstadoProgramacion;

    @Column(name = "ingreso", nullable = false)
    private Integer ingreso;

    @Column(name = "produccion", nullable = false)
    private Integer produccion;

    // TODO: Consultar formula
    @Column(name = "teorico", nullable = false)
    private String teorico;

    @Column(name = "minutos_just", nullable = false)
    private Integer minutosJust;

    @Column(name = "fecha_produccion", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaProduccion;

    @Column(name = "fecha_documento", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaDocumento;

    @Column(name = "fecha_contabilizacion", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaContabilizacion;

    @Column(name = "fecha_vencimiento", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp fechaVencimiento;

    @Column(name = "velocidad", nullable = false)
    private Integer velocidad;

    // TODO: Consultar formula
    @Column(name = "tiempo_cnv", nullable = false)
    private String tiempoCNV;

    @Column(name = "tiempo_td", nullable = false)
    private Integer tiempoTD;

    @Column(name = "tiempo_pp", nullable = false)
    private Integer tiempoPP;

    @Column(name = "tiempo_pnp", nullable = false)
    private Integer tiempoPNP;

    @Column(name = "tiempo_ttt", nullable = false)
    private Integer tiempoTTT;

    // TODO: Consultar formula
    @Column(name = "cod_carga_data", nullable = false)
    private String codCargaData;

    @Column(name = "flg_anulado")
    private Boolean flgAnulado;

}
