import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  login = {
  email: '',
  password: ''
};

submitLogin() {
  console.log('Logging in:', this.login);
  // Add actual login logic or HTTP request here
}

}
