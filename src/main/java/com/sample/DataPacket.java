package com.sample;

public class DataPacket {
	private static char category;
	private static double gauss;
	private static int random;
	private static int random2;
	private static int random3;
	private static int random4;
	
	public DataPacket(
			char category, double gauss, int random, 
			int random2, int random3, int random4){
		this.setCategory(category);
		this.setGauss(gauss);
		this.setRandom(random);
		this.setRandom2(random2);
		this.setRandom3(random3);
		this.setRandom4(random4);
	}
	
	public char getCategory(){
		return category;
	}
	
	public void setCategory(char category){
		DataPacket.category = category;
	}
	
	public double getGauss(){
		return gauss;
	}
	
	public void setGauss(double gauss){
		DataPacket.gauss = gauss;
	}
	
	public int getRandom(){
		return random;
	}
	
	public void setRandom(int random){
		DataPacket.random = random;
	}
	
	public int getRandom2() {
		return random2;
	}

	public void setRandom2(int random2) {
		DataPacket.random2 = random2;
	}

	public int getRandom3() {
		return random3;
	}

	public void setRandom3(int random3) {
		DataPacket.random3 = random3;
	}

	public int getRandom4() {
		return random4;
	}

	public void setRandom4(int random4) {
		DataPacket.random4 = random4;
	}
	

	public String toString(){
		return String.join(",", 
			String.valueOf(DataPacket.category), 
			String.valueOf(DataPacket.gauss),
			String.valueOf(DataPacket.random),
			String.valueOf(DataPacket.random2),
			String.valueOf(DataPacket.random3),
			String.valueOf(DataPacket.random4)
				
			) ;
			
	}
	
}
