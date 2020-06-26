
/*
var log = document.querySelector(".log");
var lists = document.querySelectorAll("ul > li"); // 배열의 형태로 리턴

for(var i=0;i<lists.length;i++){
    lists[i].addEventListener('click', function(evt){
        console.log(evt.currentTarget); // 현재 클릭한 내용들을 출력
    });
}*/

var log = document.querySelector(".log");
var ul = document.querySelector("ul");

ul.addEventListener('click', function(evt){
//target이 image이면 src를 추출해서 출력하면 될듯.

    console.log(evt.currentTarget.tagName, evt.target.tagName); //currentTarget은 클릭된 이벤트가 걸린 노드(ul), target은 클릭한 최하위노드
    if(evt.target.tagName ==="IMG"){
        log.innerHTML = "IMG URL은, "+evt.target.src;
    }else if(evt.target.tagName === "LI"){ // li 영역을 클릭해도 이미지의 src가 나올수 있도록 작성
        log.innerHTML = "IMG URL은, "+evt.target.firstElementChild.src;
    }



})//ul , li, img 세개의 노드에 모두 이벤트가 걸려있다면 어떻게 될까? 기본적으로 img, li,ul순으로 이벤트가 발생한다(Bubbling)
// addEventListener의 세번째 인자로 true를 넣으면 반대로 작동한다. Capturing.(ul,li,img 순으로 실행)

// 자식에 일일이 이벤트를 등록하지 않고 부모노드에 이벤트를 등록시키고도 사용이 가능하다. 이게 Event delegation 이다!!!!!