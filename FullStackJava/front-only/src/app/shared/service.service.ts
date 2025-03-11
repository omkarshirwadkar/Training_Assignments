import { Injectable } from '@angular/core';
import { Employee } from './employee.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  selectedEmployee: Employee = {
    eid : 0,
    name : '',
    age : 0,
    salary : 0,
    designation: ''
  };
  employees?: Employee[];
  constructor(private http: HttpClient) { }

  postEmployee(emp: Employee) {
    return this.http.post('http://localhost:8090/employees', emp);
  }
  getAllEmployees(){
    return this.http.get('http://localhost:8090/employees');
  }
  putEmployee(emp: Employee) {
    return this.http.put('http://localhost:8090/employees', emp);
  }
  deleteEmployee(id: number) {
    return this.http.delete('http://localhost:8090/employees/' + id);
  }
}
