package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2737.entities.Lawyer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    //como a é uma consulta SQL raiz, deve-se dar uma apelido para os campos(igual os projections)
    @Query(nativeQuery = true, value = "" +
            "(SELECT l.name, l.customers_number AS customersNumber FROM lawyers l WHERE l.customers_number = (SELECT MAX(l.customers_number) FROM lawyers l)) " +
            "UNION ALL " +
            "(SELECT l.name, l.customers_number FROM lawyers l WHERE l.customers_number = (SELECT MIN(l.customers_number) FROM lawyers l)) " +
            "UNION ALL " +
            "(SELECT 'Average' AS AVARAGE, TRUNC(AVG(l.customers_number), 0) FROM lawyers l GROUP BY AVARAGE)")
    List<LawyerMinProjection> lawyersReport1();

}
