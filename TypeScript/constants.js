var Emp = /** @class */ (function () {
    function Emp(name, age) {
        this.company = "Wissen";
        this.name = name;
        this.age = age;
    }
    Emp.prototype.display = function () {
        console.log("Name: ".concat(this.name, ", Age: ").concat(this.age, ", Company: ").concat(this.company));
    };
    return Emp;
}());
var e1 = new Emp("John", 30);
e1.display();
e1.company = "Google";
e1.display();
