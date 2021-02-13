import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const baseUrl = 'http://localhost:8080/api/esgdetalis';

@Injectable({
    providedIn: 'root'
  })

  export class EsgdetailsService {
    constructor(private http: HttpClient) { }
       
      save(data) {
        return this.http.post(baseUrl, data);
      }
    
     
  }