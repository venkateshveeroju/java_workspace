import { Component, OnInit,Input } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  loggedinUser : string;
  constructor(private tokenStorage: TokenStorageService) {  }

  ngOnInit(): void {
    this.tokenStorage.getLoggedinUserRecord().subscribe(params=>{console.log("Param:"+params)
     this.loggedinUser=params});

  }
  
}
