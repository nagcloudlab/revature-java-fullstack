

const greeting=require('revature-greeting-nov')
const lodash=require('lodash')


let language="es";
greeting(language)


let arr1=[1,2,3]
let arr2=[1,2,2]

let arr3=lodash.difference(arr1,arr2);
console.log(arr3);