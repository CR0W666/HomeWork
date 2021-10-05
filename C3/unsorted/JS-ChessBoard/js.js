let yv = prompt("Výška: ", "10");
let xs = prompt("Šířka: ", "10");

function table() {
    let mydiv = document.getElementsByTagName("div")[0];
    let tablee = document.createElement("table");
    let tbodyy = document.createElement('tbody');
    

    for (let i = 0; i < yv; i++) {
        let trr = document.createElement('tr');
        for (let j = 0; j < xs; j++) {
            let tdd = document.createElement('td');
            if (i%2 == j%2) {
                tdd.className = "white";
            } else {
               tdd.className = "black";
            }
            trr.appendChild(tdd);
        }
        tbodyy.appendChild(trr);
    }
    tablee.appendChild(tbodyy);
    mydiv.appendChild(tablee);
    
}

window.addEventListener("DOMContentLoaded", function() {
    table();
}, false);
