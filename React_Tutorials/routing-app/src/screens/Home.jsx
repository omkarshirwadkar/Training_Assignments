import React from 'react'
import Header from '../components/Header'
import Footer from '../components/Footer'
import Title from '../components/Title'
import { useNavigate } from 'react-router-dom';

function Home() {
  flag = true;
  const navigate = useNavigate();
  function goTo(){
    if (flag){
      navigate('/login')
    }
    else{
      navigate('/about')
    }
  }
  return (
    <>
        <Header />
        <Title msg=" Welcome to my website" />
        <button onClick={goTo}>Click me</button>
        <Footer />
    </>
  )
}

export default Home