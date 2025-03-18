import React, { useContext } from 'react'
import CompA from './CompA'
import { countCtx } from '../state/context'
import CompB from './CompB'

function Button({count}) {
    const obj = useContext(countCtx)
    function incr(){
        obj.setCount(obj.count + 1 );
    }
    function decr(){
        obj.setCount(obj.count - 1 );
    }
  return (
    <>
        <h2>Clickable Button: {count}</h2>
        <button onClick={ incr}>Increment</button> <br />
        <button onClick={decr}>Decrement</button> <br />
        <CompA count={count}/>
        <CompB/>
    </>
  )
}

export default Button