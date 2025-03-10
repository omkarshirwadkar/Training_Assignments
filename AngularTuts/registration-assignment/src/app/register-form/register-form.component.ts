import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})
export class RegisterFormComponent {
  registerFlag: number = 1;
  registrations: Map <any, any[]> = new Map();
  registerForm: any;
  loginForm: any;
  cid: string = "";
  pwd: string = "";
  uname: string = "";
  loginPass: any;
  ngOnInit(){
    this.registerForm = new FormGroup({
      customerID: new FormControl("", this.customerIDValidator),
      username: new FormControl("", Validators.compose([
        Validators.required,
        Validators.minLength(5),
        this.usernameValidator
      ])),
      password: new FormControl("", Validators.compose([
        Validators.required,
        Validators.minLength(8),
        this.passwordValidator
      ])),
      confirmPass: new FormControl("",Validators.compose([
        Validators.required,
        this.confirmPassValidator
      ])),
      accountNo: new FormControl("", Validators.compose([
        Validators.required,
        Validators.minLength(6)
      ]))
    })
    this.loginForm = new FormGroup({
      customerLoginID: new FormControl("", this.loginCID),
      customerLoginPassword: new FormControl("", this.loginPassword)
    })
  }
  customerIDValidator(control: any): any{
    if(control.value.length != 7 ){
      return { customerID : true };
    }
    else if (!(/^\d+$/.test(control.value))){
      return { customerID : true };
    }
    else{
      this.cid = control.value;
    }
  }
  usernameValidator(control: any): any{
    let isAlphabetic = /^[A-Za-z]+$/.test(control.value);
    if (!isAlphabetic){
      return { username : true };
    }
    else{
      this.uname = control.value;
    }
  }
  passwordValidator(control: any): any{
    let oneDigit = /\d/.test(control.value);
    let oneLower = /[a-z]/.test(control.value);
    let oneUpper = /[A-Z]/.test(control.value);
    let oneSpecial = /[^a-zA-Z0-9]/.test(control.value);
    if (!oneDigit || !oneLower || !oneUpper || !oneSpecial){
      return { password : true };
    }
    else{
      this.pwd = control.value;
    }
  }
  confirmPassValidator (control: any): any{
    if (control.value != this.pwd){
      return { confirmPass : true };
    }
  }
  loginCID(control: any): any{
    if (!this.registrations.has(control.value)) {
      return {customerLoginID: true};
    }
    else{
      if (control.value in this.registrations){
        this.loginPass = this.registrations.get(control.value);
        console.log(this.loginPass);
        
      }
    }
  }
  loginPassword (control: any): any{
    if (control.value !== this.loginPass) {
      return {customerLoginPassword: true};
    }
  }

  abc(val: any){
    console.log(val);
    this.registrations.set(this.cid, [this.pwd, this.uname]);
    this.registerFlag = 2;
  }
  xyz(val: any) : void{
    console.log(val);
    this.registerFlag = 3;
  }
}
