import { Calculator } from "./calculator";

describe(`Class Calculator Testing`, () => {
    let calculator: Calculator;
    beforeEach(() => {
        calculator = new Calculator();
    })
    it(`Addition Testing`, () => {
        // Arrange
        // const calculator = new Calculator();
        // Act
        const result = calculator.add(5, 5);
        // Assert
        expect(result).toBe(10);
    });
    it(`Subtraction Testing`, () => {
        // Arrange
        // const calculator = new Calculator();
        // Act
        const result = calculator.sub(15, 5);
        // Assert
        expect(result).toBe(10);
    });
    it(`Multiplication Testing`, () => {
        // Arrange
        // const calculator = new Calculator();
        // Act
        const result = calculator.mul(2, 5);
        // Assert
        expect(result).toBe(10);
    });
})