import { Card } from "./Card";
import { CardColor, CardValue } from "./Library";

export class Player {
    hand: Card[];
    id: number;

    constructor(hand: Card[], id: number) {
        this.hand = hand;
        this.id = id;
    }
    printHandToConsole(msg: String) {
        console.log(`${msg} | `);
        console.table(this.hand);
    }

    draw(card: Card) {
        this.hand.push(card);
    }

    playCard(card: Card) {
        let myCard;
        for (let i = 0; i<this.hand.length; i++) {
            myCard = this.hand[i];
            if(myCard === card) {
                this.hand.splice(i,1);
            }
        }
        this.printHandToConsole(`player ${this.id+1} | `);
        return myCard;
    }
}