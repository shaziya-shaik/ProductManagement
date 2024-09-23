export class Product {
  id?: number;       // Optional: Only present when the product is fetched from the backend
  name: string = ''; // Product name
  type: string = ''; // Product type
  place: string = ''; // Product location
  warranty: number = 0; // Warranty period in years
}