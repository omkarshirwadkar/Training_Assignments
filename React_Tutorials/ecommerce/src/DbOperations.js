import { useEffect, useState } from "react";
import GetProducts from "./GetProducts";
import axios from "axios";

function DbOperations(){
    const [products, setProducts] = useState([]);
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
                        <td><button onClick={GetProducts.updateProduct}>Update</button></td>
                        <td><button onClick={GetProducts.removeProduct}>Delete</button></td>
                    </tr>
                )
            })}
        </table>

        </>
    )
}

export default DbOperations;