import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  user: any= {};

  constructor(private authService: AuthService, private router:Router) {}

  register() {
    this.authService.register(this.user).subscribe({
      next: () => {
        this.router.navigate(['/login'])
      },
      error: (err) => {
        console.error('Registration error', err)
      },
      complete: () => {
        console.log('Registration complete')
      }
    })
  }

}
