import useCounter from "./useCounter";

function FirstComp(){
    const [cnt, incr, decr] = useCounter();
    return (
        <>
            <h2>First Component</h2>
            <p>Count: {cnt}</p>
            <button onClick={incr}>INCREMENT</button>
            <button onClick={decr}>DECREMENT</button>
        </>
    )
}

export default FirstComp;