package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailUserModifiedModel {

	private int txtorganizationModifiedby;
	private int txtactivitiesModifiedby;
	private int txtheadquartersModifiedby;
	private int txtoperationsModifiedby;
	
	public EsgDetailUserModifiedModel() {
		super();
	}


	public EsgDetailUserModifiedModel(int txtorganizationModifiedby, int txtactivitiesModifiedby,
			int txtheadquartersModifiedby, int txtoperationsModifiedby) {
		super();
		this.txtorganizationModifiedby = txtorganizationModifiedby;
		this.txtactivitiesModifiedby = txtactivitiesModifiedby;
		this.txtheadquartersModifiedby = txtheadquartersModifiedby;
		this.txtoperationsModifiedby = txtoperationsModifiedby;
	}
	
	
	public int getTxtorganizationModifiedby() {
		return txtorganizationModifiedby;
	}
	public void setTxtorganizationModifiedby(int txtorganizationModifiedby) {
		this.txtorganizationModifiedby = txtorganizationModifiedby;
	}
	public int getTxtactivitiesModifiedby() {
		return txtactivitiesModifiedby;
	}
	public void setTxtactivitiesModifiedby(int txtactivitiesModifiedby) {
		this.txtactivitiesModifiedby = txtactivitiesModifiedby;
	}
	public int getTxtheadquartersModifiedby() {
		return txtheadquartersModifiedby;
	}
	public void setTxtheadquartersModifiedby(int txtheadquartersModifiedby) {
		this.txtheadquartersModifiedby = txtheadquartersModifiedby;
	}
	public int getTxtoperationsModifiedby() {
		return txtoperationsModifiedby;
	}
	public void setTxtoperationsModifiedby(int txtoperationsModifiedby) {
		this.txtoperationsModifiedby = txtoperationsModifiedby;
	}

}