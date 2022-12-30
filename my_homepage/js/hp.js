//hp.js
function chgTab(i1, i2) {
  //텝메뉴
  let tm = document.querySelectorAll('.tm>li');

  //텝내용
  let tc = document.querySelectorAll('.tc>li');

  //클래스 추가
  tm[i1].classList.add('on');
  tc[i1].classList.add('on');

  //클래스 제거
  tm[i2].classList.remove('on');
  tc[i2].classList.remove('on');
}
