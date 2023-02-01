class Person {
    constructor (name, first, second) { 
        console.log ('생성자 함수 호출');
        this.name = name;
        this.first = first;
        this.second = second;
    }
    // constructor (name) { // X(생성자 함수는 단 1개만)
    //     this.name = name;
    //     this.first = 100;
    //     this.second = 100;
    // }
    sum(){ // 함수
        return this.first + this.second;
    }
} // class 생성
var hong = new Person('홍길동', 100, 60);
console.log('홍길동의 sum: ' +hong.sum());

class PersonPlus extends Person {
    constructor(name, first, second, third){ // 생성자 함수는 무조건 constructor
        super(name, first, second); // 부모클래스 생성자 함수 (superclass의 매개변수 가져와야 함)
        this.third = third;
    }
    sum(){
        return this.first + this.second + this.third;
        // return super.sum().this.third; < X
    }
    avg(){
        return this.sum() / 3;
    }
}
var son = new PersonPlus('홍민기', 100, 90, 95);
console.log('홍민기의 sum: ' +son.sum());
console.log('홍민기의 avg: ' +son.avg());