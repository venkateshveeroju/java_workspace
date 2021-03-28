import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8080/api/users';

@Injectable({
  providedIn: 'root'
})
export class EsgDetailStatusService {

  constructor(private http: HttpClient) { }
  getUsersList(): Observable<any>{
    console.log("  getUsersList()  "+this.http.get(API_URL+"/getAllUsers"));
    return this.http.get(API_URL+"/getAllUsers");
  }
 
}