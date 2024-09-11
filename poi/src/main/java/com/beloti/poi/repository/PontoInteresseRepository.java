package com.beloti.poi.repository;

import com.beloti.poi.entity.PontoInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PontoInteresseRepository extends JpaRepository<PontoInteresse, Long> {
    @Query("""
            SELECT p FROM PontoInteresse p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<PontoInteresse> findNearMe(@Param("xMin") long xMin,
                                    @Param("xMax") long xMax,
                                    @Param("yMin") long yMin,
                                    @Param("yMax") long yMax);

    List<PontoInteresse> findByTipo(String tipo);
}
