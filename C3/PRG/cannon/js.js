let x = prompt ("X:", "10");
let y = prompt ("Y:", "10");

let dist = Math.sqrt(x*x + y*y);

if (dist <= 5)

    document.write("<h1 style=\"background-color:red  \">[ " + x + ", " + y + " ] je v dostrelu</h1>");

else if (dist > 5)

    document.write("<h1 style=\"background-color:green\">[ " + x + ", " + y + " ] neni v dostrelu</h1>");
