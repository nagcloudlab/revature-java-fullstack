import { Injectable } from '@angular/core';

@Injectable()
export class CatService {

  cats: Array<any> = []

  addNewCat() {
    let cat = { id: this.cats.length + 1, name: `cat-${this.cats.length + 1}`, image: 'assets/cat1.jpeg' }
    this.cats.push(cat)
  }

  removeCat() {
    this.cats.splice(this.cats.length - 1, 1)
  }

  changeCatName() {
    let cat = this.cats[0]
    cat.name = "TOM"
  }

  changeCatImage() {
    let cat = this.cats[0]
    cat.image = "assets/cat2.jpeg"
  }



  constructor() { }



}
