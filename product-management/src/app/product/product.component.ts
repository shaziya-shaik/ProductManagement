import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product.model.model';
import { ProductService } from '../product.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  filteredProducts: Product[] = [];
  searchTerm: string = '';
  selectedProduct: Product | null = null;
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private productService: ProductService, private router: Router) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
      this.filteredProducts = data;
    });
  }

  filterProducts(): void {
    if (!this.searchTerm) {
      this.filteredProducts = this.products;
    } else {
      this.filteredProducts = this.products.filter(product =>
        product.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    }
  }

  searchById(): void {
    const id = parseInt(this.searchTerm, 10);
    if (!isNaN(id)) {
      this.productService.getById(id).subscribe(
        product => {
          this.selectedProduct = product;
        },
        () => {
          alert('Product not found!');
          this.selectedProduct = null;
        }
      );
    }
  }

  clearSearch(): void {
    this.searchTerm = '';
    this.selectedProduct = null;
    this.loadProducts();
  }

  editProduct(id: number): void {
    this.router.navigate(['/edit', id]);
  }

  confirmDelete(id: number): void {
    if (confirm(`Are you sure you want to delete the product with ID ${id}?`)) {
      this.productService.deleteProduct(id).subscribe(
        () => {
          this.successMessage = `Product with ID ${id} deleted successfully.`;
          this.errorMessage = null;
          this.loadProducts(); // Refresh the product list
        },
        error => {
          this.errorMessage = `Error deleting product with ID ${id}: ${error.message}`;
          this.successMessage = null;
        }
      );
    }
  }

  addProduct(): void {
    this.router.navigate(['/add']);
  }
}
