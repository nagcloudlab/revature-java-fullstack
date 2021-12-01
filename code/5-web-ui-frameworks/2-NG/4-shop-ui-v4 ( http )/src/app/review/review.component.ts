import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss']
})
export class ReviewComponent {


  @Input("value")
  review: any = {}

  starsArray: Array<number> = []

  ngOnChanges() {
    this.starsArray = Array(this.review.stars).fill(0);
  }



}
