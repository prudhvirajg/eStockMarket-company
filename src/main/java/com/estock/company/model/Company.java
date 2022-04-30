package com.estock.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "companies")
public class Company {
	@Id
	@Column(name = "companyCode")
	private Integer companyCode;
	@Column(name = "companyName")
	private String companyName;
	@Column(name = "ceo")
	private String ceo;
	@Column(name = "turnOver")
	private String turnOver;
	@Column(name = "website")
	private String website;
	@Column(name = "stockExchange")
	private String stockExchange;
	@Column(name = "stockPrice")
	private float stockPrice;

}
