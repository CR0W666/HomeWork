import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateUserComponent } from './createuser/createuser.component';
import { UsersComponent } from './users/users.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    UsersComponent,
    UserComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
