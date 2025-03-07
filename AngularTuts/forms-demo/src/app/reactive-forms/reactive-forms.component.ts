import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-forms',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './reactive-forms.component.html',
  styleUrl: './reactive-forms.component.css'
})
export class ReactiveFormsComponent {
  employeeForm: any;

  ngOnInit(){
    this.employeeForm = new FormGroup({
      user: new FormControl("Guest", this.userValidator),
      age: new FormControl("", Validators.compose([
        Validators.required,
        Validators.min(18),
        Validators.max(60)
      ])),
      salary: new FormControl(21000),
      designation: new FormControl("Contract")
    })
  }
  userValidator(control: any): any{
    if(control.value.length < 5){
      return {user: true};
    }
  }
  abc(val: any){
    console.log(val);
  }
}
