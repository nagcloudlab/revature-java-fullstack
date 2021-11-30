import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-voting-box',
  templateUrl: './voting-box.component.html',
  styleUrls: ['./voting-box.component.scss']
})
export class VotingBoxComponent {

  items: Array<string> = [
    "java",
    "html",
    "js",
    "ng"
  ]

  voteLines: Array<any> = []

  handleVote(event: any) {
    let { itemName, value } = event; // de-structuring
    let votingLine = this.voteLines.find(line => line.itemName === itemName);
    if (votingLine) {
      if (value > 0)
        votingLine.p += 1
      if (value < 0)
        votingLine.n += 1
    }
    else {
      votingLine = { itemName, [value > 0 ? 'p' : 'n']: 1, [value < 0 ? 'p' : 'n']: 0 }
      this.voteLines.push(votingLine)
    }
  }
}
