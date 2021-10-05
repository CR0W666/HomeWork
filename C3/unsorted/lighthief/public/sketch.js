let canvas;

let playAreaWidth;
let playAreaHeight;
let playAreaPosX;
let playAreaPosY;
let resizeOffset;

let platform;
let platforms = [];

function setup() {

    noCursor();
    canvas = createCanvas(windowWidth, windowHeight);
    canvas.style('display', 'block');
    elementDefinitions();
    makePlatforms(1000);
}

function elementDefinitions() {
    resizeOffset = playAreaPosX;
    //play area
    
    playAreaWidth = 500;
    if (height < 900) {
        playAreaHeight = 700;
    } else {
        playAreaHeight = height-200;
    }
    
    playAreaPosX = width/2-playAreaWidth/2;
    
    playAreaPosY = height/2-playAreaHeight/2;
    
    //platforms
    resizeOffset -= playAreaPosX;
    platforms.forEach(element => {
        element.x -= resizeOffset;
    });

    //canvas

    //player

}

function windowResized() {

    canvas = resizeCanvas(windowWidth, windowHeight);
    elementDefinitions();

}

function makePlatforms(count) {
    let ypos = height/2+200;
    let xpos = width/2;
    for (let i = 1; i < count; i++) {
        if(random(0, 2) > 1) {
            platforms[i] = new Platform(xpos, ypos, "light");
        } else {
            platforms[i] = new Platform(xpos, ypos, "dark");
        }
    
        ypos-=100;
    }
}

function draw() {
    
    background(GRAY);
    fill(color(200));
    rect(playAreaPosX, playAreaPosY, playAreaWidth, playAreaHeight);
    platforms.forEach(element => {
        element.draw();
        //console.table(element.world);
    });

}

class Platform {

    constructor(x, y, world, platWidth, platHeight) {
        this.x = x;
        this.y = y;
        this.world = world;
        if (platWidth != null) {
            this.platWidth = platWidth;
        } else {
            this.platWidth = 200-random(0, 80);
        }

        if (platHeight != null) {
            this.platHeight = platHeight;
        } else {
            this.platHeight = 20;
        }

    }

    draw() {

        if(this.world === "light") {
            fill(color(255));      
        } else { 
            stroke(color(255));
            fill(color(0));
            
        }
        
        rect(this.x-this.platWidth/2, this.y, this.platWidth, this.platHeight);
        stroke(color(0));
    }
}