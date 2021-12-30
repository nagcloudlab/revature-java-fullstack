import { Component, OnInit } from '@angular/core';
import {BookService} from "../book.service";
import {Book} from "../book";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books:Array<Book>=[]

  // dependency injection
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.books=this.bookService.getBooks()
  }

  handleDeleteBook(bookId:number){
    this.bookService.deleteBook(bookId)
  }

}
