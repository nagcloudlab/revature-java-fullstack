import { Injectable } from '@angular/core';
import {Book} from "./book";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private books:Array<Book>=[
    {
      id:1,
      name:'java',
      price:1000.00,
      author:'Nag'
    },
    {
      id:2,
      name:'javascript',
      price:500.00,
      author:'charles'
    }
  ]

  getBooks(){
    return this.books;
  }
  deleteBook(bookId:number){
    const idx=this.books.findIndex(book=>book.id===bookId)
    this.books.splice(idx,1)
  }


  constructor() { }
}
