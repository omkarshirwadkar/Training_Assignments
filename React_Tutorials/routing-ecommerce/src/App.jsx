import { Routes, Route } from "react-router-dom"
import Products from "./screens/Products"
import Vendors from "./screens/Vendors"
import Orders from "./screens/Orders"
import Inventory from "./screens/Inventory"
import Navbar from "./components/navbar"

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Navbar />} />
        <Route path="/products" element={<Products/>} />
        <Route path="/vendors" element={<Vendors/>} />
        <Route path="/orders" element={<Orders/>} />
        <Route path="/inventory" element={<Inventory/>} />
      </Routes>
    </>
  )
}


export default App
