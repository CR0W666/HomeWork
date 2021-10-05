let arraySize;
let unsorted = [];
let input = [];


//---------------
fillRand( 10, 0 );
unsorted = input;
console.log(unsorted);
console.table( unsorted );
//wtf(5000);
sort( input );
console.log(input);
console.table( input );
// console.log( "unsorted: \n");
// 
// console.log( "sorted  : \n");
// 

//deprecated visualization

// window.onload = function () {
// let element = document.getElementById("place");
// console.log(element);
// console.log(input);
// element.innerText = input;

// };


// async function wtf(msTime) {
//     await new Promise(r => setTimeout(r, msTime));  // PROC TO FFS NEFUNGUJE OMFG
// }

//======================================

function sort( input ) {
    arraySize = input.length;

    let forLength = Math.floor( arraySize / 2 ); 

    for ( let i = forLength; i >= 0; i-- ) {
        heap( input, i );
    }

    for( i = arraySize-1; i > 0 ; i-- ) {
        let temp = input[ 0 ];

        input[ 0 ] = input[ i ];
        input[ i ] = temp;


        arraySize--;
        heap(input, 0);

    }
}

function heap(input, parent) {

    let leftChild  = 2 * parent + 1;
    let rightChild = leftChild  + 1;
    let maximum = parent;

    if ( leftChild < arraySize && input[ leftChild ] > input[ maximum ] ) {

        maximum = leftChild;

    }

    if ( rightChild < arraySize && input[ rightChild ] > input[ maximum ] ) {

        maximum = rightChild;

    }

    if ( maximum != parent ) {
        let temp = input[ parent ];

        input[ parent  ] = input[ maximum ];
        input[ maximum ] = temp;

        heap(input, maximum);


    }


}







function fillRand( length, start ) {
    let random;
    for ( let i = 0; i < length-start; i++ ) {

        //random = Math.random() * 2001 - 1000; //gen random num  
        //random = random.toFixed( 3 );

        random = Math.floor(Math.random() * 1001);
        
        if ( input.includes( random ) ) { //if num is in array, generate new
            fillRand( length, i );
        } else {
            input.push( random );           //if not, add it
        }
        
        
    }
}

