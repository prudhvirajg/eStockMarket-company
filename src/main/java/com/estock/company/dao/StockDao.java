package com.estock.company.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estock.company.model.Stock;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {

	@Modifying
	@Query("Delete from Stock s  WHERE s.companyCode = ?1")
	void deleteAllStockPricesByCompanyCode(Integer companycode);

}
