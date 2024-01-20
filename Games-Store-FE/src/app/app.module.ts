import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { SupportComponent } from './shared/components/header/support/support.component';
import { DistributionComponent } from './shared/components/header/distribution/distribution.component';
import { ContentComponent } from './shared/components/content/content.component';
import { DiscoverComponent } from './shared/components/discover/discover.component';
import { BrowseComponent } from './shared/components/browse/browse.component';
import { NewsComponent } from './shared/components/news/news.component';
import { WishlistComponent } from './shared/components/wishlist/wishlist.component';
import { CartComponent } from './shared/components/cart/cart.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { HomeComponent } from './shared/components/home/home.component';
import { UserLoginComponent } from './shared/components/user-login/user-login.component';
import { LayoutComponent } from './shared/components/layout/layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { HttpClientModule } from "@angular/common/http";
import { ProductComponent } from './shared/components/product/product.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SupportComponent,
    DistributionComponent,
    ContentComponent,
    DiscoverComponent,
    BrowseComponent,
    NewsComponent,
    WishlistComponent,
    CartComponent,
    FooterComponent,
    HomeComponent,
    UserLoginComponent,
    LayoutComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
