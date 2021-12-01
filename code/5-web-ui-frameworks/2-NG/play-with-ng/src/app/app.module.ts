import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VotingBoxComponent } from './voting-box/voting-box.component';
import { VotingItemComponent } from './voting-item/voting-item.component';
import { VotingTableComponent } from './voting-table/voting-table.component';
import { TomComponent } from './tom/tom.component';
import { JerryComponent } from './jerry/jerry.component';
import { CartoonComponent } from './cartoon/cartoon.component';

@NgModule({
  declarations: [
    AppComponent,
    VotingBoxComponent,
    VotingItemComponent,
    VotingTableComponent,
    TomComponent,
    JerryComponent,
    CartoonComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
