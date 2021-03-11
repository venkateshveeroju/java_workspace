import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/esgdetails';

@Injectable({
    providedIn: 'root'
  })

  export class EsgdetailsService {
    constructor(private http: HttpClient) { }
       
      save(data) {
        return this.http.post(baseUrl+"/save", data);
      }
       
      show() {
        return this.http.get(baseUrl+"/getesgdetails");
      }
      onDelgate(data) {
        return this.http.post(baseUrl+"/updatedelegateto",data);
      }
      onExport() {
        return this.http.get(baseUrl+"/getpdf");
      }
      onNotifyModerator() {
        return this.http.post("http://localhost:8080/api/users/notifyModerators","ss");
      }
      
    
  }