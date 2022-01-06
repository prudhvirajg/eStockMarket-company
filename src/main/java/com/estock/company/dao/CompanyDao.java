package com.estock.company.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estock.company.model.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {

}
