//js_034_dom.js

let hNode = document.getElementById('selector');
console.log(hNode);
console.log(hNode, typeof hNode);

//id
let hId = document.querySelector('#selector');
console.log(hId, typeof hId);

//class choice
let hClass = document.querySelector('.choice');
alert(hClass);
console.log(hClass, typeof hClass);

//HTMLColletion(4)
let pNode = document.getElementsByTagName('p');
console.log(typeof pNode);
console.log(pNode.length);
console.log(pNode[0]);
console.log(pNode.item);
console.log(pNode[0].innerText);
pNode[0].style.color = 'red';
pNode[0].style.backgroundColor = 'blue'; //background-color --> backgroundColor

function process() {
  alert('test');
  let fname = document.frm.fname;
  console.log('fname:', fname);
  console.log(fname.value);
  console.log(fname.defaultValue);
  return false;
}
