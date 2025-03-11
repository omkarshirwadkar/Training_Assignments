import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ServiceService } from '../shared/service.service';
import { Employee } from '../shared/employee.model';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [ServiceService]
})
export class EmployeeComponent implements OnInit {
  update: boolean = false;
  constructor(public es: ServiceService){

  }
  ngOnInit(){
    this.resetForm();
  }
  onSubmit(form: NgForm){
    console.log(form.value);
    if (!this.update){
      this.es.postEmployee(form.value).subscribe (res => {
      this.resetForm(form);
      console.log("Employee Added");
      })
    }
    else{
      this.es.putEmployee(form.value).subscribe(res =>{
        this.resetForm(form);
        console.log("Employee Updated");
        this.update = false;
      })
    }
  }
  resetForm(form?: NgForm){
    if(form) {
      form.reset();
    }
    this.es.selectedEmployee = {
      eid: 0,
      name: '',
      age: 0,
      salary: 0,
      designation: ''
    };
    this.refreshEmployees();
  }
  refreshEmployees(){
    this.es.getAllEmployees().subscribe (res => {
      this.es.employees = res as Employee[]
    })
  }
  updateEmp(emp: Employee){
    this.es.selectedEmployee = emp;
    this.update = true;
  }
  deleteEmp(id : number | undefined){
    if(id) {
    if(confirm( 'Are you sure to delete this employee ?')){
      this.es.deleteEmployee(id).subscribe(res => {
        this.resetForm();
        console.log("Employee Deleted");
      })
    }
  }
  }
}
