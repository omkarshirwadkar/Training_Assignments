
class Emp{
    private name: string;
    age: number;
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }
    display(){
        console.log(`Name: ${this.name}, Age: ${this.age}`);
    }
}
export class Clerk extends Emp{
    salary: number;
    designation: string;
    constructor(name: string, age: number, salary: number, designation: string) {
        super( name, age );
        this.salary = salary;
        this.designation = designation;
    }

    display(): void {
        super.display();
        console.log(`Salary: ${this.salary}, Designation: ${this.designation}`);
    }
}
var e1 = new Emp("John", 25);
var e2 = new Emp("Jane", 33);
// e1.name = "Johnny";
e1.display();
e2.display();

console.log("--------------------------------------------------------------");

var c1 = new Clerk("John", 25, 50000, "Manager");
var c2 = new Clerk("Jane", 33, 60000, "HR");

c1.display();
c2.display();


class A{
    constructor(){
        console.log("A()");
    }
}

class B extends A{
    constructor(){
        super(); // without this line, it will throw an error
        // The subclass constructor must call the superclass constructor
        console.log("B()");
    }
}

var a1 = new B();
console.log("-----------------------------------------------------------");
interface Car{
    accelerate(): void;
    brake():  void;
}

class HatatchBack implements Car{
    speed : number;
    accelerate(): void {
        this.speed += 10;
        console.log("Accelator " + this.speed);   
    }
    brake (): void {
        this.speed -= 10;
        console.log("Brake" + this.speed);
    }
}

var h1 = new HatatchBack();
h1.accelerate();
h1.brake();

interface CarProperties{
    company: string;
    model: string;
    price: number;
    gear?: boolean;
}

let m1:CarProperties = {"company": "Maruti", "model":"Brezza", "price": 1900000, "gear": true};
let m2:CarProperties = {"company": "BMW", "model": "BRE", "price": 198289};

console.log(m1);
console.log(m2);

console.log("----------------------------------------------------------------------");

let arr1:string[] = ["Hi", "Hello", "World", "Python", "Java"];
let arr2:Array<String> = ["Hi", "Hello", "World", "Python", "Java"];

console.log(arr1);
console.log(arr2);

console.log("------------------------------------------------------------------------");

var a = 10;
var b = 20;
console.log("The sum of " + a + " and " + b + " is " + (a + b));
console.log(`The sum of ${a} and ${b} is ${a + b}`);

class Person{
    name: string;
    constructor(name: string){
        console.log("Person constructor called");
        this.name = name;
        // One solution is to use a getter
        // var self = this;
        // setTimeout(function(){
        //     console.log("Hello " + self.name);
        // }, 2000);

        // using arrow function
        setTimeout(() => {
            console.log("Hello " + this.name);
        } , 2000);
        console.log("End of constructor");
        
    }
}
new Person("Rahul");
console.log("This statement will not wait for anyone");