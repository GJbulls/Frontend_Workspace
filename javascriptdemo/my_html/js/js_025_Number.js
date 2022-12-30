//js_024_function.js

let data = 10;
let fData = new Number(data);
let nObj = new Number(data);

console.log(`data=${typeof data}`); //data=number
console.log(`data=${typeof fata}`); //data=undefined
console.log(`data=${typeof nObj}`); //data=object

//toString() : number, Number -> string
console.log(typeof nObj.toString()); //string
console.log(typeof data.toString()); //string

console.log(data + fData); // number + number = 20
console.log(data + nObj); // number + object = 20

//Number -> number
//value of() : object -> primitive
console.log(typeof nObj.valueOf()); //number
console.log(typeof new String('javascript').valueOf()); //string

//문자열로 출력
let val = '10.0';
// let val = '10.3';
// let val = 'A';
// let val = '10A'; //parseint()는 앞에 숫자만 인식함.
// let val = 'A10';
console.log(val + val);
console.log(val);

//숫자로 나온다.Number(), parseint()
console.log(Number(val) + Number(val)); //20 20.6 NaN NaN NaN
console.log(parseInt(val) + parseInt(val)); //20 20 NaN 20 NaN
console.log(parseFloat(val) + parseFloat(val)); // 20 20.6 NaN 20 NaN;
