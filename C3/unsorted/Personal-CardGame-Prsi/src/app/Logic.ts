import { Card } from "src/assets/Card";
import { CardValue, CardColor } from "src/assets/Library";

export class Logic {
    

    generateDeck() {
        let newDeck: Card[] = [];

        for (const value in CardValue) {
            for (const color in CardColor) {

                let cValue: CardValue = value as unknown as CardValue;
                let cColor: CardColor = color as unknown as CardColor;
                if (!isNaN(cValue) && !isNaN(cColor)) newDeck.push(new Card(cValue, cColor));
            }
        }

        // for(let xValue = 0; xValue < 11; xValue++) {
        //     if(xValue == 4) xValue = 7;
        //     for(let yColor = 0; yColor < 4; yColor++) {
        //         newDeck.push(new Card(CardValue[xValue], CardColor[yColor]));
        //     }
        // }

        return newDeck;
    }

}

