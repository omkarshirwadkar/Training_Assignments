import { useState } from 'react'
import './App.css'
import Menu from './components/Menu'
import { countCtx } from './state/context'
import CompB from './components/CompB'

function App() {
  const [count , setCount] = useState(9)
  return (
    <>
      <countCtx.Provider value={{count, setCount}}>
        <Menu count={count}/>
      </countCtx.Provider>
    </>

  )
}

export default App
