package com.estock.company.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estock.company.dao.CompanyDao;
import com.estock.company.dao.StockDao;
import com.estock.company.exceptions.ApplicationException;
import com.estock.company.model.Company;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyService {
	@Autowired
	CompanyDao companyDao;
	@Autowired
	StockDao stockDao;

	@Timed(value = "registerCompany.time", description = "Time taken to registerCompany")
	public String registerCompany(Company request) {
		if (companyDao.existsById(request.getCompanyCode())) {
			throw new ApplicationException("Company already registered");
		}
		log.info("adding the company details for {} in compnay DB ", request.getCompanyCode());
		companyDao.save(request);
		return "Company registered";
	}

	@Timed(value = "getCompanybyId.time", description = "Time taken to getCompanybyId")
	public Company getCompanybyId(Integer companyCode) {
		log.info("getting company details by id for {} ", companyCode);
		return companyDao.findById(companyCode).get();
	}

	@Timed(value = "getAllCompanies.time", description = "Time taken to getAllCompanies")
	public List<Company> getAllCompanies() {
		log.info("getting all company details");
		return companyDao.findAll();
	}

	@Transactional
	@Timed(value = "deleteCompanyById.time", description = "Time taken to deleteCompanyById")
	public void deleteCompanyById(Integer companyCode) {
		log.info("deleting company details for {}", companyCode);
		companyDao.deleteById(companyCode);
		log.info("deleting all stock details for {}", companyCode);
		stockDao.deleteAllStockPricesByCompanyCode(companyCode);
	}

}
