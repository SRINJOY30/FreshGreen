import { Component, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-store-service',
  imports: [],
  templateUrl: './store-service.html',
  styleUrl: './store-service.css'
})
@Injectable({
  providedIn: 'root'})
  
export class StoreService {
  private apiUrl = 'http://localhost:8080/store'; // Adjust the URL as needed

  constructor(private http: HttpClient) {}

  getProducts(): Observable<any> {
    return this.http.get(`${this.apiUrl}/products`);
  }

  getProductById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/products/${id}`);
  }

  addProduct(product: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/products`, product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/products/${id}`);
  }

}
