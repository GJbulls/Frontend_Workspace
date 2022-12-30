//js_043_propagation.js
document.querySelector('.red').onclick = (e) => {
  alert('red');
};

document.querySelector('.green').onclick = (e) => {
  alert('green');
  e.stopPropagation(); //이벤트 전파를 차단시켜주는 메소드
};

document.querySelector('.blue').onclick = (e) => {
  alert('blue');
  e.stopPropagation(); //이벤트 전파를 차단시켜주는 메소드
};

document.querySelector('a').onclick = (e) => {
  alert('안녕하세요');
  // e.preventDefault(); //다른페이지로 이동하는걸 차단
  return false; //이벤트를 차단
};

/*
[1] Event Propagation(이벤트전파)
 ① 캡처링(capturing phase) : 부모요소에서 Target요소로 이벤트 전파
 ② 버블링(bubbling phase) : Target요소에서 부모요소로 이벤트 전파

[2] 이벤트 차단
==> stopPropagation()

[3] stopPropagation()과 preventDefault()비교
==> stopPropagation() : 이벤트 전파 차단 return(jQuery)
==> preventDefault() : 디폴트 이벤트 차단 return false(javascript,jQuery)
*/
