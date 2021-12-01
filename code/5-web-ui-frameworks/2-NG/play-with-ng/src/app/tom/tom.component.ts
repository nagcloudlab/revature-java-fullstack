import { Component, OnInit } from '@angular/core';
import { FightService } from '../svc/fight.service';

// dependent

@Component({
  selector: 'app-tom',
  templateUrl: './tom.component.html',
  styleUrls: ['./tom.component.scss']
})
export class TomComponent {

  fightCount = 0;

  // fightService = new FightService() // 

  // private fightService: FightService;
  // constructor(fightService: FightService) {
  //   this.fightService = fightService;
  // }

  // or

  constructor(private fightService: FightService) { } // dependecy injection


  doFight() {
    this.fightService.incrementFightCount();
    this.fightCount = this.fightService.totalFightCount;
  }

}
