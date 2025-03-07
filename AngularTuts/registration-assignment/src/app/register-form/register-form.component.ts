import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})
export class RegisterFormComponent {
  registerFlag: boolean = true;
  registerForm: any;
  ngOnInit(){
    this.registerForm = new FormGroup({
      customerID: new FormControl("", this.customerIDValidator),
      username: new FormControl("", this.usernameValidator),
      password: new FormControl(),
      confirmPassword: new FormControl(),
      accountNo: new FormControl()
    })
  }
  isDigit(val: string): boolean {
    let regex = /^\d+$/;
    return regex.test(val);
  }
  customerIDValidator(control: any): any{
    if(control.value.length != 7 ){
      return { customerID : true };
    }
    if(!this.isDigit(control.value)){
      return { customerID : true };
    }
  }
  usernameValidator(control: any): any{

  }
  abc(val: any){
    console.log(val);
  }
}
