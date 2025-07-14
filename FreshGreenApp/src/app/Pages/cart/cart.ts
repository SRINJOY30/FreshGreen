import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-cart',
  imports: [CommonModule],
  templateUrl: './cart.html',
  styleUrl: './cart.css'
})
export class Cart {
  cartItems : any[] = [
  {
    product: { productName: 'Tomato', productPrice: 30 },
    count: 2,
    productPrice: 60
  }];

  removeFromCart(index: number): void {
    const removedItem = this.cartItems[index];

    // Add the quantity back to product stock
    const originalProduct = this.findProductById(removedItem.product.productId);
    if (originalProduct) {
      originalProduct.productStock += removedItem.count;
    }

    // Remove from cart
    this.cartItems.splice(index, 1);
  }

  findProductById(productId: number): any {
    // Replace this with actual product list or service
    const allProducts = JSON.parse(localStorage.getItem('products') || '[]');
    return allProducts.find((p: any) => p.productId === productId);
  }

  getTotalItems(): number {
    return this.cartItems.reduce((sum, item) => sum + item.count, 0);
  }

  getGrandTotal(): number {
    return this.cartItems.reduce((sum, item) => sum + item.productPrice, 0);
  }

}
