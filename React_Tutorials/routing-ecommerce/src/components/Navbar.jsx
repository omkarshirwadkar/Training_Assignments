import { Link } from "react-router-dom"

function Navbar() {
  return (
    <div>
        <Link to="/products">Products</Link> | 
        <Link to="/vendors">Vendors</Link> |
        <Link to="/inventory">Inventory</Link> | 
        <Link to="/orders">Orders</Link>
    </div>
  )
}

export default Navbar