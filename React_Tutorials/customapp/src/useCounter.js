import { useState } from "react";
// can also pass a default value to useState
function useCounter(val = 0) {
    const [count, setCount] = useState(val);
    function increment(){
        setCount(count + 1);
    }
    function decrement(){
        setCount(count - 1);
    }
    return [count, increment, decrement];
}

export default useCounter;