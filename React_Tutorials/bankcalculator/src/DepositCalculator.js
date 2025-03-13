import { useState } from "react";

function DepositCalculator(){
    const [principal , setPrincipal] = useState("");
    const [tenure, setTenure] = useState("");
    const [maturity, setMaturity] = useState("");

    function calculateMaturity(){
        console.log(principal);
        if (!principal){
            alert("Please enter the principal amount");
        }
        else if (!tenure){
            alert("Please enter the tenure");
        }
        else{
            const interest = 7;
            const maturity = principal * Math.pow((1 + interest/100), tenure);
            setMaturity(maturity);
        }
    }
    return(
        <>
        <div>
            <h1>Deposit Calculator</h1>
            Principal: <input type="number" onChange={(e) => {
                if (e.target.value === ""){
                    setPrincipal("");
                }
                else{
                    setPrincipal(e.target.valueAsNumber);
                }
            }}/><br/>
            Tenure: <input type="number" onChange={(e) =>{
                if (e.target.valueAsNumber > 0 && e.target.valueAsNumber <= 30) {
                    setTenure(e.target.valueAsNumber);
                }
                else{
                    alert("Please enter a valid tenure");
                }
            }}/><br/>
            Interest Rate: <input readonly value={"7%"}/><br/>
            Maturity: <input readOnly value={maturity}/><br/><br/>
            <button onClick={calculateMaturity}>Calculate</button>
        </div>
        </>
    );
}

export default DepositCalculator;   