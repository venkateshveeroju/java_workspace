
import { Component, OnInit } from '@angular/core';
import { LogService } from '../_services/log.service';


@Component({
  selector: 'app-gri-generaldisclosures',
  templateUrl: './gri-generaldisclosures.component.html',
  styleUrls: ['./gri-generaldisclosures.component.css']
})
export class GriGeneraldisclosuresComponent implements OnInit {

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
 


  constructor(private logger: LogService) { }

  ngOnInit(): void {
  }

  update(value: string) { this.esgdetailsbankinfo1 += value; }
  update1(value: string) { this.esgdetailsbankinfo1 += value; }
  update2(value: string) { this.esgdetailsbankinfo1 += value; }

  update3(value: string) { this.esgdetailsbankinfo2 += value; }
  
  update4(value: string) { this.esgdetailsbankinfo3 += value; }
  
  
  onSaveContinue($event){    
    this.logger.log($event);
    this.logger.log("SaveContinue button is clicked!");    
   
  }    
  onSaveSubmit($event){    
    console.log("SaveSubmit button is clicked!", $event);    
   
  }
  onDelgate($event){    
    console.log("Delegate button is clicked!", $event);    
   
  }

  onExport($event){    
    console.log("Export button is clicked!", $event);    
   
  }

  onPrint($event){
    console.log("Print button is clicked!", $event);
  }
  
}
