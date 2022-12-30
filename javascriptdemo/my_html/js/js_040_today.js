//js_040_today.js

let dataBtnNode = document.querySelector('button');
dataBtnNode.onclick = () => {
  let pNode = document.querySelector('p');

  //날짜는 무조건 new로 객체생성을 한다.
  let today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  let date = today.getDate();
  let hour = today.getHours();
  let minute = today.getMinutes();
  let second = today.getSeconds();

  pNode.innerText = `${year}-${month}-${date} ${hour}:${minute}:${second}`;
};
