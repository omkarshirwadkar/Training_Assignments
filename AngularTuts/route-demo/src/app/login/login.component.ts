import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  msg: string = '';
  constructor(private router: Router){

  }
  abc(event: any) {
    event.preventDefault();
    let uname = event.target.elements[0].value;
    let pass = event.target.elements[1].value;
    if (uname == pass){
      this.router.navigate(['welcome']);
    }
    else{
      this.msg = "Invalid username or password";
    }
  }
}
