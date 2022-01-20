import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { environment } from 'src/environments/environment.prod';
import { CredenciaisDTO } from '../model/CredenciaisDTO';
import { ProdutoModel } from '../model/Produto';
import { UsuarioLogin } from '../model/UsuarioLogin';
import { UsuarioLoginDTO } from '../model/UsuarioLoginDTO';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  constructor(
    private http: HttpClient
  ) { }

  login(credenciais: CredenciaisDTO): Observable<CredenciaisDTO> {
    return this.http.put<CredenciaisDTO>('http://localhost:8080/api/v1/usuarios/login', this.login)
  }

usuarioById(id: number): Observable<UsuarioLogin>{
  return this.http.get<UsuarioLogin>('http://localhost:8080/api/v1/usuarios/todes', this.token)
}

cadastrar(produto: ProdutoModel): Observable<ProdutoModel>{
  return this.http.post<ProdutoModel>('http://localhost:8080/api/v1/produtos/cadastrar', this.cadastrar)
}

logado(){
  let ok = false

  if(environment.token != ''){
    ok = true
  }

  return ok
}

}

