"use strict"; // 엄격하게 사용하겠다는 선언

let memberArray = ['egoing', 'graphittie', 'leezhce'];
var copyArray = memberArray; // 얕은 복사
// var로 선언 시 같은 이름으로 선언 가능, let은 같은 이름으로 선언 불가
var copyArray = [...memberArray]; // 객체의 깊은 복사
var copyArray = Array.from(memberArray); // 배열의 깊은 복사
console.log(typeof(memberArray));
copyArray[0] = '홍길동'; copyArray[1] = '변경'; copyArray[2] = 'copy';
console.group('memberArray for-loop');
for (var i=0; i<memberArray.length; i++){
    console.log(i+'번째 : ', memberArray[i]);
}
console.groupEnd('memberArray for-loop');
console.group('copyArray for-loop');
copyArray.forEach(function(data,idx){
    console.log(idx+'번째: ', copyArray[idx]);
});
console.groupEnd('copyArray for-loop');

var memberObject = {
    name: '홍길동',
    age: 20
};

// var copyObject = Object.assign({}, memberObject); // 객체의 깊은 복사
var copyObject = {...memberObject}; // 객체의 깊은 복사
var copyObject = Object.assign({id:1},memberObject); // id:1 추가
copyObject['name'] = '변경';

console.group('memberObject for-in문');
for(var key in memberObject){
    console.log(key, ' : ', memberObject[key] );
}
console.groupEnd('memberObject for-in문');

console.group('copyObject for-in문');
for(var key in copyObject){
    console.log(key, ' : ', copyObject[key] );
}
console.groupEnd('copyObject for-in문');