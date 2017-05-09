package com.sample;

public class DataPacket {
	private static char category;
	private static double gauss;
	private static int random;
	
	public DataPacket(char category, double gauss, int random){
		this.setCategory(category);
		this.setGauss(gauss);
		this.setRandom(random);
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
	
	public String toString(){
		return "TEST";
	}
	
}
