import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './listadeprodutos.component.html',
  styleUrls: ['./listadeprodutos.component.css']
})
export class ListaProdutosComponent implements OnInit {

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
}
