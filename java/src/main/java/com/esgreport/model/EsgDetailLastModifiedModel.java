package com.esgreport.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailLastModifiedModel {


	private String txtorganizationmodifieddate;
	private String txtactivitiesmodifieddate;
	private String txtheadquartersmodifieddate;
	private String txtoperationsmodifieddate;
	
	public EsgDetailLastModifiedModel() {
		super();
	}
//

	public EsgDetailLastModifiedModel(String txtorganizationmodifieddate, String txtactivitiesmodifieddate,
			String txtheadquartersmodifieddate, String txtoperationsmodifieddate) {
		super();
		this.txtorganizationmodifieddate = txtorganizationmodifieddate;
		this.txtactivitiesmodifieddate = txtactivitiesmodifieddate;
		this.txtheadquartersmodifieddate = txtheadquartersmodifieddate;
		this.txtoperationsmodifieddate = txtoperationsmodifieddate;
	}

	public String getTxtorganizationmodifieddate() {
		return txtorganizationmodifieddate;
	}

	public void setTxtorganizationmodifieddate(String txtorganizationmodifieddate) {
		this.txtorganizationmodifieddate = txtorganizationmodifieddate;
	}

	public String getTxtactivitiesmodifieddate() {
		return txtactivitiesmodifieddate;
	}

	public void setTxtactivitiesmodifieddate(String txtactivitiesmodifieddate) {
		this.txtactivitiesmodifieddate = txtactivitiesmodifieddate;
	}

	public String getTxtheadquartersmodifieddate() {
		return txtheadquartersmodifieddate;
	}

	public void setTxtheadquartersmodifieddate(String txtheadquartersmodifieddate) {
		this.txtheadquartersmodifieddate = txtheadquartersmodifieddate;
	}

	public String getTxtoperationsmodifieddate() {
		return txtoperationsmodifieddate;
	}

	public void setTxtoperationsmodifieddate(String txtoperationsmodifieddate) {
		this.txtoperationsmodifieddate = txtoperationsmodifieddate;
	}
	
	
	

	
	
	
}