var MRFWheel = /** @class */ (function () {
    function MRFWheel() {
        console.log("MRFWheel instance created..");
    }
    MRFWheel.prototype.rotate = function () {
        console.log("MRFWheel rotating...");
    };
    return MRFWheel;
}());
var CEATWheel = /** @class */ (function () {
    function CEATWheel() {
        console.log("CEATWheel instance created..");
    }
    CEATWheel.prototype.rotate = function () {
        console.log("CEATWheel rotating...");
    };
    return CEATWheel;
}());
var Car = /** @class */ (function () {
    function Car(wheel) {
        this.wheel = wheel;
        console.log("Car instance created..");
    }
    Car.prototype.move = function () {
        this.wheel.rotate();
        console.log("Car is moving..");
    };
    return Car;
}());
// dependency / injectable objects
var mrfWheel = new MRFWheel();
var ceatWheel = new CEATWheel();
// dependent
var car = new Car(ceatWheel);
car.move();
car.move();
