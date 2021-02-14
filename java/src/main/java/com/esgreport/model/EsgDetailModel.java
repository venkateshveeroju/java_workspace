package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailModel {

	private String txtOrganization;
	private String txtActivities;
	private String txtHeadquarters;
	private String txtOperations;
	
	
	public String getTxtorganization() {
		return txtOrganization;
	}
	public void setTxtorganization(String txtorganization) {
		this.txtOrganization = txtorganization;
	}
	public String getTxtactivities() {
		return txtActivities;
	}
	public void setTxtactivities(String txtactivities) {
		this.txtActivities = txtactivities;
	}
	public String getTxtheadquarters() {
		return txtHeadquarters;
	}
	public void setTxtheadquarters(String txtheadquarters) {
		this.txtHeadquarters = txtheadquarters;
	}
	public String getTxtoperations() {
		return txtOperations;
	}
	public void setTxtoperations(String txtoperations) {
		this.txtOperations = txtoperations;
	}
	
}