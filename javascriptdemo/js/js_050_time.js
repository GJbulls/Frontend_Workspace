function display() {
  for (let i = 0; i <= 5; i++) {
    console.log(i);
  }
}

console.log('start');
//setTimeout(display, 1000); 한번만 수행됨
//비동기화로 처리가 됌
//1000 = 1초 \\setTimeout(실행함수,시간)
//clearTimeout(display)
///////////////////////////////////////////////////////////
setInterval(display, 1000); //반복해서 수행됨
//clearInterval(display); // 스탑
console.log('end');
