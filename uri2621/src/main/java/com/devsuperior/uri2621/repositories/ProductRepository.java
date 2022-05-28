package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjetion;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "prod.name "
			+ "FROM "
			+ "products prod "
			+ "JOIN providers prov ON prov.id = prod.id_providers "
			+ "WHERE prod.amount BETWEEN :from and :to AND prov.name LIKE CONCAT(:providerInitial, '%')")
	List<ProductMinProjetion> productByQuantityAndSupplier(Integer from, Integer to, String providerInitial);
	
	@Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(prod.name) "
			+ "FROM Product prod "
			+ "WHERE prod.amount BETWEEN :from AND :to AND prod.provider.name LIKE CONCAT(:providerInitial, '%')")
	List<ProductMinDTO> productByQuantityAndSupplierJpql(Integer from, Integer to, String providerInitial);
	
	

}
