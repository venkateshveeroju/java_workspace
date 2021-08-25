package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailModel {

	private String txtorganization;
	private String txtactivities;
	private String txtheadquarters;
	private String txtoperations;
	
	
	public String getTxtorganization() {
		return txtorganization;
	}
	public void setTxtorganization(String txtorganization) {
		this.txtorganization = txtorganization;
	}
	public String getTxtactivities() {
		return txtactivities;
	}
	public void setTxtactivities(String txtactivities) {
		this.txtactivities = txtactivities;
	}
	public String getTxtheadquarters() {
		return txtheadquarters;
	}
	public void setTxtheadquarters(String txtheadquarters) {
		this.txtheadquarters = txtheadquarters;
	}
	public String getTxtoperations() {
		return txtoperations;
	}
	public void setTxtoperations(String txtoperations) {
		this.txtoperations = txtoperations;
	}
	
}