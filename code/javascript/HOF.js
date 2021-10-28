
function helloFunction(name){
    console.log("Hello "+name)
}

function hiFunction(name){
    console.log("Hi "+name)
}

// Higher-Order-Function

/*
    Functional Programming enables function composition,
    write simple/re-usable functions, compose to build complex function
*/

function emojiWrapper(greetFn){
    return function(name){
        console.log("🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱")
        greetFn(name);
        console.log("🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱🌱")
    }
}


helloFunction("Nag") // without Emoji

console.log("----------------------")

let greetFunctionWithEmoji=emojiWrapper(helloFunction) 
greetFunctionWithEmoji("Nag")// with Emoji