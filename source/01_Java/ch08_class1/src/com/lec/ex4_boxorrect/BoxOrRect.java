package com.lec.ex4_boxorrect;
// 데이터 (속성) : width(가로), height(세로), depth(깊이), volume
	// 사각형 : width, height, depth=0, volume(넓이) : BoxOrRect r = new BoxOrRect(2,3);
	// 직육면체 : width, height, depth, volume(부피) : BoxOrRect b = new BoxOrRect(2,3,3);
// 메소드 : carVolume(), infoPrint(), infoString()
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;
	public BoxOrRect() {}
	
	public BoxOrRect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		calVolume();
		// volume setting
	}
	
	public BoxOrRect(int width, int height, int depth) {
		super();
		this.width = width;
		this.height = height;
		this.depth = depth;
		calVolume();
		// volume setting
	}
	
	private void calVolume() {
		if(depth == 0) {
			volume = width*height;
		}else {
			volume = width*height*depth;
		}
	}
	
	public void infoPrint() {
		if(depth==0) {
			System.out.printf("사각형 - 가로: %d, 세로: %d, 넓이: %d", width, height, volume);
		}else {
			System.out.printf("직육면체 - 가로: %d, 세로: %d, 깊이: %d, 부피: %d\n", width, height, depth, volume);
		}
	}
	
	public String infostring() {
		if(depth==0){
			return String.format("사각형 - 가로: %d, 세로: %d, 넓이: %d", width, height, volume);
		}else {
			return String.format("직육면체 - 가로: %d, 세로: %d, 깊이: %d, 부피: %d", width, height, depth, volume);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		calVolume();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		calVolume();
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		calVolume();
	}

	public int getVolume() {
		return volume;
	}

	
	
}
