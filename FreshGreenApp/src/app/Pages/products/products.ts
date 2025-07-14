import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { StoreService } from '../../Service/store-service/store-service';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './products.html',
  styleUrls: ['./products.css']
})

export class Products implements OnInit {
  products: any = []; // Array to hold product data
  ngOnInit() {
    return this.service.getProducts().subscribe(data => {
      this.products = data;
      //console.log(this.products);
    });
  }
  quantity: number = 1; // Default quantity for 
  constructor(private service: StoreService) {
    // Initialize products from service or static data
    this.products = this.service.getProducts();
  }
  getProducts() {
    return this.products;
  }
  /*products = [
  {
    productImage: 'images/tomato.jpg',
    productName: 'Tomato',
    productCategory: 'Vegetables',
    productDescription: 'Fresh red tomatoes',
    productPrice: 30,
    productStock: 10,
    selectedQuantity: 1 
  },
  {
    productImage: 'images/potato.jpg',
    productName: 'Potato',
    productCategory: 'Vegetables',
    productDescription: 'Organic farm potatoes',
    productPrice: 20,
    productStock: 0,
    selectedQuantity: 1
  },
  {
    productImage: 'images/apple.jpg',
    productName: 'Apple',
    productCategory: 'Fruits',
    productDescription: 'Crisp and juicy apples',
    productPrice: 50,
    productStock: 5,
    selectedQuantity: 1
  },
  {
    productImage: 'images/banana.jpg',
    productName: 'Banana',
    productCategory: 'Fruits',
    productDescription: 'Sweet bananas',
    productPrice: 25,
    productStock: 8,
    selectedQuantity: 1
  },
  {
    productImage: 'images/bread.webp',
    productName: 'White Bread',
    productCategory: 'Breads',
    productDescription: 'White bread loaf',
    productPrice: 18,
    productStock: 12,
    selectedQuantity: 1
  },
  {
    productImage: 'images/cashew.jpg',
    productName: 'Cashew Nuts',
    productCategory: 'Dry Fruits & Nuts',
    productDescription: 'Gourmet cashew nuts per 200g',
    productPrice: 50,
    productStock: 10,
    selectedQuantity: 1
  },
  {
    productImage: 'images/milk.jpg',
    productName: 'Milk',
    productCategory: 'Dairy',
    productDescription: 'Fresh cow milk',
    productPrice: 30,
    productStock: 20,
    selectedQuantity: 1
  },
  {
    productImage: 'images/yogurt.jpg',
    productName: 'Yogurt',
    productCategory: 'Dairy',
    productDescription: 'Plain yogurt',
    productPrice: 35,
    productStock: 18,
    selectedQuantity: 1
  }
];*/

  productCategories = [...new Set(this.products.map((p: { productCategory: any; }) => p.productCategory))];
  selectedCategory = this.productCategories[0]; // Default to first category

  selectCategory(category: any) {
    //console.log("Category selected:", category); 
    this.selectedCategory = category;
  }


  getFilteredProducts() {
    return this.products.filter(((p: { productCategory: any; }) => p.productCategory === this.selectedCategory));
  }

  addToCart(product: any) {
    if (product.selectedQuantity > product.productStock) {
      alert('Not enough stock!');
      return;
    }
    product.productStock -= product.selectedQuantity;
    alert(`${product.selectedQuantity} ${product.productName}(s) added to cart`);
    product.selectedQuantity = 1;
  }

  restockProduct(product: any) {
    const qty = Number(prompt(`Enter quantity to restock for ${product.productName}:`));
    if (!isNaN(qty) && qty > 0) {
      product.productStock += qty;
    }
  }
}
