import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'shop-web-ui-v1';

  products = [
    {
      name: 'Laptop',
      price: 149000,
      currencyCode: 'INR',
      description: 'New pro',
      isAvailable: true
    },
    {
      name: 'Mobile',
      price: 19000,
      currencyCode: 'INR',
      description: 'New model',
      isAvailable: true
    }
  ]

}
