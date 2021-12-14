import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { UsuarioCadastrarDTO } from './usuario/UsuarioCadastrarDTO';

const routes: Routes = [

  {path: '', redirectTo: 'cadastrar', pathMatch: 'full'},
  
  {path: 'cadastrar', component: CadastrarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
