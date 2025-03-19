import {useEffect, useState} from 'react';
import axios from 'axios';
function GetVendors(){
    const [vendors, setVendors] = useState([]);
    useEffect(() =>{
        axios.get('http://localhost:4000/vendors')
        .then(response => {
            setVendors(response.data);
        })
    })
    return(
        <>
            <h2>Vendor Details</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Rating</th>
                    <th>Status</th>
                    <th>Product IDs</th>
                </tr>
                {vendors.map((product) => {
                return (
                    <tr>
                        <td>{product.id}</td>
                        <td>{product.name}</td>
                        <td>{product.email}</td>
                        <td>{product.phone}</td>
                        <td>{product.rating}</td>
                        <td>{product.status}</td>
                        <td>{product.productIds}</td>
                    </tr>
                )
            })}
            </table>
        </>
    )
}

export default GetVendors;