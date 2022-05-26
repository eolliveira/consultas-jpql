package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	//SQL RAIZ
	@Query(nativeQuery = true, value = "SELECT name FROM customers WHERE state = :state")
	List<CustomerMinProjection> CustomersByState(String state);
	
	//JPQL
	/* Quando se usa projeção para obter os dados expecificos da tabela
	 * é preciso informar o caminho completo da classe(DTO) e passar os parametros(colunas)
	 * no contrutor.
	 * 
	 * Do contrario, para trazer todas colunas, basta ( SELECT obj ... )
	*/
	@Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) "
			+ "FROM Customer obj "
			+ "WHERE UPPER(obj.state) = UPPER(:state) ")
	List<CustomerMinDTO> CustomersByStateJpql(String state);
}
