let s1 = "Wissen"
let s2 = "Technology"

var promise = new Promise((resolve, reject) => {
    if ((s1 + s2) === "WissenTechnology") {
        resolve("Employee Object");
    }
    else {
        reject();
    }
});

promise.then(
    () => console.log("Best Place to Work"),
).catch(
    () => console.log("Some Spelling Mistake")
);

promise.then(
    () => console.log("Best Place to Work"),
    () => console.log("Some Spelling Mistake")
);

// .catch() is used to handle the error in the promise
promise
.then(
    (val) => {
        console.log("Best Place to Work");
        console.log("Got: ", val);
        setTimeout (() => {
            console.log("Timeout");
        } , 3000);
        return val;
    },
    () => {
        console.log("Some Spelling Mistake");
        throw new Error("This is to test the catch()");
    }
)
.then(
    (val) => {
        console.log("Best Place to Work");
        console.log("Got: ", val);
    },
    () => {
        console.log("Some Spelling Mistake");
        throw new Error("This is to test the catch()");
    }
).catch(
    (error) => console.log("Error: ", error.message)
).finally(
    () => console.log("Finally executed")
);
console.log("Main Exit");