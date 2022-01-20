import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UsuarioLoginDTO } from '../model/UsuarioLoginDTO';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  UsuarioLoginDTO: UsuarioLoginDTO= new UsuarioLoginDTO()

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0)
  }

  entrar(){
    this.auth.login(this.UsuarioLoginDTO).subscribe((resp: UsuarioLoginDTO)=>{
        this.UsuarioLoginDTO = resp

          environment.token = this.UsuarioLoginDTO.token
          environment.email = this.UsuarioLoginDTO.emailUsuario
          environment.senha = this.UsuarioLoginDTO.senhaUsuario
         

     
        this.router.navigate(['/cadastro-produtos'])
    }, (erro: { status: number; }) =>{
      if(erro.status == 500){
        alert('Usuário ou senha estão incorretos')
      }
    })
    }
  }
