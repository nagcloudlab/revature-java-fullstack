import { Component, OnInit } from '@angular/core';
import { FightService } from '../svc/fight.service';

@Component({
  selector: 'app-jerry',
  templateUrl: './jerry.component.html',
  styleUrls: ['./jerry.component.scss']
})
export class JerryComponent {

  fightCount = 0;

  // fightService = new FightService()
  constructor(private fightService: FightService) { } // dependecy injection

  doFight() {
    this.fightService.incrementFightCount();
    this.fightCount = this.fightService.totalFightCount;
  }

}
