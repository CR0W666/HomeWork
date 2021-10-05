import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor() { }

  search = "";
  routes = ["home", "about", "contacts"];


  ngOnInit(): void {
  }

  get links(): String[] {
    const links = [];

    // if (!this.search) {
    //   return [];
    // }

    for (const route of this.routes) {

      if (route.includes(this.search)) {
        links.push(route);
      }
    }
    return links;
  }

}
