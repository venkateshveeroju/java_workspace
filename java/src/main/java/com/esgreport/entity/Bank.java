package com.esgreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "banks")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	@Column(length = 600)
	private String bankName;

	@Column(length = 60)
	private String logoPath;

	public Bank() {

	}

	public Bank(Long id, String bankName, String logoPath) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.logoPath = logoPath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

}
