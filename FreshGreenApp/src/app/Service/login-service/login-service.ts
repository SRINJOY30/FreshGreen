import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class LoginService {
  private loginUrl = 'http://localhost:8080/store/login';

  constructor(private http: HttpClient) {}

  login(credentials: any): Observable<string> {
    return this.http.post(this.loginUrl, credentials, { responseType: 'text' });
  }
}