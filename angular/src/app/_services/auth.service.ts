import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }
  logout() {
    // remove user from local storage to log user out
    console.log("AuthService");
    localStorage.removeItem('currentUser');
    localStorage.setItem('currentUser', null);
    window.sessionStorage.removeItem(localStorage.getItem('currentUser'));
    window.sessionStorage.clear();
    this.router.navigate(['/login']);
   // this.currentUserSubject.next(null);
}
  
  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password
    }, httpOptions);
  } 
}