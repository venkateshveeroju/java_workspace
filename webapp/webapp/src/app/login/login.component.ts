import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  
  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit() {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
     
        this.roles = this.tokenStorage.getUser().roles;

        sessionStorage.setItem("loggedinUser",data.username);
        console.log("User Details username:"+sessionStorage.getItem("loggedinUser"));
        this.tokenStorage.setLoggedinUserRecord(sessionStorage.getItem("loggedinUser"));
       
      //
      sessionStorage.setItem("loggedinUserId",data.id);
      console.log(data.id + "  data.id");
      console.log("User Details loggedinUserID :"+sessionStorage.getItem("loggedinUserId"));
      this.tokenStorage.setLoggedinUserRecordId(Number(sessionStorage.getItem("loggedinUserId") ));

      sessionStorage.setItem("loggedinUserRole",data.roles);
      console.log("Role:"+sessionStorage.getItem("loggedinUserRole"));
      this.tokenStorage.setLoggedinUserRoleRecord(sessionStorage.getItem("loggedinUserRole"));

     // this.esgHeaderComponent.setisloggedinhideValue(true );
        this.router.navigate(['/gri102']);
        //this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage() {
    window.location.reload();
  }
}