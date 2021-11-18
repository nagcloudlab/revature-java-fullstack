
import './styles/theme.scss'

// const _=require('lodash')
// or
import _ from 'lodash'

// const {item1,item2}=require('./hotel/menu'); // cjs
// -or-
// import {item1,item2} from './hotel/menu' // es
// import {item1 as favItem1,item2 as favItem2} from './hotel/menu'
import mainItem,* as items from './hotel/menu';


let menu1=[
    'item-2','item-3','item-4'
];

let menu2=[
    'item-3','item-4','item-5',
];

let differenceMenu=_.difference(menu1,menu2)
console.log(differenceMenu);

console.log(mainItem);
console.log(items.item1);
console.log(items.item2);


