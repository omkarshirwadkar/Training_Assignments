var a = 10;
console.log(typeof(a));
console.log(isNaN(a));
var b = "10.2134"
console.log(parseInt(b) + 5);
console.log(parseFloat(b) + 5);
var c = "3 + 5 - 8 * 2";
console.log(eval(c));
var d = "3411.531abc"
console.log(parseInt(d) + 5);
console.log(parseFloat(d) + 5);

var i = 1
function abc(){
    console.log("Hello: " + i++);
}
function stop(){
    clearInterval(ref)
}
var ref = setInterval(abc, 1000);
setTimeout(stop, 8000);
console.log("I can't wait for other functions to finish");
