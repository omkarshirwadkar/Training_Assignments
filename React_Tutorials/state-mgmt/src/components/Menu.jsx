import React from 'react'
import Button from './Button'

function Menu({count}) {
  return (
    <div>
        <h1>Menu option with count: {count}</h1>
        <Button count={count}/>
    </div>
  )
}

export default Menu