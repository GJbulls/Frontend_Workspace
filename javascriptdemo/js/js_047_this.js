//js_047_this.js

console.log(this); //this를 단독으로 호출한 경우 호출한 객체가 없을 경우에는 기본적으로 window객체이다.

let member = {
  name: '홍길동',
  show: function () {
    console.log(this);
  },
};
member.show(); // 출력결과 {name: '홍길동', show: ƒ}
////////////////////////////////////////////////////
//arrow함수로 this 출력 결과
let member2 = {
  name: '홍길동',
  show: () => {
    console.log(this);
  },
};
member2.show(); // 출력결과 Window
//다른방법(익명함수)
function showThisName() {
  console.log(this);
}
showThisName(); // 출력결과 Window
//다른방법(arrow함수)
let showThisName2 = () => {
  console.log(this);
};
showThisName2(); // 출력결과 Window
////////////////////////////////////////////////////
//이벤트에서 this
let btn = document.querySelector('#btn');
btn.addEventListener('click', function () {
  console.log(this, this == btn); // <button id="btn">commit</button> 객체출력
});
//arrow함수
btn.addEventListener('click', () => {
  console.log(this, this == btn); // 출력결과 Window
});
/////////////////////////////////////////////////////////////////
///call, apply , bind를 이용해서 this에 특정객체를 지정할 수 있음///
/////////////////////////////////////////////////////////////////
// 1) call( ) : call메서드는 모든 함수에서 사용할 수 있으며 this값을 특정한값으로 지정할 수 있다.
const hong = { name: '홍길동' };
const jung = { name: '정해인' };
console.log('call()====================================');
showThisName.call(hong); //{name: '홍길동'}
showThisName.call(jung); //{name: '정해인'}

showThisName2.call(hong); //Aroow Function일때 Window
showThisName2.call(jung); //Aroow Function일때 Window

function person(birthday, job) {
  this.birthday = birthday;
  this.job = job;
  console.log(this);
}
person(2019, 'IT'); //window
//this로 사용할 hong객체와 person함수의 매개변수에서 받을 인수를 넘긴다.
person.call(hong, 2000, '프로그래머'); //{name: '홍길동', birthday: 2000, job: '프로그래머'}
//this로 사용할 jung객체와 person함수의 매개변수에서 받을 인수를 넘긴다.
person.call(jung, 2016, '디아지너'); //{name: '정해인', birthday: 2016, job: '디아지너'}

//////////////////////////////////////////////////////////////////////////////////////////////
// 2) apply( ) : ==>함수 매개변수를 처리하는 방법을 제회하면 call과 같다.
//               ==>call은 일반적인 함수와 마찬가지로 매개변수로 직접 받지만 apply는 매개변수를 배열로 받는다.
console.log('apply()====================================');
person.apply(hong, [2000, '프로그래머']); //{name: '홍길동', birthday: 2000, job: '프로그래머'}
person.apply(jung, [2016, '디자이너']); //{name: '정해인', birthday: 2016, job: '디자이너'}

///////////////////////////////////////////////////////////////////////////////////////////////
// 3) bind( ) : call과 사용방법은 같으나 실행을 해야한다.
console.log('bind()====================================');
let hongPerson = person.bind(hong, 2000, '프로그래머'); //{name: '홍길동', birthday: 2000, job: '프로그래머'}
hongPerson();

let jungPerson = person.bind(jung, 2016, '디자이너'); //{name: '정해인', birthday: 2016, job: '디자이너'}
jungPerson();
