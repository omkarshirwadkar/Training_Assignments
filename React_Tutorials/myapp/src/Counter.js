import {useState} from 'react';
function Counter(){
    const [count, setCount] = useState(0);
    function incrCount(){
        setCount(count + 1);
        console.log("Incremented: "+count);
    }
    function decrCount(){
        setCount(count - 1);
        console.log("Decremented: "+count); 
    }
    function setCountToZero(){
        // count = 0;
        setCount(0);
        console.log("Zero: "+count);
        
    }
    return(
        <>
        <h2>State Demo</h2>
        <h3>Counter: {count}</h3>
        <button onClick={incrCount}>Increment</button>
        <button onClick={decrCount}>Decrement</button>
        <button onClick={setCountToZero}>Set Zero</button>
        </>
    )
}
export default Counter;