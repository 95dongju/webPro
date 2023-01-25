// 가변인자함수: 매개변수 갯수에 따라 변하는 함수 | 화살표 함수에서는 불가함
// 내장 함수: Array()를 이용해서 가변인자 함수 array()를 생성

var arr1 = [273, 2, 3, 'Hello'];
var arr2 = Array(273, 2, 3, 'Hello');
var arr3 = [ , , , ]; // 방 3개짜리 빈 배열
var arr4 = Array(3); // Array() 매개변수가 1개면 방 갯수 (방 3개짜리 빈 배열)
var arr5 = []; // 빈 배열
var arr6 = Array(); // 빈 배열
console.log('arr1=', arr1, ' - 방의 갯수= ', arr1.length);
console.log('arr2=', arr2, ' - 방의 갯수= ', arr2.length);
console.log('arr1=', arr3, ' - 방의 갯수= ', arr3.length);
console.log('arr2=', arr4, ' - 방의 갯수= ', arr4.length);
console.log('arr1=', arr5, ' - 방의 갯수= ', arr5.length);
console.log('arr2=', arr6, ' - 방의 갯수= ', arr6.length);
//화살표 함수
// let sum = (x,y) => {
//     return x+y;
// }

// 익명 함수: 변수에 함수를 할당
// var sum = function() {
//     return x+y;
// }

// 선언적 함수: 함수를 선언
// function sum(x,y){
//     return x+y;
// }


sum(2,3);
sum(2,3,4);
sum(2,3,4,5,6,7,8,9);
