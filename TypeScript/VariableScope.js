// here there is no error if let or var is used
a; // global variables are only created when it is initialized with some value
function abc(){
    {
        a = 10;
        var b = 20;
        let c = 30;
        console.log("Inner Block - c: " + c);
    }
    console.log("From inside abc() - a: " + a);
    console.log("From inside abc() - b: " + b);
    // console.log("From inside abc() - c: " + c); // cannot access c as it has let scope 
}

console.log("From outside abc(): - a: " + a);
// console.log("From outside abc(): - b: " + b); // Gives an error
// console.log("From outside abc(): - c: " + c); // Gives an error
abc();