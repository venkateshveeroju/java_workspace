package com.esgreport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name ="esgdetails")
public class EsgDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long esgDetailsId;

	@Column(length = 60)
	@Enumerated(EnumType.STRING)
	@NaturalId
	private String esgDetailsText;
	public Long getEsgDetailsId() {
		return esgDetailsId;
	}

	public void setEsgDetailsId(Long esgDetailsId) {
		this.esgDetailsId = esgDetailsId;
	}

	public String getEsgDetailsText() {
		return esgDetailsText;
	}

	public void setEsgDetailsText(String esgDetailsText) {
		this.esgDetailsText = esgDetailsText;
	}

	
}
