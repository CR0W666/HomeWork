import { Card } from "./Card";

export class Deck {
    deck: Card[]
    constructor(deck: Card[]) {
        this.deck = deck;
    }

    draw() {
        return this.deck.pop();
    }

    put(card: Card) {
        this.deck[this.deck.length+1] = card;
    }

    dealHand() {

        let hand: Card[] = [];

        for (let i = 0; i<5; i++) {
            hand.push(this.deck.pop()!);
        }

        return hand;
    }

    printDeckToConsole(msg: String) {
        console.log(`${msg} | `);
        console.table(this.deck);
    }

    shuffle() { //Fisher-Yates Shuffle  (from https://bost.ocks.org/mike/shuffle/)

        let currentIndex = this.deck.length, temporaryValue, randomIndex;

        // While there remain elements to shuffle...
        while (0 !== currentIndex) {

            // Pick a remaining element...
            randomIndex = Math.floor(Math.random() * currentIndex);
            currentIndex -= 1;

            // And swap it with the current element.
            temporaryValue = this.deck[currentIndex];
            this.deck[currentIndex] = this.deck[randomIndex];
            this.deck[randomIndex] = temporaryValue;
        }
    }
}