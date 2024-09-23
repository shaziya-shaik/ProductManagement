// src/app/app-routing.module.ts
import { Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';

const routes: Routes = [
  { path: '', component: ProductComponent }, // Default route
  { path: 'add', component: AddProductComponent },
  { path: 'edit/:id', component: UpdateProductComponent }
  // Add more routes here if needed
];

export default routes;
