package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    @Query(nativeQuery = true, value = "SELECT e.cpf, e.enome, d.dnome " +
            "FROM " +
            "empregados e " +
            "LEFT JOIN trabalha t ON e.cpf = t.cpf_emp " +
            "JOIN departamentos d ON d.dnumero = e.dnumero " +
            "WHERE t.pnumero IS null " +
            "ORDER BY e.cpf")
    List<EmpregadoDeptProjection> employeesWithoutProject();

}
