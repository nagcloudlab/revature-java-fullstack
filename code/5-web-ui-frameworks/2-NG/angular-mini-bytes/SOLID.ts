
interface Wheel {
    rotate: () => void
}

class MRFWheel implements Wheel {
    constructor() {
        console.log("MRFWheel instance created..");
    }
    rotate() {
        console.log("MRFWheel rotating...");
    }
}

class CEATWheel implements Wheel {
    constructor() {
        console.log("CEATWheel instance created..");
    }
    rotate() {
        console.log("CEATWheel rotating...");
    }
}

class Car {
    wheel: Wheel;
    constructor(wheel: Wheel) {
        this.wheel = wheel;
        console.log("Car instance created..");
    }
    move() {
        this.wheel.rotate()
        console.log("Car is moving..");
    }
}

// dependency / injectable objects
const mrfWheel: Wheel = new MRFWheel();
const ceatWheel: Wheel = new CEATWheel();

// dependent
const car = new Car(ceatWheel);
car.move()
car.move()


// dependency inversion prinsiple