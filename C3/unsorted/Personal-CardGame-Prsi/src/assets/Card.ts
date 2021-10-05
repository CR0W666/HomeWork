import { CardColor, CardValue } from "./Library";

export class Card {
    
    readonly value: CardValue;
    readonly color: CardColor;
    readonly name: String;
    readonly imgs = {
        front: "",
        back: ""
    };

    constructor(value: CardValue, color: CardColor) {
        this.value = value;
        this.color = color;
        this.name =  CardColor[color] + '_' + CardValue[value];
        this.imgs.front = 'assets/imgs/'+this.name+'.jpg';
        this.imgs.back = 'assets/imgs/CARD_BACK.jpg';
    }

}