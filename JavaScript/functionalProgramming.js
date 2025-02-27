var a = 10;
console.log(a);
a = function(){
    console.log("Hello");
}
console.log(a()); // -> Hello and undefined
a();
console.log("------------------------------------");

function abc(){
    console.log("From function abc");
}
function xyz(){
    console.log("From function xyz");
    return abc;
}

function demo(op){
    console.log("Inside demo function");
    op();
}

function demo2(){
    console.log("-------------------------");
    console.log("Inside demo2 function");
    return xyz;
}

demo(abc)
demo(xyz)

// function inside function inside function
// This is called Function Currying
demo2();
demo2()();
demo2()()();