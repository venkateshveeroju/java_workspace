import { Component } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '@app/_models';
import { UserService, AuthenticationService } from '@app/_services';
import { TokenStorageService } from '../_services/token-storage.service';
@Component({ templateUrl: 'home.component.html' })
export class HomeComponent {
    loading = false;
    users: User[];
    isloggedinhide : boolean;
    constructor(private userService: UserService,private tokenStorage: TokenStorageService) { }

    ngOnInit() {
        this.loading = true;
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.loading = false;
            this.users = users;
            if (Number(this.tokenStorage.getLoggedinUserRecordId) !=0){
                console.log("HomeComponent visibile :")
                this.isloggedinhide = true;
                //this.visibility ='hidden';)
          
              }
        });
    }
}