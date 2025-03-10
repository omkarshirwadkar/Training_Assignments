import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RoleService } from '../services/role.service';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  msg: string = '';
  constructor(private router: Router, private rs: RoleService){

  }
  abc(event: any) {
    event.preventDefault();
    let uname = event.target.elements[0].value;
    let pass = event.target.elements[1].value;
    let role = event.target.elements[2].value;
    console.log(role);
    this.rs.role = role;
    
    if (uname == pass){
      this.msg = "You are not authorized to access this page";
      this.router.navigate(['welcome']);
    }
    else{
      this.msg = "Invalid username or password";
      this.router.navigate(['netbanking']);
    }
  }
}
