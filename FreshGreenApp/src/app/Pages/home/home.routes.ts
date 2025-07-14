import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Products } from '../products/products';
import { Contact } from '../contact/contact';
import { Register } from '../register/register';

export const routes: Routes = [
    { path: 'products', component: Products },
    { path: 'contact', component: Contact },
    { path: 'register', component: Register }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HomeRoutingModule {}