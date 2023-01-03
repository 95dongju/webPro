package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//(1) x를 입력할 때까지 재고 등록 (물건명, 가격, 재고수량):file출력 => (2) x를 입력하면 이때까지 등록된 모든 재고 목록을 출력함
// 등록된 데이터는 반드시 자바로만 볼 수 있도록 datai/ostream 사용.
public class Ex03_Product {
	public static void main(String[] args) {
		//x를 입력할 때까지 재고 등록 (물건명, 가격, 재고수량):file출력
		OutputStream fos = null; // 기본 스트림
		DataOutputStream dos = null; // 외부에서 볼 수 없도록 하는 보조 스트림
		Scanner sc = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true); //true를 해야 쌓임
			dos = new DataOutputStream(fos);
			while(true) {
				System.out.println("입력할 재고가 있습니까? (입력:Y/종료:X) : ");
				if(sc.next().trim().equals("X")) break;
				System.out.print("입고된 상품명  :");
				dos.writeUTF(sc.next());
				System.out.print("입고된 상품 가격 : ");
				dos.writeInt(sc.nextInt());
				System.out.print("입고된 상품 재고량: ");
				int stock = sc.nextInt();
				dos.writeInt(stock); // 이렇게 변수로 받아서 write해도 됨.
			}
			System.out.println("재고 등록 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {

			}//close
		}// 재고 등록 try - catch - finally
		// x를 입력하면 이때까지 등록된 모든 재고 목록을 출력함
		ArrayList<Product> products = new ArrayList<Product>();
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while(true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int stock = dis.readInt();
				products.add(new Product (name,price,stock));
//				Product product = new Product(); // 이런 식으로도 사용 가능
//				product.setName(dis.readUTF());
//				product.setPrice(dis.readInt());
//				product.setStock(dis.readInt());
//				products.add(product); 
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 목록 출력합니다");
		} finally {
			try {
				if(dos!=null) dos.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch
		if(products.isEmpty()) {
			System.out.println("등록된 재고가 없습니다");
		}else {
			System.out.println("물품명\t가격\t재고수량");
			for(Product product : products) {
				System.out.println(product);
			}
			System.out.println("이상 재고 " +products.size()+"가지 재고 입력됨");
		}
		
		
		
		
//		do { // 재고등록 물어보기 // 스트링객체를 여러번 물어봐야 함
//			try { // 재고등록 물어보기  
//				
//			}catch (Exception e) {
//				
//			}finally {
//				
//			}
//		}while(true);
		
	}
}
