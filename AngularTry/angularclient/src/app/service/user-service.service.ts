import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usertable } from '../model/usertable';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<Usertable[]> {
    return this.http.get<Usertable[]>(this.usersUrl);
  }

  public save(user: Usertable) {
    return this.http.post<Usertable>(this.usersUrl, user);
  }
}
