import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent} from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactsComponent } from './contacts/contacts.component';
import { NavComponent } from './nav/nav.component';

const routes: Routes = [
  {path: "nav", component: NavComponent},
  {path: "home", component: HomeComponent},
  {path: "about", component: AboutComponent},
  {path: "contacts", component: ContactsComponent},
  {path: "**", redirectTo: "home"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
