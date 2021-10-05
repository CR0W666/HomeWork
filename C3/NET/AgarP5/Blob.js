function Blob(r, x , y, owner) {

    this.pos = createVector(x, y);
    this.r = r;
    this.vel = createVector(0,0);
    this.owner = owner;

    this.update = () => {

        let newvel = createVector(mouseX-width/2, mouseY-height/2);

        newvel.setMag(3);
        this.vel.lerp(newvel, 0.2);
        this.pos.add(this.vel);

    }



    this.show = () => {
        if(this.owner == "reach") {
            fill(255, 255, 255, 40);
            ellipse(this.pos.x, this.pos.y, this.r*PI, this.r*PI);
        } else {
            fill(255);
            ellipse(this.pos.x, this.pos.y, this.r*2, this.r*2);
        }
        
        
    }

    this.eats = (other) => {

        let d = p5.Vector.dist(this.pos, other.pos);

        if (d < this.r + other.r) {
            if (other.owner == true) {

                this.r += other.r;
                return true;

            } else {

                console.log(other.owner);
                let sum = PI * this.r * this.r + PI * other.r * other.r;
                this.r = sqrt(sum / PI);
                return true;

            }
            

        } else {

            return false;

        }
        
    }
}