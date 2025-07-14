import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ContactService {
  private contactUrl = 'http://localhost:8080/store/contact';

  constructor(private http: HttpClient) {}

  submitContact(formData: any): Observable<string> {
    return this.http.post(this.contactUrl, formData, { responseType: 'text' });
  }
}