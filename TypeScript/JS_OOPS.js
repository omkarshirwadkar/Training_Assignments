"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Clerk = void 0;
var Emp = /** @class */ (function () {
    function Emp(name, age) {
        this.name = name;
        this.age = age;
    }
    Emp.prototype.display = function () {
        console.log("Name: ".concat(this.name, ", Age: ").concat(this.age));
    };
    return Emp;
}());
var Clerk = /** @class */ (function (_super) {
    __extends(Clerk, _super);
    function Clerk(name, age, salary, designation) {
        var _this = _super.call(this, name, age) || this;
        _this.salary = salary;
        _this.designation = designation;
        return _this;
    }
    Clerk.prototype.display = function () {
        _super.prototype.display.call(this);
        console.log("Salary: ".concat(this.salary, ", Designation: ").concat(this.designation));
    };
    return Clerk;
}(Emp));
exports.Clerk = Clerk;
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
var A = /** @class */ (function () {
    function A() {
        console.log("A()");
    }
    return A;
}());
var B = /** @class */ (function (_super) {
    __extends(B, _super);
    function B() {
        var _this = _super.call(this) || this; // without this line, it will throw an error
        // The subclass constructor must call the superclass constructor
        console.log("B()");
        return _this;
    }
    return B;
}(A));
var a1 = new B();
console.log("-----------------------------------------------------------");
var HatatchBack = /** @class */ (function () {
    function HatatchBack() {
    }
    HatatchBack.prototype.accelerate = function () {
        this.speed += 10;
        console.log("Accelator " + this.speed);
    };
    HatatchBack.prototype.brake = function () {
        this.speed -= 10;
        console.log("Brake" + this.speed);
    };
    return HatatchBack;
}());
var h1 = new HatatchBack();
h1.accelerate();
h1.brake();
var m1 = { "company": "Maruti", "model": "Brezza", "price": 1900000, "gear": true };
var m2 = { "company": "BMW", "model": "BRE", "price": 198289 };
console.log(m1);
console.log(m2);
console.log("----------------------------------------------------------------------");
var arr1 = ["Hi", "Hello", "World", "Python", "Java"];
var arr2 = ["Hi", "Hello", "World", "Python", "Java"];
console.log(arr1);
console.log(arr2);
console.log("------------------------------------------------------------------------");
var a = 10;
var b = 20;
console.log("The sum of " + a + " and " + b + " is " + (a + b));
console.log("The sum of ".concat(a, " and ").concat(b, " is ").concat(a + b));
var Person = /** @class */ (function () {
    function Person(name) {
        var _this = this;
        console.log("Person constructor called");
        this.name = name;
        // One solution is to use a getter
        // var self = this;
        // setTimeout(function(){
        //     console.log("Hello " + self.name);
        // }, 2000);
        // using arrow function
        setTimeout(function () {
            console.log("Hello " + _this.name);
        }, 2000);
        console.log("End of constructor");
    }
    return Person;
}());
new Person("Rahul");
console.log("This statement will not wait for anyone");
