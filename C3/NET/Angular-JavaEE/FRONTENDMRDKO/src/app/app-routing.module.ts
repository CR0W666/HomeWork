import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from './createuser/createuser.component';
import {UsersComponent} from './users/users.component';
import {UserComponent} from './user/user.component';
import {HomeComponent} from './home/home.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {path: 'createuser', component: CreateUserComponent},
  {path: 'users', component: UsersComponent},
  {path: 'user', component: UserComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},

  {path: '', redirectTo: 'home', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
