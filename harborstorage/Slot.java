package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.StoragePlace;

public class Slot implements StoragePlace {	
	
	private int number;
	private int positionX;
	private int positionY ;
	private int width=2;
	private int height;
	private int depth;
	private int loadCapacity;
	private Packet containedPacket;
	
	public Slot (int ID, int height, int width, int depth, int loadCapacity, int x, int y) {
		number=ID;
		this.height=height;
		this.width=width;
		this.depth=depth;
		this.loadCapacity=loadCapacity;
		positionX=x;
		positionY=y;
	}
	
	
	public int getNumber() {
		return number; 
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
	public int getLoadCapacity() {
		return loadCapacity; 
	}
	public int getPositionX() {
		return positionX; 
	}
	
	public int getPositionY() {
		return positionY; 
	}
	
	public Packet getContainedPacket()  {
		return containedPacket;
	}
	
	public void setContainedPacket(Packet packet)  {
		containedPacket=packet; 
	}

}
