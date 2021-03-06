package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailUserStatusModel {


	private String txtorganizationStatus;
	private String txtactivitiesStatus;
	private String txtheadquartersStatus;
	private String txtoperationsStatus;
	
	public EsgDetailUserStatusModel() {
		super();
	}

	public EsgDetailUserStatusModel(String txtorganizationStatus, String txtactivitiesStatus, String txtheadquartersStatus,
			String txtoperationsStatus) {
		super();
		this.txtorganizationStatus = txtorganizationStatus;
		this.txtactivitiesStatus = txtactivitiesStatus;
		this.txtheadquartersStatus = txtheadquartersStatus;
		this.txtoperationsStatus = txtoperationsStatus;
	}

	public String getTxtorganizationStatus() {
		return txtorganizationStatus;
	}

	public void setTxtorganizationStatus(String txtorganizationStatus) {
		this.txtorganizationStatus = txtorganizationStatus;
	}

	public String getTxtactivitiesStatus() {
		return txtactivitiesStatus;
	}

	public void setTxtactivitiesStatus(String txtactivitiesStatus) {
		this.txtactivitiesStatus = txtactivitiesStatus;
	}

	public String getTxtheadquartersStatus() {
		return txtheadquartersStatus;
	}

	public void setTxtheadquartersStatus(String txtheadquartersStatus) {
		this.txtheadquartersStatus = txtheadquartersStatus;
	}

	public String getTxtoperationsStatus() {
		return txtoperationsStatus;
	}

	public void setTxtoperationsStatus(String txtoperationsStatus) {
		this.txtoperationsStatus = txtoperationsStatus;
	}

	
	
	
	
	
}