console.log(Math.PI);
console.log(Math.E);
console.log(Math.sqrt(25));
console.log(Math.pow(3, 5));

console.log("-------------------");

var d = new Date();
console.log(d);
d.setMonth(15); // --> Counts from 0 ie., Jan = 0, Feb = 1, etc.
console.log(d);

console.log("-------------------");

var s = new String("Hello, World!");
console.log(s);
console.log(s.toLowerCase());
console.log(s.toUpperCase());

console.log("-------------------");

var n = new Number(123);
console.log(n);

console.log("-------------------");

console.log(new Boolean("false")); // --> true
console.log(new Boolean(0)); // --> false
console.log(new Boolean(null)); // --> false
console.log(new Boolean(false)); // --> false
console.log(new Boolean("")); // --> false
console.log(new Boolean(NaN)); // --> false
console.log(new Boolean()); // --> false
console.log(new Boolean(undefined)); // --> false
console.log(new Boolean(-1)); // --> true