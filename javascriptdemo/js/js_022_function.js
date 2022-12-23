//js_022_function.js

//함수(function) : 특정 기능을 하는 구문을 독립된 부품으로 만들어 재사용하고자 할 때 사용하는 문법이다.

/*
    함수정의
    1) 함수 선언문
    function 함수명(매개변수){
        실행문;
        return값;
    }

    2) 함수 표현식
    let test = function(매개변수){
        실행문;
        return값;
    }

    3)즉시실행(익명함수)
    (function(파라미터)){
        console.log(`${파라미터} run~~~`);
    })('test');
*/

let year = 2012;
//함수정의
function isLeapYear(year) {
  let check;
  if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
    check = true;
  } else {
    check = false;
  }
  return check;
}

//함수호출
let result = isLeapYear(year);
if (result) {
  console.log(`${year}은 윤년입니다.`);
} else {
  console.log(`${year}은 평년입니다.`);
}

//함수정의
function add(a, b) {
  console.log(`a=${a}, b=${b}`);
  return a + b;
}

function add2(a, b, c) {
  return a + b + c;
}

//함수호출
console.log(add(2, 3));
console.log(add2(2, 3, 4));
console.log(add());
//console.log(add3());//ReferenceError: add3 is not defined

console.log(add(1)); //NaN
console.log(add(1, 'script')); //1script
console.log(add(1, 2, 3)); //3
console.log(add(1, null)); //a=1, b=undefined
console.log(add(1, undefined)); //NaN

/////////////////////////////////////////////////////////////////////////
//함수 표현식

//ES5 - 익명함수
let sum = function (a, b) {
  return a + b;
};
console.log(sum);
console.log(sum(10, 20)); //30

let hap = function (a, b) {
  console.log(a + b);
};

console.log(hap); //ƒ (a, b) { console.log(a + b);}
console.log(hap(10, 20)); //undefined
hap(10, 20); //30

//ES6 (2015) - 화살표 함수(Arrow function)
/*
    화살표 함수 규칙
    1) 매개변수 지정방법
    ==>매개변수 ()이용하여 지정 / 매개변수가 없는경우 ()소괄호를 해준다.
    ==>매개변수가 하나 있으면 ()소괄호 생략가능.
    ==>매개변수가 두개 이상이면 ()소괄호 생략 할 수 없다.


    2) 함수몸체 정의 방법
        x=> {return x*x}  //single line block으로 {}중괄호를 생략하지 않으면 return을 반드시 해준다.
        x=> x*x                                   {}중괄호를 생략하면 return로 생략가능하다.

        () => {return {a:1}};
        () => ({a:1}); //객체를 반환할때는 ()소괄호를 사용한다.
        () => {let x =10 ;            //multi line block
              return x*x}
        */
let sub = (a, b) => {
  return a + b;
};

console.log(sub); //(a, b) => { return a + b;}
console.log(sub(3, 4)); //7

let cal2 = (a) => a;
console.log(cal2);
console.log(cal2(3));

let cal3 = () => console.log('로그인해주세요');
console.log(cal3);
console.log(cal3()); //undefined
cal3(); //로그인해주세요

////////////////////////////////////////////////////////////////////////
//다양한 함수구조

//중첩함수
function outer(a, b) {
  let result = inner(a, b);
  function inner(a, b) {
    return a + b;
  }
  return result;
}

console.log(outer(10, 3)); //13

//콜백함수
//1) 다른 상수의 인수로 사용되는 함수
//2) 어떤 이벤트에 의해 호출되는 함수 : btn.oneclick = function(){}

function callback(a, b) {
  return a + b;
}

function getNumber(callFunc) {
  console.log(`==${callFunc}`);
  let result = callFunc(1, 6);
  return result;
}

console.log(getNumber(callback));

//클로저(closure)
/*
1) 중첩함수는 outer(외부)함수가 끝나면 외부에서 outer(외부)함수의 자원을 사용할 수 없다.
2) 클로저는 outer(외부)함수보다 중첩함수가 더 오래 유지되는 경우 중첩함수는 이미 생명주기가
종료한 외부함수의 변수를 참조할 수 있다. 이러한 중첩함수가 클로저(closure)이다.
3) 클로저는 변수가 의도치 않게 변경되지 않도록 안전하게 은닉(informaion hiding)하고 
특정 함수에게만 상태 변경을 허용하여 상태를 안전하게 변경하고 유지하기 위해 사용한다. 




*/
function outerFunc() {
  let sum = 50;
  function innerFunc(a) {
    return sum + a;
  }
  return innerFunc;
}

console.log(outerFunc()); //ƒ innerFunc(a) { return sum + a; }
let outerCall = outerFunc();
console.log(outerCall); //ƒ innerFunc(a) { return sum + a; }
console.log(outerCall(3)); //53
console.log(outerCall(4)); //53

///////////////////////////////////////////////////////////////
//함수 파라미터

//1) 기본 파라미터(default parameter) : ES6-2015
function display(a = 0, b = 0) {
  console.log(`a=${a}, b=${b}`);
}
display(1, 2); //a=1, b=2
display(1); //a=1 ,b=0
display(1, 2, 3, 4); //a=1, b=2 || a=1, b=0 || a=1, b=2

//2) 나머지 파라미터(Rest Parameter) : ES6-2015
//-파라미터 개수를 가변으로 사용할 수 있도록 제공해주는 연산자이다.
//spread operator (점 3개(...))를 맨 마지막 파라미터로 사용해주면 된다.
function display2(...args) {
  console.log(args); //[1,2]
  console.log(typeof args, args instanceof Array); //object true
}
display2(1, 2);
display2(1);
display2(1, 2, 3, 4, 5);

function display3(num, ...args) {
  console.log(num);
  console.log(args);
}
display3(1, 2); //1[2]
display3(1); //1 []
display3(1, 2, 3, 4, 5); // 1 [2,3,4,5]

//arguments 객체
function display4() {
  let result = 0;
  for (let i = 0; i < arguments.length; i++) {
    console.log(typeof arguments, arguments instanceof Array, arguments.callee);
    console.log(arguments[i]);
  }
}
display4(1);
display4(1, 3, 5);
