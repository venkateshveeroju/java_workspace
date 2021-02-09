package com.esgreport.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	@Column(length = 60)
	private String bankName;

	@Column(length = 60)
	private String logoPath;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "esgdetail_Id")
	private EsgDetail esgDetail;

	public Bank(Long id, String bankName, String logoPath) {
		super();
		this.id = id;
		bankName = bankName;
		this.logoPath = logoPath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EsgDetail getEsgDetails() {
		return esgDetail;
	}

	public void setEsgDetails(EsgDetail esgDetail) {
		this.esgDetail = esgDetail;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public EsgDetail getEsgDetail() {
		return esgDetail;
	}

	public void setEsgDetail(EsgDetail esgDetail) {
		this.esgDetail = esgDetail;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

}
