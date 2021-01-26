package com.esgreport.entity;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "esgdetails")
public class EsgDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60)
	@NaturalId
	private String esgDetailText;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private Bank bank;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "esgdetail_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "esgdetail_id"))
	private Set<User> users = new HashSet<>();

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bank getBanks() {
		return bank;
	}

	public void setBanks(Bank banks) {
		this.bank = banks;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
	public Set<User> getUsers() {
		return users;
	}
	public String getEsgDetailsText() {
		return esgDetailText;
	}

	public void setEsgDetailsText(String esgDetailText) {
		this.esgDetailText = esgDetailText;
	}

}
