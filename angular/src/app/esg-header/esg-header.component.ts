import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
@Component({
  selector: 'app-esg-header',
  templateUrl: './esg-header.component.html',
  styleUrls: ['./esg-header.component.css']
})
export class EsgHeaderComponent implements OnInit {
  //visibility='hidden';
  isloggedinhide = false;
  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      console.log("visibile :")
      //this.isloggedinhide = true;
      //this.visibility ='hidden';

    }
  }
  public getisloggedinhideValue(): boolean {
    return this.isloggedinhide;
  }
  public setisloggedinhideValue(isloggedinhide: boolean): void {
    this.isloggedinhide = isloggedinhide;
  }


}
