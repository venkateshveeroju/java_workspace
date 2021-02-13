package com.esgreport.model;

import org.springframework.stereotype.Component;

@Component
public class EsgDetailModel {

	private String txtOrganizationName;
	private String txtActivities;
	private String txtLocation;
	private String txtOperations;
	public String getTxtOrganizationName() {
		return txtOrganizationName;
	}
	public void setTxtOrganizationName(String txtOrganizationName) {
		this.txtOrganizationName = txtOrganizationName;
	}
	public String getTxtActivities() {
		return txtActivities;
	}
	public void setTxtActivities(String txtActivities) {
		this.txtActivities = txtActivities;
	}
	public String getTxtLocation() {
		return txtLocation;
	}
	public void setTxtLocation(String txtLocation) {
		this.txtLocation = txtLocation;
	}
	
	public boolean saveEsg(EsgDetailModel esgDetailModel) {
		
		return false;
		
	}
}
