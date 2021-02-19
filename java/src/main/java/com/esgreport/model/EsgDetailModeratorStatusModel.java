package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailModeratorStatusModel {


	private int txtorganizationStatus;
	private int txtactivitiesStatus;
	private int txtheadquartersStatus;
	private int txtoperationsStatus;
	
	public EsgDetailModeratorStatusModel() {
		super();
	}

	public EsgDetailModeratorStatusModel(int txtorganizationStatus, int txtactivitiesStatus, int txtheadquartersStatus,
			int txtoperationsStatus) {
		super();
		this.txtorganizationStatus = txtorganizationStatus;
		this.txtactivitiesStatus = txtactivitiesStatus;
		this.txtheadquartersStatus = txtheadquartersStatus;
		this.txtoperationsStatus = txtoperationsStatus;
	}

	public int getTxtorganizationStatus() {
		return txtorganizationStatus;
	}

	public void setTxtorganizationStatus(int txtorganizationStatus) {
		this.txtorganizationStatus = txtorganizationStatus;
	}

	public int getTxtactivitiesStatus() {
		return txtactivitiesStatus;
	}

	public void setTxtactivitiesStatus(int txtactivitiesStatus) {
		this.txtactivitiesStatus = txtactivitiesStatus;
	}

	public int getTxtheadquartersStatus() {
		return txtheadquartersStatus;
	}

	public void setTxtheadquartersStatus(int txtheadquartersStatus) {
		this.txtheadquartersStatus = txtheadquartersStatus;
	}

	public int getTxtoperationsStatus() {
		return txtoperationsStatus;
	}

	public void setTxtoperationsStatus(int txtoperationsStatus) {
		this.txtoperationsStatus = txtoperationsStatus;
	}
	
	
	
	
}