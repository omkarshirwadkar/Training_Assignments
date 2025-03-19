import AddProducts from "./AddProducts";
import AddVendors from "./AddVendors";
import GetProducts from "./GetProducts";
import { Route, Routes } from 'react-router-dom';
import GetVendors from "./GetVendors";


function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<h1>Hari OM</h1>} />
        <Route path="/products" element={
          <>
            <GetProducts/>
            <AddProducts/>
          </>
        }/>
        <Route path="/vendors" element={
          <>
            <GetVendors/>
            <AddVendors/>
          </>
        }/>
      </Routes>
    </div>
  );
}

export default App;
