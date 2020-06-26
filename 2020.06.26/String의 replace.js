var data = {  title : "hello",
              content : "lorem dkfief",
              price : 2000
           };
var html = "<li><h4>{title}</h4><p>{content}</p><div>{price}</div></li>"; // 템플릿 html

html.replace("{title}", data.title) // 저장된 html템플릿에 받아온 데이터(JSON 등등)의 값을 매칭하여 replace해주고 
    .replace("{content}", data.content) // 그 뒤에 html DOM 트리를 만들 수 있다.
    .replace("{price}", data.price)

    //만약! 데이터가 배열의 형태로 여러개가 있다면? for문이나 forEach와 같은 반복문을 통해 해결할 수 있다.