import './App.css'
import {Route, Routes} from 'react-router-dom'
import Home from './screens/Home'
import AboutUs from './screens/AboutUs'
import ContactUs from './screens/ContactUs'
import NetBanking from './screens/NetBanking'
import Login from './screens/Login'
import Register from './screens/Register'
import Services from './screens/Services'

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/about" element={<AboutUs />} />
        <Route path="/contact" element={<ContactUs />} />
        <Route path="/netbanking" element={<NetBanking />} />
        <Route path="/services" element={<Services />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </>
  )
}

export default App
