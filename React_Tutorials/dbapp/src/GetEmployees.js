import {useEffect, useState} from 'react';
import axios from 'axios';
function GetEmployees(){
    const [employees, setEmployees] = useState([]);
    useEffect(() =>{
        axios.get('http://localhost:4000/employees')
        .then(response => {
            setEmployees(response.data);
            console.log(response.data);
        })
    }, [])
    return(
        <>
            <h2>Employee Details</h2>
            <table>
                <tr>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Designation</th>
                </tr>
            {
                employees.map((employee) => {
                    return(
                        <tr>
                            <td>{employee.id}</td>
                            <td>{employee.name}</td>
                            <td>{employee.age}</td>
                            <td>{employee.salary}</td>
                            <td>{employee.designation}</td>
                        </tr>
                    )
                })
            }
            </table>
            
        </>
    )
}

export default GetEmployees;