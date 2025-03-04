let emp = {'name': 'John', 'age': 30, 'salary': 30000};
let emp2 = {'name': 'John', 'age': 30, 'salary': 30000, 'designation': 'Manager'};
let emp3 = ["John", 30, 30000];

let {name, age, salary, designation = "Tester"} = emp; // The names should match the keys in the object
let [n, a, s, d="Tester"] = emp3; // The names should match the array elements
console.log(name, age, salary, designation);
console.log(n, a, s, d);


let arr1 = [1, 2, 3, 4, 5];
let arr2 = [6, 7, 8, 9, 10];
let arr3 = [11, 12, 13, 14, 15];
let arrf = [...arr1, ...arr2, arr3];
let arr = [arr1, arr2, arr3];
console.log(arr);
console.log(arrf);