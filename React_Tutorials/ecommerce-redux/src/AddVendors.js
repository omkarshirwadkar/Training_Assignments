import axios from 'axios'
import React, { useState } from 'react'

function AddVendors() {
    const [prod, setProd] = useState({
        "id": "",
        "name": "",
        "email": "",
        "phone": "",
        "rating": "",
        "status": "",
        "productIds": ""
    })
    const assignData = (e) => {
        setProd({...prod, [e.target.name]: e.target.value})
    }
    const insertProd = (e) => {
        e.preventDefault();
        console.log( prod );
        axios.post( 'http://localhost:4000/products', prod )
        .then( res => {
            console.log("Successfully Added");
            axios.get('http://localhost:4000/vendors/' + prod.vendorId)
            .then(res => {
                let prodId = res.data.productIds
                prodId.push(prod.id);
                axios.patch('http://localhost:4000/vendors/' + prod.vendorId, {productIds : prodId})
                .then(res => {
                    console.log("Vendor Updated");
                })
            })
        })
    }
    const updateProd = (e) => {
        e.preventDefault();
        console.log( prod );
        
        axios.put( 'http://localhost:4000/products/' + prod.id, prod )
        .then( res => {
            console.log("Successfully Updated");
        })
    }
    const removeProd = (e) => {
        e.preventDefault();
        axios.get('http://localhost:4000/products/' + prod.id)
        .then(res => {
            axios.get('http://localhost:4000/vendors/' + res.data.vendorId)
            .then(resv => {
                let prodId = resv.data.productIds
                prodId = prodId.filter(id => id != prod.id);
                axios.patch('http://localhost:4000/vendors/' + prod.vendorId, {productIds : prodId})
                .then( resp =>{
                    console.log("Vendor Updated");
                })
            })
        })
        axios.delete('http://localhost:4000/products/' + prod.id)
        .then(res => {
            console.log("Product Deleted");
        })
    }
    return (
        <div>
            <h3>
                Product ID: <input type="text" value={prod.id} placeholder="Enter Product ID" name="id" onChange={assignData}/> <br/>
                Name: <input type="text" value={prod.name} placeholder="Enter Product Name" name="name" onChange={assignData}/> <br/>
                Category: <input type="text" value={prod.category} placeholder="Enter Product Category" name="category" onChange={assignData}/> <br/>
                Price: <input type="text" value={prod.price} placeholder="Enter Product Price" name="price" onChange={assignData}/> <br/>
                Stock Availability: <input type="text" value={prod.stockAvailability} placeholder="Enter Product Stock Availability" name="stockAvailability" onChange={assignData}/> <br/>
                Brand: <input type="text" value={prod.brand} placeholder="Enter Product Brand" name="brand" onChange={assignData}/> <br/>
                Vendor Id:  <input type="text" value={prod.vendorId} placeholder="Enter Product Vendor ID" name="vendorId" onChange={assignData}/> <br/>
                <br/>
                <button onClick={insertProd} type='submit'>Submit</button>
                <button onClick={updateProd} type='button'>Update</button>
                <button onClick={removeProd} type='button'>Delete</button>
            </h3>
        </div>
    )
}

export default AddVendors