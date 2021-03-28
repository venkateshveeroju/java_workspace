import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../_services/token-storage.service';
import { AuthService } from '../_services/auth.service';
import { LoginComponent } from '../login/login.component';
@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css']
})
export class UserInfoComponent implements OnInit {

  loggedinUser: string;
  onloginsuccess: boolean;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.tokenStorage.getLoggedinUserRecord().subscribe(params => {
      //console.log("Param:" + params)
      this.loggedinUser = params
      if (this.tokenStorage.getToken()) {
        this.onloginsuccess = true;
      }
    });
  }
  onSignout() {
    this.authService.logout();
    this.onloginsuccess = false;
  }

}
