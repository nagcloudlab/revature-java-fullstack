import { Component, Input, Output, ViewChild, EventEmitter, SimpleChange, ElementRef } from "@angular/core";
import { CatService } from "./cat.service";


@Component({
    selector: 'app-cat', // custom-tag-name
    templateUrl: 'cat.component.html',
})
export class CatComponent {

    @Input("value") name = 'Tom'
    @Input("img") image = "assets/tom.png"
    isImgVisibile = false
    @Output() sound = new EventEmitter() // custom cat event

    // @ViewChild("catbox") catBox!: ElementRef;

    time = new Date().toLocaleTimeString()
    intervalId: any = null;

    toggleImgVisibility(event: Event) {
        //event.preventDefault();
        this.isImgVisibile = !this.isImgVisibile;
    }

    handleTouch() {
        this.sound.emit({ name: this.name })
    }

    constructor() {
        console.log("CatComponent :: constructur");
    }

    /*
      // why we need ?
         to perform any side-effects 
         when component receiving new input properties
     */

    ngOnChanges(changes: SimpleChange) {
        console.log("CatComponent :: ngOnChanges");
        console.log(changes);
    }

    /*
     // why we need ?
      to perform any one time intialilization on comp-life
      e.g, subscribing with observable streams
    */

    ngOnInit() {
        console.log("CatComponent :: ngOnInit");
        this.intervalId = setInterval(() => {
            console.log("tick..");
            this.time = new Date().toLocaleTimeString()
        }, 1000)
    }

    /*
     // why we need ?
      to perform any clean-up before comp unmounted
      e.g, unsubscribing with observable streams
    */

    ngOnDestroy() {
        clearInterval(this.intervalId)
        console.log("CatComponent :: ngOnDestroy " + this.name);
    }


    // why we need
    /*
        can reference View Elements,
        and can peform any side effects on view elements
    */
    // ngAfterViewInit() {
    //     console.log("CatComponent::ngAfterViewInit");
    //     const domEle = this.catBox.nativeElement
    //     domEle.addEventListener('mouseenter', (e: any) => {
    //         domEle.style.backgroundColor = "#DEF"
    //     })
    //     domEle.addEventListener('mouseleave', (e: any) => {
    //         domEle.style.backgroundColor = "#FFF"
    //     })
    // }


}