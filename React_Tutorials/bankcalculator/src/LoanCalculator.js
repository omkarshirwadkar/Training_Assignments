function LoanCalculator(){
    return(
        <>
                <h1>Loan Calculator</h1>
                Applicant: <input /><br/>
                Type: 
                <select>
                    <option value="HOME">Home</option>
                    <option value="CAR">Car</option>
                    <option value="PERSONAL">Personal</option>
                </select><br/>
                Interest: <input readonly/><br/>
                Tenure: <input/><br/>
                Amount: <input /><br/>
                EMI: <input readonly/><br/><br/>
                <button>CALCULATE</button>
        </>
    )
}

export default LoanCalculator;