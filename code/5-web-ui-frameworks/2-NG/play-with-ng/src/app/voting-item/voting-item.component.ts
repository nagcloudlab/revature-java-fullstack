import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-voting-item',
  templateUrl: './voting-item.component.html',
  styleUrls: ['./voting-item.component.scss']
})
export class VotingItemComponent {

  @Input()
  itemName: string = ""

  count = 0;

  @Output()
  vote = new EventEmitter();


  handleCount(value: number) {
    this.count += value
    // emitting event..
    this.vote.emit({ itemName: this.itemName, value })
  }

}
