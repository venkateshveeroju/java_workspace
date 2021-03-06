package com.esgreport.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "esgdetails")
public class EsgDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 6000)
	private String esgDetailText;
	
	@Column(length = 6000)
	private String esgDetailTextValue;

	public String getEsgDetailTextValue() {
		return esgDetailTextValue;
	}

	public void setEsgDetailTextValue(String esgDetailTextValue) {
		this.esgDetailTextValue = esgDetailTextValue;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_id")
	private Bank bank;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_by")
	private User lastModifiedBy;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "delegate_to")
	private User delegateTo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "moderator_status_id")
	private EsgDetailsModeratorStatus moderatorStatusId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_status_id")
	private EsgDetailsUserStatus userStatusId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date lastModifiedDate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "esgdetail_user", joinColumns = @JoinColumn(name = "esgdetail_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	public User getDelegateTo() {
		return delegateTo;
	}

	public void setDelegateTo(User delegateTo) {
		this.delegateTo = delegateTo;
	}

	public EsgDetailsModeratorStatus getModeratorStatusId() {
		return moderatorStatusId;
	}

	public void setModeratorStatusId(EsgDetailsModeratorStatus moderatorStatusId) {
		this.moderatorStatusId = moderatorStatusId;
	}

	public EsgDetailsUserStatus getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(EsgDetailsUserStatus userStatusId) {
		this.userStatusId = userStatusId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEsgDetailText() {
		return esgDetailText;
	}

	public void setEsgDetailText(String esgDetailText) {
		this.esgDetailText = esgDetailText;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getEsgDetailsText() {
		return esgDetailText;
	}

	public void setEsgDetailsText(String esgDetailText) {
		this.esgDetailText = esgDetailText;
	}

	public void setBank(Bank bank) {
		// TODO Auto-generated method stub
		this.bank = bank;
	}

}
