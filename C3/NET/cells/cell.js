class Cell {
    constructor(x, y, r, cellCount) {
        this.name = "cell#" + cellCount;
        this.age = 0;
        this.maxAge = 5000;
        this.r = r;
        this.size = r*2;
        this.growSpeed = 0.05;
        this.pos = createVector(x, y);
        this.maxhp = r*1.5;
        this.hp = this.maxhp;
        this.percentHp = 100;
        this.maxSize = 200;
        this.minSize = 30;
        this.membranepdef = random(0, 10); 
    }

    show() {
        
        //color(this.calcColor(), 50);
        fill(color(this.calcColor()));
        noStroke();
        ellipse(this.pos.x, this.pos.y, this.size);
    }
    calcColor() {
        
        if (this.percentHp >= 80) {
            return "#008000"; //green 
        } else if( this.percentHp < 80 && this.percentHp > 50) {
            return "#ffff00"; //yellow
        } else if(this.percentHp <= 50 && this.percentHp > 20) {
            return "#FFA500"; //orange
        } else if(this.percentHp <= 20 && this.percentHp > 0) {
            return "#FF0000"; //red
        } else {
            return "#808080"; //grey
        }
    }

    grow() {
        
        let newSize = this.r+this.growSpeed;

        if(this.age < this.maxAge) {
            this.age++;
            if(newSize < this.maxSize) {
                this.doStats();
                //console.log(this.name + ": hp= " + this.hp + " | " + this.percentHp+"%");
                return "grown";
            } else {
                console.log(this.name + ": max size");
                return "max";
                //TODO max size handle
            }

        } else {
            console.log(this.name + ": max age");
            return "old";
            //TODO cell death
        }

    }

    mitosis() {
        let childCells = [];
        this.r /= 2;
        let newR = this.r;
        if(newR < this.minSize/2) {
            newR += ((this.minSize/2) - newR)+5;
        }
        childCells[0] = new Cell(this.pos.x, this.pos.y, this.r/2, cellCount+1)
        childCells[1] = new Cell(this.pos.x, this.pos.y, this.r/2, cellCount+2);
        return childCells;
    }

    doStats() {
        this.size += this.growSpeed;
        this.maxhp = this.r*1.5;
        this.percentHp = this.hp / (this.maxhp/100);
    }
}