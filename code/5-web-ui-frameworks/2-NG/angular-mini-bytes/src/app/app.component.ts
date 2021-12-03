import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-mini-bytes';


  cats: Array<any> = []

  addNewCat(event: Event) {
    let cat = { id: this.cats.length + 1, name: `cat-${this.cats.length + 1}`, image: 'assets/cat1.jpeg' }
    this.cats.push(cat)
  }

  removeCat(event: Event) {
    this.cats.splice(this.cats.length - 1, 1)
  }

  changeCatName(event: Event) {
    let cat = this.cats[0]
    cat.name = "TOM"
  }

  changeCatImage(event: Event) {
    let cat = this.cats[0]
    cat.image = "assets/cat2.jpeg"
  }

  handleCatSound(event: any) {
    console.log(`app-root , handling cat:${event.name} sound event`);
  }

}
