import { Injectable } from '@angular/core';

// dependency

// service holds shared data & non-ui logic

@Injectable({
  providedIn: 'root'
})
export class FightService {

  totalFightCount = 0;

  constructor() {
    console.log("FightService instance created..");
  }

  incrementFightCount() {
    this.totalFightCount++
  }

}
