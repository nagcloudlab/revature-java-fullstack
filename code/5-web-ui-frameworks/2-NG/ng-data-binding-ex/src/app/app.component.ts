import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'ng-data-binding-ex';
  lightStatus = false
  lightImage = "assets/light-off.jpeg"
  myName = ""

  fg = this.fb.group({
    name: ['']
  });

  constructor(private fb: FormBuilder) { }



  resetMyName() {
    this.myName = "";
  }


  handleTitleChange(event: Event) {
    this.title = "NG-DATA-BINDING"
  }
  toggleLight(event: Event) {
    this.lightStatus = !this.lightStatus;
    if (this.lightStatus)
      this.lightImage = "assets/light-on.jpeg"
    else
      this.lightImage = "assets/light-off.jpeg"
  }

}
