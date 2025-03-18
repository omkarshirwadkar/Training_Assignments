import { useEffect, useState } from "react";
import GetProducts from "./GetProducts";
import axios from "axios";
import AddProducts from "./AddProducts";

function DbOperations(props){
    const [products, setProducts] = useState([]);

    function updateProduct(e) {
        e.preventDefault();
        axios.put( `http://localhost:4000/products/${products.id}`, products )
        .then( res => {
            console.log("Successfully Updated");
        })
    }
    function removeProduct(id) {
        axios.delete( `http://localhost:4000/products/${id}`)
        .then( res => {
            console.log("Successfully Deleted");
        })
    }
    const printdata = () => {
        console.log("Data Printed");
        
    }
    useEffect(() =>{
        axios.get('http://localhost:4000/products')
        .then(response => {
            setProducts(response.data);
        })
    });
    return(
        <>
            <h2>Product Details</h2>
        <table>
            {/* <thead> */}
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
            {/* </thead> */}
            {/* <tbody> */}
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
            {/* </tbody> */}
        </table>

        </>
    )
}

export default DbOperations;