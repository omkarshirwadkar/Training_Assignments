import { addition } from "./testingFunction"

describe("Calculation testing", () => {
    it('Testing Add Function', () => {
        expect(addition(11,22)).toBe(33)
    })
})

describe(`String Testing`, () => {
    let i = 0;
    beforeEach (() => {
        console.log("Before Each: "+ ++i);
    })
    afterEach( () => {
        console.log("After Each"+ i);
    })
    beforeAll (() => {
        console.log("---------Started-------------");
    })
    afterAll(() => {
        console.log("---------Ended--------------");
        
    })
    it(`Testing String Equality "toBe()"`, () => {
        expect("Hello").toBe("Hello")
    })
    it(`Testing String Equality "toEqual()"`, () => {
        let str = "Hello";
        expect(str).toEqual("Hello")
    })
    it(`Testing with Regex pattern`, () => {
        let str = "7 Samurais";
        expect(str).toMatch( /\d+/);
    })
})

describe(`Testing JSON object`, () => {
    it(`Testing with deep checking`, () => {
        let obj = { name: "John", "age": 30 };
        expect(obj).toEqual({ name: "John", "age": 30 });
    });
    it(`Testing Array`, () => {
        let arr = [1,2,3];
        expect(arr).toEqual([1,2,3]);
    })
})