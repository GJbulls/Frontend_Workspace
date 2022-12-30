//js_045_gallery.js
//(1) 작은 이미지를 클릭하면 큰 이미지 보이게
let bigPhoto = document.querySelector('#photo>img');
//onsole.log(bigphoto.src);
let list_zone = document.querySelector('ul#inner_list');
let ul_li = list_zone.children;
console.log(ul_li); //HTMLCollection(8)

ul_li = [...ul_li]; //배열로 바꿔줌
ul_li.map((liTag, idx) => {
  let aTag = liTag.querySelector('a');
  aTag.onclick = (e) => {
    bigPhoto.src = aTag.href;
    return false; //e.preventDefault()
  };
});

//(2)다음 (>)버튼을 클릭할때 마다 <li>이 100만큼 이동하게 한다.
let m_num = 0;
let next_btn = document.querySelector('#next_btn');
next_btn.onclick = (e) => {
  if (m_num >= ul_li.length - 3) return false;
  m_num++;
  list_zone.style.marginLeft = -100 * m_num + 'px';
  return false;
};
//(3)이전 (<)버튼을 클릭할때 마다 <li>이 100만큼 이동하게 한다.
let before_btn = document.querySelector('#before_btn');
before_btn.onclick = (e) => {
  if (m_num <= 0) return false;
  m_num--;
  list_zone.style.marginLeft = -100 * m_num + 'px';
  return false;
};
