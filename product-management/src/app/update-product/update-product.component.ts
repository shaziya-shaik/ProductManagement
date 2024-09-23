import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Product } from '../product.model.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-product',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './update-product.component.html',
})
export class UpdateProductComponent implements OnInit {
  product: Product = new Product(); // Product to be updated
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadProduct();
  }

  loadProduct(): void {
    const id = Number(this.route.snapshot.paramMap.get('id')); // Get the product ID from the route
    this.productService.getById(id).subscribe(
      (data) => {
        this.product = data; // Populate the product data
      },
      (error) => {
        this.errorMessage = 'Error fetching product details. Please try again.';
      }
    );
  }

  updateProduct(): void {
    this.productService.updateProduct(this.product).subscribe(
      () => {
        this.successMessage = 'Product updated successfully!';
        this.errorMessage = null; // Clear any previous error message
        setTimeout(() => {
          this.router.navigate(['']); // Navigate back to the product list after a short delay
        }, 2000);
      },
      (error) => {
        this.errorMessage = 'Error updating product. Please try again.';
        this.successMessage = null; // Clear any previous success message
      }
    );
  }
}
