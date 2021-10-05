let blob;
let zoom = 1;
let blobs = [];
let newzoom;
let myStartSize = 64;
let blobReach;

function setup() {
    
    //createCanvas(600, 600);
    createCanvas(displayWidth, displayHeight);
    //createCanvas(11000, 11000);
    //createCanvas(5000,5000);
    
    blob = new Blob(myStartSize, 0, 0, false);
    blobReach = new Blob(blob.r*PI, 0, 0, "reach");

    for(let i = 0; i < 1000; i++) {

        let x = random(-width, width);
        let y = random(-height, height);
        blobs[i] = new Blob(16, x, y, false);

    }

}

function draw() {
    background(0);
    

    translate(width/2, height/2);
    newzoom = myStartSize / blob.r;
    zoom = lerp(zoom, newzoom, 0.1);
    scale(zoom);
    translate(-blob.pos.x, -blob.pos.y);
    

    for (let i = blobs.length-1; i >= 0; i--) {
        blobs[i].show();
        if (blob.eats(blobs[i])) {
            blobReach.r = blob.r*PI
            blobs.splice(i, 1);

        }

        
    }

    blob.show();
    blobReach.show();
    blob.update(); 
    blobReach.update();
    
}

function keyPressed() {

    if(keyCode == SHIFT) {
        splitBlob();
    }

}

function splitBlob() {

    translate(blob.pos.x, blob.pos.y);
    let halfBlob = new Blob((blob.r/2), random(blob.r, blob.r*2+1), random(blob.r, blob.r*2+1), true);

    blob.r = blob.r*2;
    blobs.push(halfBlob);
    halfBlob.show();
    console.log(blob.r);
    translate(-blob.pos.x, -blob.pos.y);

}