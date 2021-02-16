

import { Component, OnInit } from '@angular/core';
import { LogService } from '../_services/log.service';
import { EsgdetailsService } from './../_services/esgdetails.service';

@Component({
  selector: 'app-gri-generaldisclosures',
  templateUrl: './gri-generaldisclosures.component.html',
  styleUrls: ['./gri-generaldisclosures.component.css']
})
export class GriGeneraldisclosuresComponent implements OnInit {

  esgdetails = {
    txtOrganization: '',
    txtActivities: '',
    txtHeadquarters: '',
    txtOperations: ''

  };

  submitted = false;

  esgdetailsbankname = '';

  clickedesgdetailsbankinfo=false;
  clickedesgdetailsbankactivity=false;
  clickedesgdetailsbankservice=false;
  esgdetailsbankinfo = '____ is a leading ____ and a major ____ in ___';
  esgdetailsbankactivity = 'Our market activities focus on business with ___';
  esgdetailsbankservice = '...';

  clickedbanklocation = false;
  esgdetailsbanklocation = 'The main location of ____ is: ____';

  clickedbankoperation1 = false;
  clickedbankoperation2 = false;
  esgdetailsbankoperation1 = '____ has its main office in ____.';
  esgdetailsbankoperation2 = 'In addition, the bank has ____ in the economic';

  esgdetailsbankinfo1 = '';
  esgdetailsbankinfo2 = '';
  esgdetailsbankinfo3 = '';


  constructor(private logger: LogService, private esgdetailsService: EsgdetailsService) { }

  ngOnInit(): void {
    this.esgdetailsService.show()
      .subscribe(
        response => {
          console.log(response);
          this.esgdetailsbankname=response[0]['esgDetailTextValue'];
          this.esgdetailsbankinfo1=response[1]['esgDetailTextValue'];
          this.esgdetailsbankinfo2=response[2]['esgDetailTextValue'];
          this.esgdetailsbankinfo3=response[3]['esgDetailTextValue'];
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  updatebankinfo() { this.esgdetailsbankinfo1 += this.esgdetailsbankinfo; }
  updatebankactivity() { this.esgdetailsbankinfo1 += this.esgdetailsbankactivity; }
  updatebankservice() { this.esgdetailsbankinfo1 += this.esgdetailsbankservice; }

  updatebanklocation() {
    this.esgdetailsbankinfo2 = this.esgdetailsbanklocation;
  }

  updatebankoperation1() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation1;
  }

  updatebankoperation2() {
    this.esgdetailsbankinfo3 += this.esgdetailsbankoperation2;
  }

  onSaveContinue($event) {
    this.esgdetails.txtOrganization = this.esgdetailsbankname;
    this.esgdetails.txtActivities = this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters = this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations = this.esgdetailsbankinfo3;

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
          this.submitted = true;
        },
        error => {
          console.log(error);
        });

  }


  onSaveSubmit($event) {
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
