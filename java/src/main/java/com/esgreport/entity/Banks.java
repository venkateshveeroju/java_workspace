package com.esgreport.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "banks")
public class Banks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bankId;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private String BankName;

	@Enumerated(EnumType.STRING)
	@Column(length = 60)
	private String logoPath;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public Banks(Long bankId, String bankName, String logoPath) {
		super();
		this.bankId = bankId;
		BankName = bankName;
		this.logoPath = logoPath;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

}
