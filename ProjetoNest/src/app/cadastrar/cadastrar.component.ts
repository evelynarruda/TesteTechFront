import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../usuario/UsuarioEntity';
import { UsuarioCadastrarDTO } from '../usuario/UsuarioCadastrarDTO';
import { AuthService } from '../service/AuthService';

@Component({
  selector: 'app-cadastrar',
  template: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class CadastrarComponent implements OnInit {
  usuario: Usuario = new Usuario
  confirmarSenha: string
  tipoUsuario: string
  constructor(
    private authService: AuthService,
    private router: Router
  ){}

  ngOnInit(): void {
    window.scroll(0,0)
  }
}