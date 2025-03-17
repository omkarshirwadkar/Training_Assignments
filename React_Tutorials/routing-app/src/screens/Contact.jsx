import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'

function Contact() {
  return (
    <div>
      <Header/>
        <h1>Get in touch</h1>
        <p>Phone: 123-456-7890</p>
        <p>Email: [info@website.com](mailto:info@website.com)</p>
        <Footer/>
    </div>
  )
}

export default Contact