import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CatComponent } from './cat.component';
import { HighlightDirective } from './highlight.directive';
import { ProductComponent } from './product/product.component';
import { DivPipe } from './div.pipe';
import { CatService } from './cat.service';

@NgModule({
  declarations: [
    AppComponent,
    CatComponent,
    HighlightDirective,
    ProductComponent,
    DivPipe,
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    CatService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
