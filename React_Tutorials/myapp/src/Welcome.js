import { useRef, useState } from "react";

function Welcome(){
    const [name, setName] = useState("Guest");
    const refElement = useRef("");

    function clearField(){
        setName("");
        refElement.current.focus();
        refElement.current.style.color = "brown"
    }
    return(
        <>
            <hr></hr>
            <h2>Welcome {name}</h2>
            <h3>
                <input ref={refElement} type="text" value={name} onChange={(e)=>setName(e.target.value)
                }></input>
                <input type="button" value="Clear" onClick={clearField}/>
            </h3>
        </>
    )
}

export default Welcome;