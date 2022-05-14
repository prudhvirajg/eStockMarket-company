package com.estock.company.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.company.model.Company;
import com.estock.company.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1.0/market")
public class EStockCompanyController {
	@Autowired
	CompanyService companyservice;

	@CrossOrigin
	@PostMapping(value = "/company/register", consumes = { "application/json" })
	public ResponseEntity<String> registerCompany(@RequestBody Company request) {

		String status = companyservice.registerCompany(request);
		if (status.contains("stock")) {
			return new ResponseEntity<String>("updated stock price for " + request.getCompanyCode(), HttpStatus.OK);
		}

		return new ResponseEntity<String>("company " + request.getCompanyName() + " registered successfully",
				HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping(value = "/company/info/{companyCode}")
	public Company searchCompany(@PathVariable Integer companyCode) {
		log.info("id : " + companyCode);
		return companyservice.getCompanybyId(companyCode);
	}

	@CrossOrigin
	@GetMapping(value = "/company/getall")
	public List<Company> allCompanies() {
		return companyservice.getAllCompanies();
	}

	@CrossOrigin
	@DeleteMapping(value = "/company/delete/{companyCode}")
	public ResponseEntity<String> deleteCompany(@PathVariable Integer companyCode) {
		log.info("id : " + companyCode);

		companyservice.deleteCompanyById(companyCode);

		return new ResponseEntity<String>("company deleted successfully", HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping(value="/ping")
	public ResponseEntity<Map<String, String>> ping(){
		
		return new ResponseEntity<Map<String,String>>( Map.of("Status","Up"),HttpStatus.OK);
	}

}