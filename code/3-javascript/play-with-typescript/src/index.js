class MRFWheel {
    rotate() {
        console.log("MRF Wheel rotating");
    }
}
class CEATWheel {
    rotate() {
        console.log("MRF Wheel rotating");
    }
}
class Car {
    setWheel(wheel) {
        this.wheel = wheel;
    }
    move() {
        this.wheel.rotate();
        console.log("car moving");
    }
}
const car = new Car();
car.setWheel(new MRFWheel());
car.move();
car.setWheel(new CEATWheel());
car.move();
