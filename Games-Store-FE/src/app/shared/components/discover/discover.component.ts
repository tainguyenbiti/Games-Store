import { Component } from '@angular/core';
import { Product } from 'src/app/core/models/product';
import { ProductService } from 'src/app/core/service/product.service';

@Component({
  selector: 'app-discover',
  templateUrl: './discover.component.html',
  styleUrls: ['./discover.component.scss']
})
export class DiscoverComponent {
  products!: Product[];
  constructor(private productService: ProductService) { }
  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      (response: any) => {
        this.products = response.data
      },
      (err: any) => {
        console.error(err);
      }
    )
  }
}
