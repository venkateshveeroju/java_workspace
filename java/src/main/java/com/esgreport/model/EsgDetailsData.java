package com.esgreport.model;

public class EsgDetailsData {

	EsgDetailModel esgdetailmodel;
	EsgDetailUserModifiedModel esgdetailusermodifiedmodel;
	EsgDetailModeratorStatusModel esgdetailmoderatorstatusmodel;
	EsgDetailUserStatusModel esgdetailuserstatusmodel;
	EsgDetailLastModifiedModel esgdetaillastmodifiedmodel;
	EsgDetailsDelegateUserModel esgDetailsDelegateUserModel;
	int bank_id;

	public EsgDetailsData() {
		super();
	}

	public EsgDetailsData(EsgDetailModel esgdetailmodel, int bank_id) {
		super();
		this.esgdetailmodel = esgdetailmodel;
		this.bank_id = bank_id;
	}

	public EsgDetailModel getEsgdetailmodel() {
		return esgdetailmodel;
	}

	public void setEsgdetailmodel(EsgDetailModel esgdetailmodel) {
		this.esgdetailmodel = esgdetailmodel;
	}

	public EsgDetailUserModifiedModel getEsgdetailusermodifiedmodel() {
		return esgdetailusermodifiedmodel;
	}

	public void setEsgdetailusermodifiedmodel(EsgDetailUserModifiedModel esgdetailusermodifiedmodel) {
		this.esgdetailusermodifiedmodel = esgdetailusermodifiedmodel;
	}

	public EsgDetailModeratorStatusModel getEsgdetailmoderatorstatusmodel() {
		return esgdetailmoderatorstatusmodel;
	}

	public void setEsgdetailmoderatorstatusmodel(EsgDetailModeratorStatusModel esgdetailmoderatorstatusmodel) {
		this.esgdetailmoderatorstatusmodel = esgdetailmoderatorstatusmodel;
	}

	public EsgDetailUserStatusModel getEsgdetailuserstatusmodel() {
		return esgdetailuserstatusmodel;
	}

	public void setEsgdetailuserstatusmodel(EsgDetailUserStatusModel esgdetailuserstatusmodel) {
		this.esgdetailuserstatusmodel = esgdetailuserstatusmodel;
	}

	public EsgDetailLastModifiedModel getEsgdetaillastmodifiedmodel() {
		return esgdetaillastmodifiedmodel;
	}

	public void setEsgdetaillastmodifiedmodel(EsgDetailLastModifiedModel esgdetaillastmodifiedmodel) {
		this.esgdetaillastmodifiedmodel = esgdetaillastmodifiedmodel;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

}
