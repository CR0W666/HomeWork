import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  constructor() { }
  toggle = false;
  ngOnInit(): void {
  }

  toggleSide() {
    this.toggle = !this.toggle;
  }
}
