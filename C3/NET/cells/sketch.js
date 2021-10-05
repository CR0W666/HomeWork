cells = [];
let cellCount;
function setup() {
    createCanvas(700, 700);
    background(0);
    cellCount = 1;
    cells.push(new Cell(random(100, 600), random(100,600), 30, cellCount));
}

function draw() {
    cellCount = cells.length;
    background(0);
    for (const thiscell in cells) {
        if (cells.hasOwnProperty(thiscell)) {
            const cell = cells[thiscell];
            const index = cells.indexOf(cell);
            cell.show();

            if (cell.grow() === "max") {
                cell.mitosis();
            } else if(cell.grow() === "old") {
                cellDeath(index);
            }

        }
    }

}
function cellDeath(index) {
    cells.splice(index, 1);
}