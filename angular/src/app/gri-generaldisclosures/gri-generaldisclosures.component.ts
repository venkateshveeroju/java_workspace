import { Component, OnInit } from '@angular/core';

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
 


  constructor() { }

  ngOnInit(): void {
  }

  update(value: string) { this.esgdetailsbankinfo1 += value; }
  update1(value: string) { this.esgdetailsbankinfo1 += value; }
  update2(value: string) { this.esgdetailsbankinfo1 += value; }

  update3(value: string) { this.esgdetailsbankinfo2 += value; }
  
  update4(value: string) { this.esgdetailsbankinfo3 += value; }
  

}
