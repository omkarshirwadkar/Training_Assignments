class Emp{
    name: string;
    age: number;
    // const company: string = "Wissen"; // const doesn't work here
    readonly company: string = "Wissen"; // readonly works here

    constructor( name: string, age: number ){
        this.name = name;
        this.age = age;
    }

    display(){
        console.log(`Name: ${this.name}, Age: ${this.age}, Company: ${this.company}`);
    }
}

let e1 = new Emp("John", 30);
e1.display();
e1.company = "Google";
e1.display();