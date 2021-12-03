import { Component } from '@angular/core';
import { CatService } from './cat.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'angular-mini-bytes';

  cats: Array<any> = []

  constructor(private catService: CatService) { }

  ngOnInit() {
    this.cats = this.catService.cats;
  }

  addNewCat(event: Event) {
    this.catService.addNewCat();
    this.cats = this.catService.cats;
  }

  removeCat(event: Event) {
    this.catService.removeCat()
    this.cats = this.catService.cats;
  }

  changeCatName(event: Event) {
    this.catService.changeCatName();
    this.cats = this.catService.cats;
  }

  changeCatImage(event: Event) {
    this.catService.changeCatImage();
    this.cats = this.catService.cats;
  }

  handleCatSound(event: any) {
    console.log(`app-root , handling cat:${event.name} sound event`);
  }

}
