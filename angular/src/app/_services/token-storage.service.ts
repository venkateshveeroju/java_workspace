import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  public loggedinUser: string={} as string;

  private loggedinUserRecord: BehaviorSubject<string> = new BehaviorSubject<string>(this.loggedinUser);

  public getLoggedinUserRecord():Observable<string>{
    return this.loggedinUserRecord.asObservable();
  }

  public setLoggedinUserRecord(loggedinUser: string): void {
    this.loggedinUserRecord.next(loggedinUser);
  }

  public loggedinUserRole: string={} as string;

  private loggedinUserRoleRecord: BehaviorSubject<string> = new BehaviorSubject<string>(this.loggedinUserRole);

  public getLoggedinUserRoleRecord():Observable<string>{
    return this.loggedinUserRoleRecord.asObservable();
  }

  public setLoggedinUserRoleRecord(loggedinUserRole: string): void {
    this.loggedinUserRoleRecord.next(loggedinUserRole);
  }



  public loggedinUserId: number={} as number;

  private loggedinUserRecordId: BehaviorSubject<number> = new BehaviorSubject<number>(this.loggedinUserId);

  public getLoggedinUserRecordId():Observable<number>{
    return this.loggedinUserRecordId.asObservable();
  }

  public setLoggedinUserRecordId(loggedinUserId: number): void {
    this.loggedinUserRecordId.next(loggedinUserId);
  }


  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser() {
    return JSON.parse(sessionStorage.getItem(USER_KEY));
  }


}