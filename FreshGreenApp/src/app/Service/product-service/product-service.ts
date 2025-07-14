import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProductService {
  private baseUrl = 'http://localhost:8080/store/products';

  constructor(private http: HttpClient) {}

  getProducts(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  addProduct(product: any): Observable<string> {
    return this.http.post(this.baseUrl, product, { responseType: 'text' });
  }

  restockProduct(productId: number, quantity: number): Observable<string> {
    return this.http.put(`${this.baseUrl}/restock/${productId}?quantity=${quantity}`, {}, { responseType: 'text' });
  }
}
