import React, { useEffect, useState } from 'react'
import axios from 'axios';
function GetProducts() {
    const [products, setProducts] = useState({"id": "", "name": "", "category": "", "price": "", "stockAvailability": "", "brand": "", "vendorId": ""});
    // const [products, setProducts] = useState([]);
    const assignData = (e) => {
        setProducts({...products, [e.target.name]: e.target.value})
    }
    const insertProduct = (e) => {
        e.preventDefault();
        console.log( products );
        
        axios.post( 'http://localhost:4000/products', products )
        .then( res => {
            console.log("Successfully Added");
        })
    };
    const updateProduct = (e) => {
        e.preventDefault();
        console.log( products );
        
        axios.put( 'http://localhost:4000/products/' + products.id, products )
        .then( res => {
            console.log("Successfully Updated");
        })
    }
    const removeProduct = ( e ) => {
        e.preventDefault();
        axios.delete(`http://localhost:4000/products/${e.id}`)
        .then(response => {
            console.log("Product deleted");
        })
    }
  return (
    <>
        <div>
            <input type="text" value={products.id} placeholder="Enter Product ID" name="id" onChange={assignData}/> <br/>
            <input type="text" value={products.name} placeholder="Enter Product Name" name="name" onChange={assignData}/> <br/>
            <input type="text" value={products.category} placeholder="Enter Product Category" name="category" onChange={assignData}/> <br/>
            <input type="text" value={products.price} placeholder="Enter Product Price" name="price" onChange={assignData}/> <br/>
            <input type="text" value={products.stockAvailability} placeholder="Enter Product Stock Availability" name="stockAvailability" onChange={assignData}/> <br/>
            <input type="text" value={products.brand} placeholder="Enter Product Brand" name="brand" onChange={assignData}/> <br/>
            <input type="text" value={products.vendorId} placeholder="Enter Product Vendor ID" name="vendorId" onChange={assignData}/> <br/>
            <br/>
            <button onClick={insertProduct} type='submit'>Submit</button>
        </div>
    </>
  )
}

export default GetProducts;