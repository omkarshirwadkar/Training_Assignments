
//Internally
// var add = function (a, b){ console.log(a + b)};
function add(a, b) {
    console.log(a + b);
}
add(10, 20) // --> prints NaN
// Internally
// var add = function (a, b, c){ console.log(a + b + c)};
function add(a, b, c) {
    console.log(a + b + c);
}

// As we can see var add is reassigned to a new function
// Therefore add(10, 20) will not be executed as it is referring to the old function
add(10, 20) // No Answer we get NaN as add(a, b, c) is the latest function in the scope chain
add(10, 20, 30) // --> works and the output is 30 for add(a,b)

function add(...a){ // --> Rest parameter: passing 
    var sum = 0;
    for (var i = 0; i < a.length; i++) {
        sum += a[i];
    }
    console.log("Result: " + sum);
}

add(10, 20);
add(20, 30, 40);
add(10, 20, 30, 40, 50);
add();
add(10);

console.log("---------------------------");

var emp = ["Rajesh", 21, 40000, "Tester"]

function display(name, age, salary, designation) {
    console.log("Name: " + name);
    console.log("Age: " + age);
    console.log("Salary: " + salary);
    console.log("Designation: " + designation);
}

display(...emp) // Spread Operator 