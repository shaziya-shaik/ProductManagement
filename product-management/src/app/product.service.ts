import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './product.model.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8080'; // Base URL for your Spring Boot application

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/`); // Matches GET /
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiUrl}/product`, product); // Matches POST /product
  }

  updateProduct(product: Product): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/product/${product.id}`, product); // Matches PUT /product/{id}
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/product/${id}`); // Matches DELETE /product/{id}
  }

  getById(id: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/product/${id}`); // Matches GET /product/{id}
  }
}
