package com.lec.ex;
// 배열 잡는 방법
public class Ex01 {
	public static void main(String[] args) {
		int i = 10; // (정수 변수, int 변수) 변수 선언과 초기화 동시에
		// 배열의 치명적인 단점: 확보된 공간에서만 사용 가능함. 한번 배열방의 갯수가 세팅되면 조정될 수 없음. 즉, 정확한 수가 정해진 것에서만 사용함. 그래서 컬렉션을 주로 사용. 컬렉션은 배열과 사용 방법 동일.
		// 1. 배열 변수 선언과 초기화 ([]꺽쇠가 배열을 의미함)
		int[] iArr = {10, 20, 30, 40, 50}; // <{} 안에 들어간 것은 인덱스, 순서는 0부터 시작하기 때문에 인덱스가 4까지 들어갔다는 것은 방이 5개 잡혔다는 것의 의미.
		iArr[2] = 300; // 배열은 index로 접근 (0~4) > 인덱스 2 == 30 값을 300으로 변경
		for(int idx =0 ; idx<iArr.length ; idx++) { //length 배열 방의 갯수 = 숫자가 바뀌는 변수가 있다면 length 많이 씀
			System.out.println(iArr[idx]);
		 }
		// 2. 배열 변수의 선언과 배열 메모리 공간 확보
		int[] iArr2 = new int[5]; // new는 메모리 공간을 할당시키는 연산자 >> int 5개 공간을 할당함
		iArr2[0] = 999;
		for(int idx=0 ; idx<iArr2.length ; idx++) {
			System.out.printf("iArr2[%d] = %d\n", idx, iArr2[idx]);
		}
		// 3. 배열 변수 선언
		int[] iArr3;
		iArr3 = new int[3]; // {0, 0, 0} 0으로 초기화됨 >> 배열 공간 확보함
		// 확장 for문 쓰는 법! >> 일반 포문처럼 몇번째 ~, 라고 쓸 수 없음
		for(int temp : iArr3) {
			System.out.println(temp);
		}
		// 일반 for문을 이용한 배열 방의 값을 변경하는 방법!
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			iArr3[idx] = 999;
		}
		for(int idx=0 ; idx<iArr3.length ; idx++) {
			System.out.println(idx+"번째: " + iArr3[idx]);
		}
		// 확장 for문을 이용한 배열 방의 값을 변경하는 방법 >> 불가함
		for(int ia : iArr3) {
			ia = 111;
			System.out.println(ia);
		}
		for(int ia : iArr3) {
			System.out.println(ia);
		}
	}
}
