package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.StorageElement;

public class Packet implements StorageElement{
	
	private int id;
	private int width;
	private int height;
	private int depth=2;
	private java.lang.String description;
	private int weight;
	private Slot location;
	
	public Packet (java.lang.String description, int width,int height, int depth, int weight){
		this.description=description;
		this.width=width;
		this.height=height;
		this.depth=depth;
		this.weight=weight;
	}
	
	public int getWidth() {
		return width; 
	}

	public int getHeight() {
		return height; 
	}

	public int getDepth() {
		return depth;  
	}

	public int getId() {
		return id;  
	}
	
	public java.lang.String getDescription() {
		return description;  
	}
	
	public int getWeight() {
		return weight; 
	}
	
	public Slot getLocation() {
		return location; 
	}
	
	public void setLocation(Slot location) {
		this.location=location;
	}
}
