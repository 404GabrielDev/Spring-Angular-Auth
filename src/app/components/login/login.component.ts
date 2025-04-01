import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  credentials: any= {};

  constructor(private authService: AuthService, private router:Router) {}


  login() {
    this.authService.login(this.credentials).subscribe({
      next: (response) => {
        console.log("Login bem-sucedido", response)
      },
      error: (err) => {
        console.error("Erro ao logar, verifique as credenciais!", err)
        this.router.navigate(['/home'])
      }
    })
  }
}
