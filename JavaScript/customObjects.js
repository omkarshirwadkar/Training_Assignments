function display(obj){
    console.log("Name: " + obj.name);
    console.log("Age: " + obj.age);
    console.log("Salary: " + obj.salary);
    console.log("Designation: " + obj.designation);
}

console.log("\n<--------- Using Object as a Constructor ---------->");

var emp1 = new Object();
emp1.name = "Sunil";
emp1.age = 30;
emp1.salary = 50000;
emp1.designation = "Programmer";

display(emp1);


console.log("\n<------------ Using Function as a Constructor ---------->");

// this keyword is mandatory in a function
function Emp(n, a, s, d) {
    this.name = n;
    this.age = a;
    this.salary = s;
    this.designation = d;
}

var emp2 = new Emp("John", 30, 50000, "Manager");
var emp3 = new Emp("Jane", 25, 40000, "Developer");

display(emp2);
display(emp3);

console.log("\n<---------- Using JSON Format ---------->");
var emp4 = {
    "name": "Rahul",
    "age": 35,
    "salary": 60000,
    "designation": "Principal Engineer"
}
display(emp4);


console.log("\n<----------- Using Class (ES6) ---------->");
class Employee {
    constructor(name, age, salary, designation) {
        this.name = name;
        this. age = age;
        this.salary = salary;
        this. designation = designation;
    }
    display(){
        console.log("Name: " + this.name);
        console.log("Age: " + this.age);
        console.log("Salary: " + this.salary);
        console.log("Designation: " + this.designation);
    }
}

var emp5 = new Employee("Rohan", 40, 70000, "Senior Manager");
var emp6 = new Employee("Ria", 28, 45000, "Junior Engineer");
emp5.display();
emp6.display();


console.log("\n<---------------- Type of Employee Object ---------------->");
// Everything in JavaScript is an object
console.log(typeof emp1);
console.log(typeof emp2);
console.log(typeof emp3);
console.log(typeof emp4);
console.log(typeof emp5);
console.log(typeof emp6);