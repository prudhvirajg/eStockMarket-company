package com.estock.company.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.company.dao.CompanyDao;
import com.estock.company.exceptions.ApplicationException;
import com.estock.company.model.Company;

@Service
public class CompanyService {
	@Autowired
	CompanyDao companydao;

	public String registerCompany(Company request) {
		if (companydao.existsById(request.getCompanyCode())) {
			if (Stream.of(request.getCeo(), request.getCompanyName(), request.getStockExchange(), request.getTurnOver())
					.allMatch(Objects::isNull)) {
				return updateStockPrice(request);
			} else
				throw new ApplicationException("Company already registered");
		}

		companydao.save(request);
		return "Company registered";
	}

	private String updateStockPrice(Company request) {
		Company company = companydao.findById(request.getCompanyCode()).get();
		company.setStockPrice(request.getStockPrice());
		companydao.save(company);
		return "updated stock price";
	}

	public Company getCompanybyId(Integer companyCode) {

		return companydao.findById(companyCode).get();
	}

	public List<Company> getAllCompanies() {

		return companydao.findAll();
	}

	public void deleteCompanyById(Integer companyCode) {
		companydao.deleteById(companyCode);

	}

}
