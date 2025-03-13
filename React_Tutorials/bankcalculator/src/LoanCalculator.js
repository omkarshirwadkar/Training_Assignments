import { useState } from "react";

function LoanCalculator(){
    const [applicant, setApplicant] = useState("");
    const [interest, setInterest] = useState("");
    const [tenure, setTenure] = useState("");
    const [amount, setAmount] = useState("");
    const [emi, setEmi] = useState("");
    const [type, setType] = useState("");
    if (type == "HOME"){
        setInterest("9%");
        console.log(interest);
        
    }
    else if (type == "CAR"){
        setInterest("11%");
        console.log(interest);
    }
    else if (type == "PERSONAL"){
        setInterest("15%");
        console.log(interest);
    }
    else{
        setInterest("");
        console.log("SADADSA");
        
    }
    function calculateEMI(){

    }
    return(
        <>
                <h1>Loan Calculator</h1>
                Applicant: <input onChange={(e) =>{
                    setApplicant(e.target.value);
                }}/><br/>
                Type: 
                <select onChange={(e) =>{
                    setType(e.target.value);
                    if (e.target.value == "HOME"){
                        setInterest("9%");
                    }
                    else if (e.target.value == "CAR"){
                        setInterest("11%");
                    }
                    else if (e.target.value == "PERSONAL"){
                        setInterest("15%");
                    }
                }}>
                    <option value="HOME">Home</option>
                    <option value="CAR">Car</option>
                    <option value="PERSONAL">Personal</option>
                </select><br/>
                Interest: <input readOnly value={interest}/><br/>
                Tenure: <input/><br/>
                Amount: <input /><br/>
                EMI: <input readOnly value={emi}/><br/><br/>
                <button>CALCULATE</button>
        </>
    )
}

export default LoanCalculator;