

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
    txtOrganization:'',
    txtActivities: '',
    txtHeadquarters : '',
    txtOperations : ''

  };

  submitted = false;

  esgdetailsbankname = '';

  esgdetailsbankinfo = '____ is a leading ____ and a major ____ in ___';
  esgdetailsbankactivity = 'Our market activities focus on business with ___';
  esgdetailsbankservice = '...';

  esgdetailsbanklocation = 'The main location of ____ is: ____';

  esgdetailsbankoperation = '____ has its main office in ____.';
  esgdetailsbankoperation1 = 'In addition, the bank has ____ in the economic c';

  esgdetailsbankinfo1 = '';
  esgdetailsbankinfo2 = '';
  esgdetailsbankinfo3 = '';


  constructor(private logger: LogService, private esgdetailsService: EsgdetailsService) { }

  ngOnInit(): void {
  }

  update(value: string) { this.esgdetailsbankinfo1 += value; }
  update1(value: string) { this.esgdetailsbankinfo1 += value; }
  update2(value: string) { this.esgdetailsbankinfo1 += value; }

  update3(value: string) { this.esgdetailsbankinfo2 += value; }

  update4(value: string) { this.esgdetailsbankinfo3 += value; }


  onSaveContinue($event) {
    // this.logger.log($event);
    this.logger.log("SaveContinue button is clicked!");

    this.esgdetails.txtOrganization=this.esgdetailsbankname;
    this.esgdetails.txtActivities=this.esgdetailsbankinfo1;
    this.esgdetails.txtHeadquarters=this.esgdetailsbankinfo2;
    this.esgdetails.txtOperations=this.esgdetailsbankinfo3;

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
