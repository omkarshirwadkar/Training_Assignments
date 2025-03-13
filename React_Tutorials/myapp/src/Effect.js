import { useEffect, useState } from "react";

function Effect(){
    const [a, setA] = useState(0);
    const [b, setB] = useState(0);

    function updateA(){
        setA(a + 1);
    }
    function updateB(){
        setB(b + 1);
    }
    // In comparison with angular , this is like a lifecycle hook
    // If nothing is specified , it will run after every render
    // If [] is passed , it will run only once after the component is mounted
    // If [a] is passed , it will run after every render of a
    useEffect(()=>{
        console.log("Component mounted successfully");
    }, [a]);
    return(
        <>
            <hr/>
            <h2>This is from the Effect Component</h2>
            <h3>A: {a}</h3>
            <h3>B: {b}</h3>
            <button onClick={updateA}>Update A</button>
            <button onClick={updateB}>Update B</button>
        </>
    )
}

export default Effect;