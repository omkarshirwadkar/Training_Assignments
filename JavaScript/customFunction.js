function add(a, b){
    console.log("Addition: " + (a + b))
}
var sum = add;

var sub = function sub(a, b) {
    console.log("Subtraction: " + (a - b))
}

var mul = (a, b) => {
    console.log("Multiplication: " + (a * b))
}

var div = new Function("a", "b", "console.log('Division: ' + (a / b))");

// self invoking function
var selfInvoking = (function(a, b) {
    console.log("Self Invoking: " + (a + b))
    })(10, 20);

console.log(typeof(add));
add(10, 20);
console.log(typeof(sum));
sum(20, 30);
console.log(typeof(sub));
sub(20, 10);
console.log(typeof(mul));
mul(30, 20);
console.log(typeof(div));
div(40, 10);