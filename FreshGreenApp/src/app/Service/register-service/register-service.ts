import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class RegisterService {
  private signupUrl = 'http://localhost:8080/store/signup';

  constructor(private http: HttpClient) {}

  register(userData: any): Observable<string> {
    return this.http.post(this.signupUrl, userData, { responseType: 'text' });
  }
}
