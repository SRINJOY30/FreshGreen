import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  user = {
    fullName: '',
    email: '',
    phone: '',
    password: '',
    confirmPassword: ''
  };

  registerUser() {
    if (this.user.password !== this.user.confirmPassword) {
      alert('Passwords do not match!');
      return;
    }

    // Send to backend (optionally using a service)
    console.log('Registered User:', this.user);
  }
}
