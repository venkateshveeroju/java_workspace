

import { Component, OnInit } from '@angular/core';
import { LogService } from '../_services/log.service';
import { EsgdetailsService } from './../_services/esgdetails.service';

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

  Orgmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  OrgmodaratorselectedStatus = "IN PROGRESS";

<<<<<<< .mine
  Activitiesmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  ActivitiesmodaratorselectedStatus = "IN PROGRESS";

  Headquartersmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  HeadquartersmodaratorselectedStatus = "IN PROGRESS";

  Operationsmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  OperationsmodaratorselectedStatus = "IN PROGRESS";

  Orgdelegatedto: string[] = ["--Select--", "venkat","veeroju"];
  Orgdelegatedtouser = "User1";

  Activitiesdelegatedto: string[] = ["--Select--", "User1","user2"];
  Activitiesdelegatedtouser = "User1";

  Headquartersdelegatedto: string[] = ["--Select--", "User1","user2"];
  Headquartersdelegatedtouser = "User1";

  Operationsdelegatedto: string[] = ["--Select--", "User1","user2"];
  Operationsdelegatedtouser = "User1";

  OrgLastmodifiedBy = "User1";
  OrgLastModifedDate: String = new Date().toDateString();

  ActivitiesLastmodifiedBy = "User1";
  ActivitiesLastModifedDate: String = new Date().toDateString();

  HeadquartersLastmodifiedBy = "User1";
  HeadquartersLastModifedDate: String = new Date().toDateString();

  OperationsLastmodifiedBy = "User1";
  OperationsLastModifedDate: String = new Date().toDateString();
  
  
  OrgUserStatus="";
  ActivitiesUserStatus="";
  HeadquartersUserStatus="";
  OperationsUserStatus="";
  // Details to and from  html  -- Ends here 


=======
  Activitiesmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  ActivitiesmodaratorselectedStatus = "IN PROGRESS";

  Headquartersmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  HeadquartersmodaratorselectedStatus = "IN PROGRESS";

  Operationsmodaratorstatus: string[] = ["--Select--", "IN PROGRESS", "APPROVED", "DENIED"];
  OperationsmodaratorselectedStatus = "IN PROGRESS";

  Orgdelegatedto: string[] = ["--Select--", "User1"];
  Orgdelegatedtouser = "User1";

  Activitiesdelegatedto: string[] = ["--Select--", "User1"];
  Activitiesdelegatedtouser = "User1";

  Headquartersdelegatedto: string[] = ["--Select--", "User1"];
  Headquartersdelegatedtouser = "User1";

  Operationsdelegatedto: string[] = ["--Select--", "User1"];
  Operationsdelegatedtouser = "User1";

  OrgLastmodifiedBy = "User1";
  OrgLastModifedDate: String = new Date().toDateString();

  ActivitiesLastmodifiedBy = "User1";
  ActivitiesLastModifedDate: String = new Date().toDateString();

  HeadquartersLastmodifiedBy = "User1";
  HeadquartersLastModifedDate: String = new Date().toDateString();

  OperationsLastmodifiedBy = "User1";
  OperationsLastModifedDate: String = new Date().toDateString();

  // Details to and from  html  -- Ends here 







>>>>>>> .theirs
  constructor(private logger: LogService, private esgdetailsService: EsgdetailsService) { }

  ngOnInit(): void {
    this.esgdetailsService.show()
      .subscribe(
        response => {
          console.log(response);
          this.esgdetailsbankname = response[0]['esgDetailTextValue'];
          this.esgdetailsbankinfo1 = response[1]['esgDetailTextValue'];
          this.esgdetailsbankinfo2 = response[2]['esgDetailTextValue'];
          this.esgdetailsbankinfo3 = response[3]['esgDetailTextValue'];

          this.esgdetails.txtOrganization = this.esgdetailsbankname;
          this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
          this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
          this.esgdetails.txtOperations = this.esgdetailsbankinfo3;
          

          


          console.log(response[0]['lastModifiedBy']['username']);
          this.OrgLastmodifiedBy               = response[0]['lastModifiedBy']['username'];
          this.ActivitiesLastmodifiedBy        =         response[1]['lastModifiedBy']['username'];
          this.HeadquartersLastmodifiedBy      =        response[2]['lastModifiedBy']['username'];
          this.OperationsLastmodifiedBy        =       response[3]['lastModifiedBy']['username'];
          
          
          
          
          
          this.OrgmodaratorselectedStatus             = this.Orgmodaratorstatus[response[0]['moderatorStatusId']['id']];         
          this.ActivitiesmodaratorselectedStatus      = this.Activitiesmodaratorstatus[response[1]['moderatorStatusId']['id']];   
          this.HeadquartersmodaratorselectedStatus    = this.Headquartersmodaratorstatus[response[2]['moderatorStatusId']['id']];     
          this.OperationsmodaratorselectedStatus      = this.Operationsmodaratorstatus[response[3]['moderatorStatusId']['id']];
        

          console.log(response[0]['delegateTo']['username']);
        this.Orgdelegatedtouser = this.Orgdelegatedto[response[0]['delegateTo']['id']];
        this.Activitiesdelegatedtouser = this.Activitiesdelegatedto[response[1]['delegateTo']['id']];
        this.Headquartersdelegatedtouser = this.Headquartersdelegatedto[response[2]['delegateTo']['id']];
        this.Operationsdelegatedtouser = this.Operationsdelegatedto[response[3]['delegateTo']['id']];
           
        
             this.OrgLastModifedDate             = response[0]['lastModifiedDate'];
             this.ActivitiesLastModifedDate      =         response[1]['lastModifiedDate'];
             this.HeadquartersLastModifedDate    =        response[2]['lastModifiedDate'];
             this.OperationsLastModifedDate      =       response[3]['lastModifiedDate'];

 
 this.OrgUserStatus     = response[0]['userStatusId']['status'];    
 this.ActivitiesUserStatus       =         response[1]['userStatusId']['status'];  
 this.HeadquartersUserStatus       =        response[2]['userStatusId']['status'];    
 this.OperationsUserStatus     =        response[2]['userStatusId']['status'];

        },
        error => {
          console.log(error);
        });
  }

<<<<<<< .mine
  // events - 102-2 - starts here
  updatebankinfo() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankinfo;
    //this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;
=======
  // events - 102-2 - starts here
  updatebankinfo() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankinfo;
    this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;
>>>>>>> .theirs

<<<<<<< .mine
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
=======
  }
  updatebankactivity() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankactivity;
    this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;

  }
  updatebankservice() {
    this.esgdetailsbankinfo1 += this.esgdetailsbankservice;
    this.esgdetailusermodifiedmodel.txtactivitiesModifiedby = 1;
  }
  // events - 102-2 - ends here
  // events - 102-3 - starts here
>>>>>>> .theirs
  updatebanklocation() {
    this.esgdetailsbankinfo2 += this.esgdetailsbanklocation;
<<<<<<< .mine
    //this.esgdetailusermodifiedmodel.txtheadquartersModifiedby = 1;
=======
    this.esgdetailusermodifiedmodel.txtheadquartersModifiedby = 1;
>>>>>>> .theirs
  }
  // events - 102-3 - ends here

  // events - 102-4 - starts here
  updatebankoperation1() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation1;
    this.esgdetailusermodifiedmodel.txtoperationsModifiedby = 1;
  }

  updatebankoperation2() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation2;
    this.esgdetailusermodifiedmodel.txtoperationsModifiedby = 1;
  }
  // events - 102-4 - ends here

  onSaveContinue($event) {
    this.esgdetails.txtOrganization = this.esgdetailsbankname;
    this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

    this.esgdetailusermodifiedmodel.txtorganizationModifiedby = 1; // this might need a condition

    this.esgdetailuserstatusmodel.txtorganizationStatus = 1;
    this.esgdetailuserstatusmodel.txtactivitiesStatus = 1;
    this.esgdetailuserstatusmodel.txtheadquartersStatus = 1;
    this.esgdetailuserstatusmodel.txtoperationsStatus = 1;




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

  }


  onSaveSubmit($event) {
    this.esgdetails.txtOrganization = this.esgdetailsbankname;
    this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

<<<<<<< .mine
    this.esgdetailusermodifiedmodel.txtorganizationModifiedby = 1; // this might need a condition

    this.esgdetailuserstatusmodel.txtorganizationStatus = 2;
    this.esgdetailuserstatusmodel.txtactivitiesStatus = 2;
    this.esgdetailuserstatusmodel.txtheadquartersStatus = 2;
    this.esgdetailuserstatusmodel.txtoperationsStatus = 2;



=======
    this.esgdetailusermodifiedmodel.txtorganizationModifiedby = 1; // this might need a condition

    this.esgdetailuserstatusmodel.txtorganizationStatus = 1;
    this.esgdetailuserstatusmodel.txtactivitiesStatus = 1;
    this.esgdetailuserstatusmodel.txtheadquartersStatus = 1;
    this.esgdetailuserstatusmodel.txtoperationsStatus = 1;



>>>>>>> .theirs
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

  }

  onExport($event) {
    console.log("Export button is clicked!", $event);

  }

  onPrint($event) {
    console.log("Print button is clicked!", $event);
  }

}
