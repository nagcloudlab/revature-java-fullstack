import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'bookshop-web-ui';
  books=[
    {
      name:'book1',
      price:1000.00,
      description:'New Edition',
      isAvailable:false,
      image:'assets/book1.jpg'
    },
    {
      name:'book2',
      price:2000.00,
      description:'Old Edition',
      isAvailable:true,
      image:'assets/book2.jpg'
    },
  ]

}
