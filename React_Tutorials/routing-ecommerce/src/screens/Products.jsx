import React, { useEffect, useState } from 'react'
import Navbar from '../components/navbar'
import axios from 'axios'

function Products() {
  const [products, setProducts] = useState([]);
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
  const getVendorById = (id, prod_id) => {
    axios.get('http://localhost:4000/vendors/'+id)
    .then(response => {
      setVendors(response.data)
      var prod_list = vendors.productIds
      prod_list = prod_list.filter(item => item !== prod_id)
      vendors.productIds = prod_list
      axios.patch(`http://localhost:4000/vendors/${id}`, vendors)
      .then(res2 => {
        console.log("Successfully Removed Product from Vendor", res2)
        // console.log(res2.data);
        
      })
    })
  }
  const insertProduct = (e) => {
    e.preventDefault();
    axios.post( 'http://localhost:4000/products', products)
    .then( res => {
        console.log("Successfully Added Product");
    })
  }
  function updateProduct(e) {
    e.preventDefault();
    axios.put( `http://localhost:4000/products/${products.id}`, products )
    .then( res => {
        console.log("Successfully Updated");
    })
}
function removeProduct(id) {
    // axios.delete( `http://localhost:4000/products/${id}`)
    // .then( res => {
    //     console.log("Successfully Deleted");
    // })
    axios.get(`http://localhost:4000/products/${id}`)
    .then(res => {
      const vid = res.data.vendorId
      getVendorById(vid, id);
      console.log(vid, "vis");
      console.log(vendors, "Vendors");
      // console.log(vendors.fi, "csnnvcjnkdncz");
      console.log(vendors.productIds.filter(item => item != id));
    })
}
  useEffect (() => {
    axios.get('http://localhost:4000/products')
    .then(res => {
      setProducts(res.data);
      })
    })
  return (
    <>
      <Navbar/>
      <h2>Welcome to the products page</h2>
      <h3>Enter Products Detail</h3>
      <h3>
          Product ID: <input type="text" value={products.id} placeholder="Enter Product ID" name="id" onChange={assignData}/> <br/>
          Name: <input type="text" value={products.name} placeholder="Enter Product Name" name="name" onChange={assignData}/> <br/>
          Category: <input type="text" value={products.category} placeholder="Enter Product Category" name="category" onChange={assignData}/> <br/>
          Price: <input type="text" value={products.price} placeholder="Enter Product Price" name="price" onChange={assignData}/> <br/>
          Stock Availability: <input type="text" value={products.stockAvailability} placeholder="Enter Product Stock Availability" name="stockAvailability" onChange={assignData}/> <br/>
          Brand: <input type="text" value={products.brand} placeholder="Enter Product Brand" name="brand" onChange={assignData}/> <br/>
          Vendor Id:  <input type="text" value={products.vendorId} placeholder="Enter Product Vendor ID" name="vendorId" onChange={assignData}/> <br/>
          <br/>
          <button onClick={insertProduct} type='submit'>Submit</button>
        </h3>
        <h2>Product Details</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th>Stock Availability</th>
                <th>Brand</th>
                <th>Vendor ID</th>
                <th></th>
                <th></th>
            </tr>
            {products.map((product) => {
                return (
                    <tr>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.category}</td>
                        <td>{product.price}</td>
                        <td>{product.stockAvailability? 'Available' : 'Not Available'}</td>
                        <td>{product.brand}</td>
                        <td>{product.vendorId}</td>
                        <td><button onClick={updateProduct}>Update</button></td>
                        <td><button onClick={()=>{
                            console.log("Called removed");
                            
                            removeProduct(product.id);
                        }}>Delete</button></td>
                    </tr>
                )
            })}
        </table>
    </>
  )
}

export default Products