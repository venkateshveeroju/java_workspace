

import { Component, OnInit } from '@angular/core';
import { LogService } from '../_services/log.service';
import { EsgdetailsService } from './../_services/esgdetails.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from './../_services/User.service';
import { User } from './../User';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-gri-generaldisclosures',
  templateUrl: './gri-generaldisclosures.component.html',
  styleUrls: ['./gri-generaldisclosures.component.css']
})
export class GriGeneraldisclosuresComponent implements OnInit {

  // Esg details
  esgdetails = {
    txtOrganization: '',
    txtActivities: '',
    txtHeadquarters: '',
    txtOperations: '',

  };

  // modified by --user id 
  esgdetailusermodifiedmodel = {
    txtorganizationModifiedby: 1,
    txtactivitiesModifiedby: 1,
    txtheadquartersModifiedby: 1,
    txtoperationsModifiedby: 1
  };

  // Moderator status - 1. IN_PROGRESS, 2.	APPROVED, 3. 	DENIED
  esgdetailmoderatorstatusmodel = {
    txtorganizationStatus: 1,
    txtactivitiesStatus: 1,
    txtheadquartersStatus: 1,
    txtoperationsStatus: 1
  };

  // user status - 1 .SAVE_CONTINUE, 2.	SAVE_SUBMIT
  esgdetailuserstatusmodel = {
    txtorganizationStatus: 1,
    txtactivitiesStatus: 1,
    txtheadquartersStatus: 1,
    txtoperationsStatus: 1

  };

  // Last modified date 
  esgdetaillastmodifiedmodel = {
    txtorganizationmodifieddate: '',
    txtactivitiesmodifieddate: '',
    txtheadquartersmodifieddate: '',
    txtoperationsmodifieddate: ''
  };

  // delegate user
  esgdetaildelegateusermodel = {
    txtorganizationdelegateuser: '',
    txtactivitiesdelegateuser: '',
    txtheadquartersdelegateuser: '',
    txtoperationsdelegateuser: ''
  };
  // bank_id
  bank_id = 1;



  // submitted = false;

  // Details to and from  html  -- Starts here
  // text area - 102-1 - bank name
  esgdetailsbankname = '';

  //text area - 102-2 
  clickedesgdetailsbankinfo = false;
  clickedesgdetailsbankactivity = false;
  clickedesgdetailsbankservice = false;
  esgdetailsbankinfo = '____ is a leading ____ and a major ____ in ___';
  esgdetailsbankactivity = 'Our market activities focus on business with ___';
  esgdetailsbankservice = 'We provide services like .....';

  //text area - 102-3
  clickedbanklocation = false;
  esgdetailsbanklocation = 'The main location of ____ is: ____';

  //text area - 102-4
  clickedbankoperation1 = false;
  clickedbankoperation2 = false;
  esgdetailsbankoperation1 = '____ has its main office in ____.';
  esgdetailsbankoperation2 = 'In addition, the bank has ____ in the economic';

  esgdetailsbankinfo1 = '';
  esgdetailsbankinfo2 = '';
  esgdetailsbankinfo3 = '';

  Orgmodaratorstatus: any[];
  OrgmodaratorselectedStatus: number;

  Activitiesmodaratorstatus: any[];
  ActivitiesmodaratorselectedStatus: number;

  Headquartersmodaratorstatus: any[];
  HeadquartersmodaratorselectedStatus: number;

  Operationsmodaratorstatus: any[];
  OperationsmodaratorselectedStatus: number;

  /*Orgdelegatedto: string[] = ["--Select--", "venkat", "veeroju"];
  Orgdelegatedtouser = "User1";*/

  Orgdelegatedto: any[];
  Orgdelegatedtouser: number;
  //  Orgdelegatedtousername: string;

  Activitiesdelegatedto: any[];
  Activitiesdelegatedtouser: number;

  Headquartersdelegatedto: any[];
  Headquartersdelegatedtouser: number;

  Operationsdelegatedto: any[];
  Operationsdelegatedtouser: number;

  OrgLastmodifiedBy: number;
  OrgLastModifedDate: String = new Date().toDateString();

  ActivitiesLastmodifiedBy: number;
  ActivitiesLastModifedDate: String = new Date().toDateString();

  HeadquartersLastmodifiedBy: number;
  HeadquartersLastModifedDate: String = new Date().toDateString();

  OperationsLastmodifiedBy: number;
  OperationsLastModifedDate: String = new Date().toDateString();
  OrgUserStatus = "";
  ActivitiesUserStatus = "";
  HeadquartersUserStatus = "";
  OperationsUserStatus = "";
  // Details to and from  html  -- Ends here 
  loggedinUser: string;
  loggedinUserId: number;
  users: Observable<User[]>;
  orgreadonly = true;
  activitiesreadonly = true;
  headquartersreadonly = true;
  operationsreadonly = true;

  constructor(private logger: LogService, private esgdetailsService: EsgdetailsService, private tokenStorage: TokenStorageService, private UserService: UserService) { }

  ngOnInit(): void {
    this.tokenStorage.setLoggedinUserRecordId(Number(sessionStorage.getItem("loggedinUserId")));
    this.tokenStorage.getLoggedinUserRecordId().subscribe(params => {
      console.log("user id :" + params)
      this.loggedinUserId = params
    });

    this.tokenStorage.setLoggedinUserRecord(sessionStorage.getItem("loggedinUser"));
    this.tokenStorage.getLoggedinUserRecord().subscribe(params => {
      console.log("user name :" + params)
      this.loggedinUser = params
    });




    this.UserService.getUsersList().subscribe(
      response => {
        console.log(response);
        this.Orgdelegatedto = [];
        this.Activitiesdelegatedto = [];
        this.Headquartersdelegatedto = [];
        this.Operationsdelegatedto = [];
        for (var i = 0; i < response.length; i++) {
          this.Orgdelegatedto.push({ label: response[i]['username'], value: response[i]['id'] });
          this.Activitiesdelegatedto.push({ label: response[i]['username'], value: response[i]['id'] });
          this.Headquartersdelegatedto.push({ label: response[i]['username'], value: response[i]['id'] });
          this.Operationsdelegatedto.push({ label: response[i]['username'], value: response[i]['id'] });

        }
      });

    // this.Orgdelegatedto = [];
    // this.Orgdelegatedto.push({ label: 'Venkat', value: '1' });
    // this.Orgdelegatedto.push({ label: 'Veeroju', value: '2' });

    // this.Activitiesdelegatedto = [];
    // this.Activitiesdelegatedto.push({ label: 'Venkat', value: '1' });
    // this.Activitiesdelegatedto.push({ label: 'Veeroju', value: '2' });

    // this.Headquartersdelegatedto = [];
    // this.Headquartersdelegatedto.push({ label: 'Venkat', value: '1' });
    // this.Headquartersdelegatedto.push({ label: 'Veeroju', value: '2' });

    // this.Operationsdelegatedto = [];
    // this.Operationsdelegatedto.push({ label: 'Venkat', value: '1' });
    // this.Operationsdelegatedto.push({ label: 'Veeroju', value: '2' });

    this.Orgmodaratorstatus = [];
    this.Orgmodaratorstatus.push({ label: 'IN PROGRESS', value: '1' });
    this.Orgmodaratorstatus.push({ label: 'APPROVED', value: '2' });
    this.Orgmodaratorstatus.push({ label: 'DENIED', value: '3' });

    this.Activitiesmodaratorstatus = [];
    this.Activitiesmodaratorstatus.push({ label: 'IN PROGRESS', value: '1' });
    this.Activitiesmodaratorstatus.push({ label: 'APPROVED', value: '2' });
    this.Activitiesmodaratorstatus.push({ label: 'DENIED', value: '3' });

    this.Headquartersmodaratorstatus = [];
    this.Headquartersmodaratorstatus.push({ label: 'IN PROGRESS', value: '1' });
    this.Headquartersmodaratorstatus.push({ label: 'APPROVED', value: '2' });
    this.Headquartersmodaratorstatus.push({ label: 'DENIED', value: '3' });

    this.Operationsmodaratorstatus = [];
    this.Operationsmodaratorstatus.push({ label: 'IN PROGRESS', value: '1' });
    this.Operationsmodaratorstatus.push({ label: 'APPROVED', value: '2' });
    this.Operationsmodaratorstatus.push({ label: 'DENIED', value: '3' });

    this.esgdetailsService.show()
      .subscribe(
        response => {
          console.log(response);
          if (this.loggedinUser == response[0]['delegateTo']['username']) {
            this.orgreadonly = false;
          }
          if (this.loggedinUser == response[1]['delegateTo']['username']) {
            this.activitiesreadonly = false;
          }
          if (this.loggedinUser == response[2]['delegateTo']['username']) {
            this.headquartersreadonly = false;
          }
          if (this.loggedinUser == response[3]['delegateTo']['username']) {
            this.operationsreadonly = false;
          }


          this.esgdetailsbankname = response[0]['esgDetailTextValue'];
          this.esgdetailsbankinfo1 = response[1]['esgDetailTextValue'];
          this.esgdetailsbankinfo2 = response[2]['esgDetailTextValue'];
          this.esgdetailsbankinfo3 = response[3]['esgDetailTextValue'];

          this.esgdetails.txtOrganization = this.esgdetailsbankname;
          this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
          this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
          this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

          //console.log(response[0]['lastModifiedBy']['username']);
          this.OrgLastmodifiedBy = response[0]['lastModifiedBy']['username'];
          this.ActivitiesLastmodifiedBy = response[1]['lastModifiedBy']['username'];
          this.HeadquartersLastmodifiedBy = response[2]['lastModifiedBy']['username'];
          this.OperationsLastmodifiedBy = response[3]['lastModifiedBy']['username'];

          //this.OrgmodaratorselectedStatus = this.Orgmodaratorstatus[response[0]['moderatorStatusId']['id']];
          // this.ActivitiesmodaratorselectedStatus = this.Activitiesmodaratorstatus[response[1]['moderatorStatusId']['id']];
          //this.HeadquartersmodaratorselectedStatus = this.Headquartersmodaratorstatus[response[2]['moderatorStatusId']['id']];
          //this.OperationsmodaratorselectedStatus = this.Operationsmodaratorstatus[response[3]['moderatorStatusId']['id']];


          this.onChangeOrgDelegateUser(response[0]['delegateTo']['id']);
          this.onChangeActivitieseUser(response[1]['delegateTo']['id']);
          this.onChangeHeadquartersUser(response[2]['delegateTo']['id']);
          this.onChangeOperationsUser(response[3]['delegateTo']['id']);

          this.OrgLastModifedDate = response[0]['lastModifiedDate'];
          this.ActivitiesLastModifedDate = response[1]['lastModifiedDate'];
          this.HeadquartersLastModifedDate = response[2]['lastModifiedDate'];
          this.OperationsLastModifedDate = response[3]['lastModifiedDate'];

          this.OrgUserStatus = response[0]['userStatusId']['status'];
          this.ActivitiesUserStatus = response[1]['userStatusId']['status'];
          this.HeadquartersUserStatus = response[2]['userStatusId']['status'];
          this.OperationsUserStatus = response[2]['userStatusId']['status'];

        },
        error => {
          console.log(error);
        });
  }



  onChangeOrgDelegateUser(delegateUserId: number) {
    this.Orgdelegatedtouser = delegateUserId;
  }
  onChangeActivitieseUser(delegateUserId: number) {
    this.Activitiesdelegatedtouser = delegateUserId;
  }
  onChangeHeadquartersUser(delegateUserId: number) {
    this.Headquartersdelegatedtouser = delegateUserId;
  }
  onChangeOperationsUser(delegateUserId: number) {
    this.Operationsdelegatedtouser = delegateUserId;
  }



  onChangeOrgmodaratorstatus(moderatorrStatusId: number) {
    this.OrgmodaratorselectedStatus = moderatorrStatusId;
  }
  onChangeActivitiesmodaratorstatus(moderatorrStatusId: number) {
    this.ActivitiesmodaratorselectedStatus = moderatorrStatusId;
  }
  onChangeHeadquartersmodaratorstatus(moderatorrStatusId: number) {
    this.HeadquartersmodaratorselectedStatus = moderatorrStatusId;
  }
  onChangeOperationsmodaratorstatus(moderatorrStatusId: number) {
    this.OperationsmodaratorselectedStatus = moderatorrStatusId;
  }

  // events - 102-2 - starts here
  updatebankinfo() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankinfo;
    //this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;

  }
  updatebankactivity() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankactivity;
    // this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;

  }
  updatebankservice() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankservice;
    // this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;
  }
  // events - 102-2 - ends here
  // events - 102-3 - starts here
  updatebanklocation() {
    this.esgdetailsbankinfo2 += this.esgdetailsbanklocation;
    //this.esgdetailusermodifiedmodel.txtheadquartersModifiedby = 1;
  }
  // events - 102-3 - ends here

  // events - 102-4 - starts here
  updatebankoperation1() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation1;
    //this.esgdetailusermodifiedmodel.txtoperationsModifiedby = 1;
  }

  updatebankoperation2() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation2;
    //this.esgdetailusermodifiedmodel.txtoperationsModifiedby = 1;
  }
  // events - 102-4 - ends here

  onSaveContinue($event) {
    this.esgdetails.txtOrganization = this.esgdetailsbankname;
    this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

    //this.esgdetailusermodifiedmodel.txtorganizationModifiedby = 1; // this might need a condition

    //this.esgdetailuserstatusmodel.txtorganizationStatus = 1;
    //this.esgdetailuserstatusmodel.txtactivitiesStatus = 1;
    //this.esgdetailuserstatusmodel.txtheadquartersStatus = 1;
    //this.esgdetailuserstatusmodel.txtoperationsStatus = 1;

    const data = {
      "esgdetailmodel": {
        txtorganization: this.esgdetails.txtOrganization,
        txtactivities: this.esgdetails.txtActivities,
        txtheadquarters: this.esgdetails.txtHeadquarters,
        txtoperations: this.esgdetails.txtOperations,
      },
      "esgdetailusermodifiedmodel": {
        "txtorganizationModifiedby": this.Orgdelegatedtouser,
        "txtactivitiesModifiedby": this.Orgdelegatedtouser,
        "txtheadquartersModifiedby": this.Orgdelegatedtouser,
        "txtoperationsModifiedby": this.Orgdelegatedtouser
      },
      "esgdetailmoderatorstatusmodel": {
        "txtorganizationStatus": this.OrgmodaratorselectedStatus,
        "txtactivitiesStatus": this.ActivitiesmodaratorselectedStatus,
        "txtheadquartersStatus": this.HeadquartersmodaratorselectedStatus,
        "txtoperationsStatus": this.OperationsmodaratorselectedStatus
      },
      "esgdetailuserstatusmodel": {
        "txtorganizationStatus": this.OrgUserStatus,
        "txtactivitiesStatus": this.ActivitiesUserStatus,
        "txtheadquartersStatus": this.HeadquartersUserStatus,
        "txtoperationsStatus": this.OperationsUserStatus
        // "txtorganizationStatus": 1,
        // "txtactivitiesStatus": 1,
        // "txtheadquartersStatus":2,
        // "txtoperationsStatus": 2
      },

      "esgdetaillastmodifiedmodel": {
        "txtorganizationmodifieddate": this.OrgLastModifedDate,
        "txtactivitiesmodifieddate": this.ActivitiesLastModifedDate,
        "txtheadquartersmodifieddate": this.HeadquartersLastModifedDate,
        "txtoperationsmodifieddate": this.OperationsLastModifedDate

      },
      "esgdetaildelegateusermodel": {
        "txtorganizationdelegateuser": this.Orgdelegatedtouser,
        "txtactivitiesdelegateuser": this.Activitiesdelegatedtouser,
        "txtheadquartersdelegateuser": this.Headquartersdelegatedtouser,
        "txtoperationsdelegateuser": this.Operationsdelegatedtouser
      },
      "bank_id": 1
    };
    console.log(this.OrgUserStatus["id"]);
    console.log(data);
    this.esgdetailsService.save(data)
      .subscribe(
        response => {
          console.log(response);
          //this.submitted = true;
          alert("Save sucessfully...")
        },
        error => {
          console.log(error);
          alert("Save sucessfully")
        });

  }


  onSaveSubmit($event) {
    this.esgdetails.txtOrganization = this.esgdetailsbankname;
    this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

    this.esgdetailusermodifiedmodel.txtorganizationModifiedby = 1; // this might need a condition

    this.esgdetailuserstatusmodel.txtorganizationStatus = 2;
    this.esgdetailuserstatusmodel.txtactivitiesStatus = 2;
    this.esgdetailuserstatusmodel.txtheadquartersStatus = 2;
    this.esgdetailuserstatusmodel.txtoperationsStatus = 2;

    const data = {
      txtorganization: this.esgdetails.txtOrganization,
      txtactivities: this.esgdetails.txtActivities,
      txtheadquarters: this.esgdetails.txtHeadquarters,
      txtoperations: this.esgdetails.txtOperations,

    };

    console.log(data);


    this.esgdetailsService.save(data)
      .subscribe(
        response => {
          console.log(response);
          //this.submitted = true;
          alert("Save sucessfully...")
        },
        error => {
          console.log(error);
          alert("Save sucessfully")
        });
    console.log("SaveSubmit button is clicked!", $event);

  }

  onDelgate($event) {
    console.log("Delegate button is clicked!", $event);
    const delegatedata = {
      //"esgdetailsdelegateusermodel": {
        txtorganizationdelegateuser: this.Orgdelegatedtouser,
        txtactivitiesdelegateuser: this.Activitiesdelegatedtouser,
        txtheadquartersdelegateuser: this.Headquartersdelegatedtouser,
        txtoperationsdelegateuser: this.Operationsdelegatedtouser
     // }
      // this.esgdetaildelegateusermodel.txtorganizationdelegateuser=this.Orgdelegatedtouser;
      ///this.esgdetaildelegateusermodel.txtactivitiesdelegateuser= this.Activitiesdelegatedtouser;
      //this.esgdetaildelegateusermodel.txtheadquartersdelegateuser= this.Headquartersdelegatedtouser;
      // this.esgdetaildelegateusermodel.txtoperationsdelegateuser= this.Operationsdelegatedtouser;
    };
    console.log(delegatedata);
    this.esgdetailsService.onDelgate(delegatedata)
      .subscribe(
        response => {
          console.log(response);
          //this.submitted = true;
          alert("Delegate sucessfully...")
        },
        error => {
          console.log(error);
          alert("Delegate unsucessfully")
        });

  }

  onExport($event) {
    console.log("Export button is clicked!", $event);

  }

  onPrint($event) {
    console.log("Print button is clicked!", $event);
  }

}
