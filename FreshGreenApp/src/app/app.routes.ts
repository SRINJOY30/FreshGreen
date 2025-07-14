import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Home } from './Pages/home/home';
import { Login } from './Pages/login/login';
import { Products } from './Pages/products/products';
import { Cart } from './Pages/cart/cart';
import { Contact } from './Pages/contact/contact';
import { About } from './Pages/about/about';
import { Privacy } from './Pages/privacy/privacy';
import { Terms } from './Pages/terms/terms';
import { Register } from './Pages/register/register';

export const routes: Routes = [
  { path: 'home',component: Home},
  { path: 'login', component: Login },
  { path: 'products', component: Products },
  { path: 'cart', component: Cart },
  { path: 'contact', component: Contact },
  { path: 'about', component: About },
  { path: 'privacy', component: Privacy },
  { path: 'terms', component: Terms },
  { path: 'register', component: Register },
  { path: '', redirectTo: '/home', pathMatch: 'full' }, // Redirect to home on empty path
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
