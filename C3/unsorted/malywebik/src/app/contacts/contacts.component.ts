import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent implements OnInit {

  constructor() { }
  name = "";
  surname = "";
  email = "";

  ngOnInit(): void {
  }

  postform() {
    console.log("Name = " + this.name + "\nSurname = " + this.surname + "\nE-mail = " + this.email);
  }

}
