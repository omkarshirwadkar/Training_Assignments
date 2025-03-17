import { useState } from "react";
import axios from "axios";

function AddProducts(){
    const [products, setProducts] = useState({"id": "", "name": "", "category": "", "price": "", "stockAvailability": "", "brand": "", "vendorId": ""});
    const [vendors , setVendors] = useState({"id": "",
      "name": "",
      "email": "",
      "phone": "",
      "rating": "",
      "status": "",
      "productIds": [
      ]});
    const assignData = (e) => {
        setProducts({...products, [e.target.name]: e.target.value})
    }
    const insertProduct = (e) => {
        e.preventDefault();
        axios.post( 'http://localhost:4000/products', products)
        .then( res => {
            console.log("Successfully Added Product");
        })
        axios.patch('https:localhost:4000/vendors/'+ products.vendorId, vendors.productIds.push(products.id)).then( res =>{
            console.log("Successfully Added Product to Vendor");
        })
    }
    return (
        <div>
            <h3>
            <input type="text" value={products.id} placeholder="Enter Product ID" name="id" onChange={assignData}/> <br/>
            <input type="text" value={products.name} placeholder="Enter Product Name" name="name" onChange={assignData}/> <br/>
            <input type="text" value={products.category} placeholder="Enter Product Category" name="category" onChange={assignData}/> <br/>
            <input type="text" value={products.price} placeholder="Enter Product Price" name="price" onChange={assignData}/> <br/>
            <input type="text" value={products.stockAvailability} placeholder="Enter Product Stock Availability" name="stockAvailability" onChange={assignData}/> <br/>
            <input type="text" value={products.brand} placeholder="Enter Product Brand" name="brand" onChange={assignData}/> <br/>
            <input type="text" value={products.vendorId} placeholder="Enter Product Vendor ID" name="vendorId" onChange={assignData}/> <br/>
            <br/>
            <button onClick={insertProduct} type='submit'>Submit</button>
            </h3>
        </div>
    );
}

export default AddProducts;