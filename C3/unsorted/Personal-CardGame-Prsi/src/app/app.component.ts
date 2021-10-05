import { Component } from '@angular/core';
import { Game } from './Game';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'KartyPrsi';

  game: Game = new Game;

  startGame() {
    this.game.init();
  }
}
