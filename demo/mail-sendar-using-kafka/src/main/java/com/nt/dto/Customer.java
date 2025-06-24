package com.nt.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "customer_history")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	@Column(name = "customer_name")
	@JsonProperty("cName")
	private String cName;

	@Column(name = "customer_email")
	@JsonProperty("cEmail")
	private String cEmail;

	@Column(name = "customer_start")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date cStart;

}
