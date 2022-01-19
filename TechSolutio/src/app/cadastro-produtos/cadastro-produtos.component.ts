import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-cadastro-produtos',
  templateUrl: './cadastro-produtos.component.html',
  styleUrls: ['./cadastro-produtos.component.css']
})
export class CadastroProdutosComponent implements OnInit {

   idProduto = environment.idProduto
   nomeProduto = environment.nomeProduto
   idFornecedor = environment.idFornecedor
   valor = environment.valor

  

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  
  sair(){
    this.router.navigate(['/login'])
    environment.token = '',
    environment.nome = '',
    environment.id = 0
}
  cadastrar(){
    this.router.navigate(['/listadeprodutos'])
    environment.idProduto = ''
    environment.nomeProduto = ''
    environment.idFornecedor
    environment.valor
  }
}
