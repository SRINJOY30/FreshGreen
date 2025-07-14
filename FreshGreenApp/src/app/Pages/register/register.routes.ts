import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Privacy } from '../privacy/privacy';
import { Terms } from '../terms/terms';

export const routes: Routes = [
    { path: 'privacy', component: Privacy },
    { path: 'terms', component: Terms },
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class HomeRoutingModule {}