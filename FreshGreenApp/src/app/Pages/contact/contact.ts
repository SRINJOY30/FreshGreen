import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact',
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.html',
  styleUrl: './contact.css'
})
export class Contact {
  contact = {
  name: '',
  email: '',
  contact: '',
  subject: '',
  message: ''
};

submitContact() {
  console.log('Contact submission:', this.contact);
  // Call backend API here
}

}
