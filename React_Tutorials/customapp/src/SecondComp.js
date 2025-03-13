import useCounter from "./useCounter";

function SecondComp(){
    const [cnt, incr, decr] = useCounter(20);
    return (
        <>
            <h2>Second Component</h2>
            <p>Count: {cnt}</p>
            <button onClick={incr}>INCREMENT</button>
            <button onClick={decr}>DECREMENT</button>
        </>
    )
}

export default SecondComp;