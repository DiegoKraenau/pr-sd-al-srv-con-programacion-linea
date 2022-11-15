package com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupogloria.prsdalsrvconprogramacionlinea.lineprogramminglist.domain.LineProgrammingEntity;

@Repository
public interface LineProgrammingRepository extends BaseRepository<LineProgrammingEntity, Long> {

    @Query("SELECT u FROM LineProgrammingEntity u WHERE u.fechaProgramacion = to_timestamp(:fechaProgramacion, 'yyyy-MM-DD HH24:MI:SS')")
    List<LineProgrammingEntity> findAllByFilters(@Param("fechaProgramacion") String fechaProgramacion);
}
