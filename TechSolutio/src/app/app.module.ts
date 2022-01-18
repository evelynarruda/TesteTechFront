import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';
import { CadastroProdutosComponent } from './cadastro-produtos/cadastro-produtos.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListaProdutosComponent,
    CadastroProdutosComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
