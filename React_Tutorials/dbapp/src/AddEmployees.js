import axios from 'axios'
import React, { useState } from 'react'

function AddEmployees() {
    const [emp, setEmp] = useState({"id": "", "name": "", "age": "", "salary": "", "designation": ""})
    const assignData = (e) => {
        setEmp({...emp, [e.target.name]: e.target.value})
    }
    const insertEmp = (e) => {
        e.preventDefault();
        console.log( emp );
        
        axios.post( 'http://localhost:4000/employees', emp )
        .then( res => {
            console.log("Successfully Added");
        })
    }
    const updateEmp = (e) => {
        e.preventDefault();
        console.log( emp );
        
        axios.put( 'http://localhost:4000/employees/' + emp.id, emp )
        .then( res => {
            console.log("Successfully Updated");
        })
    }
    const removeEmp = (e) => {
        e.preventDefault();
        console.log( emp );
        axios.delete( 'http://localhost:4000/employees/' + emp.id, emp )
        .then( res => {
        })
    }
    return (
        <div>
            <h3>Please Enter Employee Details</h3>
            <input type="text" value={emp.id} placeholder="Enter Employee ID" name="id" onChange={assignData}/> <br/>
            <input type="text" value={emp.name} placeholder="Enter Employee Name" name="name" onChange={assignData}/> <br/>
            <input type="text" value={emp.age} placeholder="Enter Employee Age" name="age" onChange={assignData}/> <br/>
            <input type="text" value={emp.salary} placeholder="Enter Employee Salary" name="salary" onChange={assignData}/> <br/>
            <input type="text" value={emp.designation} placeholder="Enter Employee Designation" name="designation" onChange={assignData}/> <br/>
            <br/>
            <button onClick={insertEmp} type='submit'>Submit</button>
            <button onClick={updateEmp} type='button'>Update</button>
            <button onClick={removeEmp} type='button'>Delete</button>
        </div>
    )
}

export default AddEmployees