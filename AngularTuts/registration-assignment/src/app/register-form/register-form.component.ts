import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-form',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.css'
})
export class RegisterFormComponent implements OnInit {
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
  getpwd(): string {
    return this.pwd;
  }
  setpwd(pwd: string ): void {
    this.pwd = pwd;
  }
  getcid(): string {
    return this.cid;
  }
  setcid(cid: string ): void {
    this.cid = cid;
  }
  getuname(): string {
    return this.uname;
  }
  setuname( uname: string ): void {
    this.uname = uname;
  }
  customerIDValidator(control: any): any{
    if(control.value.length != 7 || !(/^\d+$/.test(control.value))){
      console.log("ID is not valid");
      return { customerID : true };
    }
    else{
      console.log(control.value);
      this.setcid(control.value);
    }
  }
  usernameValidator(control: any): any{
    let isAlphabetic = /^[A-Za-z]+$/.test(control.value);
    if (!isAlphabetic){
      console.log("Username is not alphabetic");
      return { username : true };
    }
    else{
      console.log(control.value);
      this.setuname(control.value);
    }
  }
  passwordValidator(control: any): any{
    let oneDigit = /\d/.test(control.value);
    let oneLower = /[a-z]/.test(control.value);
    let oneUpper = /[A-Z]/.test(control.value);
    let oneSpecial = /[^a-zA-Z0-9]/.test(control.value);
    if (!oneDigit || !oneLower || !oneUpper || !oneSpecial){
      console.log("password is not valid");
      return { password : true };
    }
    else{
      console.log("Password: "+this.pwd);
      this.setpwd(control.value);
    }
  }
  confirmPassValidator (control: any): any{
    if (control.value != this.getpwd()){
      console.log("Password does not match");
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
    this.registrations.set(this.getcid(), [this.getpwd(), this.getuname()]);
    console.log(this.registrations);
    this.registerFlag = 2;
  }
  xyz(val: any) : void{
    console.log(val);
    this.registerFlag = 3;
  }
}
