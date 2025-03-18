import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Home from './Home'

function NetBanking() {
  return (
    <div>
      <Header/>
      <h1>NetBanking</h1>
      <h3>Please Login</h3>
      <form>
        Username: <input type="text" name="username"/> <br />
        Password: <input type="password" name="password"/> <br />
        <br />
        <input type="submit" value="Login"/>
        <input type="reset" value="Reset"/>
      </form>
      <Footer/>
    </div>
  )
}

export default NetBanking