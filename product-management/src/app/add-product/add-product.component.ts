// src/app/add-product/add-product.component.ts
import { Component } from '@angular/core';
import { Product } from '../product.model.model';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-product.component.html',
})
export class AddProductComponent {
  newProduct: Product = new Product();
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private productService: ProductService, private router: Router) {}

  addProduct(): void {
    this.productService.addProduct(this.newProduct).subscribe(
      () => {
        this.successMessage = 'Product added successfully!';
        this.errorMessage = null; // Clear any previous error message
        this.newProduct = new Product(); // Reset the form
        setTimeout(() => {
          this.router.navigate(['']); // Navigate back to the product list after a short delay
        }, 2000);
      },
      (error) => {
        this.errorMessage = 'Error adding product. Please try again.';
        this.successMessage = null; // Clear any previous success message
      }
    );
  }
}
