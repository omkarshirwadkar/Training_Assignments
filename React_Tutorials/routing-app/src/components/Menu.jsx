import React from 'react'
import { Link } from 'react-router-dom'

function Menu() {
  return (
    <div>
        <Link to="/">Home</Link> | 
        <Link to="/about">About</Link> |
        <Link to="/contact">Contact</Link> |
        <Link to="/login">NetBanking</Link> |
        <Link to="/services">Services</Link> 
    </div>
  )
}

export default Menu