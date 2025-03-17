import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './screens/Home';
import About from './screens/About';
import Contact from './screens/Contact';
import NetBanking from './screens/NetBanking';
import Services from './screens/Services';
import { Welcome } from './screens/Welcome';
function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/vite" element={<h1>This Project is created using Vite</h1>} />
        <Route path="/demo" element={<h1>Just for Demo</h1>} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
        <Route path="/login" element={<NetBanking />} />
        <Route path="/services" element={<Services />} />
        <Route path="welcome" element={<Welcome/>}/>
      </Routes>
    </>
  )
}

export default App;
