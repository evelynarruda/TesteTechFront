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
    return this.http.put<CredenciaisDTO>('https://localhost:4200/api/v1/usuarios/login', credenciais)
  }

usuarioById(id: number): Observable<UsuarioLogin>{
  return this.http.get<UsuarioLogin>(`https://localhost:4200/api/v1/usuarios/todes`, this.token)
}

cadastrar(produto: ProdutoModel): Observable<ProdutoModel>{
  return this.http.post<ProdutoModel>('localhost:4200/api/v1/produtos/cadastrar', produto)
}

logado(){
  let ok = false

  if(environment.token != ''){
    ok = true
  }

  return ok
}

}

