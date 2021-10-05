import { Card } from "src/assets/Card";
import { Deck } from "src/assets/Deck";
import { Player } from "src/assets/Player";
import { State } from "src/assets/State";
import { Logic } from "./Logic";


export class Game {
    logic: Logic;
    deck: Deck;
    state: State;
    playedCards: Deck = new Deck([]);
    cardArrDeck: Card[];
    players: Player[] = [];
    currentPlayer: number = 0;

    constructor() {
        this.logic = new Logic;
        this.state = new State;
        this.deck = new Deck(this.logic.generateDeck());
        this.cardArrDeck = this.deck.deck;
        this.deck.printDeckToConsole("deck");
        this.init();
    }


    draw(num: number) {
        for (let i = 0; i < num; i++) {
            this.players[this.currentPlayer].draw(this.deck.draw()!);
        }
        
    }

    init() {
        this.deck.shuffle();
        this.players[0] = new Player(this.deck.dealHand(), 0);
        this.players[1] = new Player(this.deck.dealHand(), 1);
        this.players.forEach(player => player.printHandToConsole(`player ${player.id+1}`));
    }

}