import { Injectable, NgModule } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterModule, RouterStateSnapshot, Routes } from '@angular/router';
import { DistributionComponent } from './shared/components/header/distribution/distribution.component';
import { SupportComponent } from './shared/components/header/support/support.component';
import { HomeComponent } from './shared/components/home/home.component';
import { BrowseComponent } from './shared/components/browse/browse.component';
import { NewsComponent } from './shared/components/news/news.component';
import { DiscoverComponent } from './shared/components/discover/discover.component';
import { WishlistComponent } from './shared/components/wishlist/wishlist.component';
import { CartComponent } from './shared/components/cart/cart.component';
import { UserLoginComponent } from './shared/components/user-login/user-login.component';
import { LayoutComponent } from './shared/components/layout/layout.component';
import { ProductComponent } from './shared/components/product/product.component';

const routes: Routes = [
  {
    path: '', component: LayoutComponent,
    children: [
      {
        path: 'home', component: HomeComponent,
        children: [
          { path: 'discover', component: DiscoverComponent },
          { path: 'browser', component: BrowseComponent },
          { path: 'news', component: NewsComponent },
          { path: 'wishlist', component: WishlistComponent },
          { path: 'cart', component: CartComponent },
        ]

      },
      { path: '', redirectTo: 'home/discover', pathMatch: 'full' },
      { path: 'distribution', component: DistributionComponent },

    ]
  },
  { path: 'login', component: UserLoginComponent },
  { path: 'support', component: SupportComponent },
  { path: 'product', component: ProductComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}