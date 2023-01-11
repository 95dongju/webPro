// 2.js : 동적인 부분
name = prompt("이름은?", "홍길동"); // 취소를 클릭하면 'null'' 리턴
if (name != 'null' && name != '') { // 빈 스트링 혹은 null 이 들어가면 출력되지 않도록
    document.write(name + "~ 반갑습니다<br>")
}