import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class CartService {
  private baseUrl = 'http://localhost:8080/store/cart';

  constructor(private http: HttpClient) {}

  getCart(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  addToCart(cartItem: any): Observable<string> {
    return this.http.post(this.baseUrl, cartItem, { responseType: 'text' });
  }

  removeFromCart(productName: string): Observable<string> {
    return this.http.delete(`${this.baseUrl}/${productName}`, { responseType: 'text' });
  }
}

