var hong = {name :'홍길동'};
//var son = {age : 32};
// son.__proto__ = hong;
var son = Object.create(hong); // hong을 부모로 하는 새로운 객체 생성 son.__proto__.name
// var son = {...hong}; // hong 객체를 깊은 복사 son.name
son.age = 32;
console.log(hong.name, '= hong.name');
console.log(son.name, '= son.name');
console.log(son.age, '= son.age');
son.name='손흥민';
//debugger;
console.log(hong.name, '= hong.name');
console.log(son.name, '= son.name');
console.log(son.age, '= son.age');