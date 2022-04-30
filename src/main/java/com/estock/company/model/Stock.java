package com.estock.company.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "stockprices")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "companyCode")
	private Integer companyCode;
	@Column(name = "stockPrice")
	private float stockPrice;
	@Column(name = "addedDate")
	private Date addedDate;
	@Column(name = "addedTime")
	private Time addedTime;

}
