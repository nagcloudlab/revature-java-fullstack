


// Function Closure 

/**
 * 
 * A closure is a function having access to the parent scope, 
 * even after the parent scope has closed.
 * 
 * 
 */


function teach(sub){
    console.log("teaching "+sub);
    const notes=`${sub}-notes`;
    const fun="bla bla bla";
    function learn(){
        console.log("learning with "+notes);
    }
    //learn();
    console.log("teaching ends..");
    return learn;
}


let learnFunc=teach("javascript")
learnFunc();

