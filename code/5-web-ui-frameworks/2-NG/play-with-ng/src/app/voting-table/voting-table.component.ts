import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-voting-table',
  templateUrl: './voting-table.component.html',
  styleUrls: ['./voting-table.component.scss']
})
export class VotingTableComponent {


  @Input("value")
  voteLines: Array<any> = []

}
