import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent {

  @Input("value") product: any;

  currentTab: number = 1;

  handleTabChange(e: Event, tabIndex: number) {
    // console.log("handling tab change..");
    // console.log(e);
    // console.log(tabIndex);
    this.currentTab = tabIndex;
  }

}
