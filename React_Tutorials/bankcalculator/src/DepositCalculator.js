import { useState } from "react";

function DepositCalculator(){
    const [principal , setPrincipal] = useState(0);
    return(
        <>
        <div>
            <h1>Deposit Calculator</h1>
            Principal: <input type="number" value={principal} onChange={(e) => {
                setPrincipal(e.target.valueAsNumber);
            }}/><br/>
            Tenure: <input/><br/>
            Interest Rate: <input readonly value={"7%"}/><br/>
            Maturity: <input/><br/><br/>
            <button> Calculate</button>
        </div>
        </>
    );
}

export default DepositCalculator;   