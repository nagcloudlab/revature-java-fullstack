import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  @Input("value")
  v:any={};

  currentTab=1

  reviews:Array<any>=[
    {stars:5,body:'sample-review-1',author:'who1'},
    {stars:2,body:'sample-review-2',author:'who1'}
  ]

  changeTab(tabIndex:number){
    this.currentTab=tabIndex;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
