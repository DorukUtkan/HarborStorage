package de.tuhh.diss.harborstorage;

import de.tuhh.diss.harborstorage.sim.PhysicalCrane;
import de.tuhh.diss.harborstorage.sim.StorageElement;

public class CraneControl {
	
	private PhysicalCrane crane;
	public CraneControl (PhysicalCrane cr){
		crane=cr;
	}
	
	public void storePacket(int x, int y, StorageElement packet) {
		moveToX(crane.getLoadingPosX());
		moveToY(crane.getLoadingPosY());
		crane.loadElement(packet);
		moveToX(x);
		moveToY(y);
		crane.storeElement();
	}
	
	public StorageElement retrievePacket(int x, int y) {
		moveToX(x);
		moveToY(y);
		crane.retrieveElement();
		moveToX(crane.getLoadingPosX());
		moveToY(crane.getLoadingPosY());
		return crane.unloadElement();
	}
	
	public void shutdown() {
		crane.shutdown();
	}
	
	private void moveToX(int x) {
		
		if(x!=crane.getPositionX()){
			do{
				crane.start();
				if (x>crane.getPositionX()){
					do{
						crane.backward();
					}while(x>crane.getPositionX());
				}
				else if (x<crane.getPositionX()){
					do{
						crane.forward();
					}while(x<crane.getPositionX());
				}
			}while(x!=crane.getPositionX());
			crane.stopX();
		}
	}
	
	private void moveToY(int y) {
		if(y!=crane.getPositionY()){
			do{
				crane.start();
				if (y>crane.getPositionY()){
					do{
						crane.down();
					}while(y>crane.getPositionY());
				}
				else if (y<crane.getPositionY()){
					do{
						crane.up();
					}while(y<crane.getPositionY());
				}
			}while(y!=crane.getPositionY());
			crane.stopY();
		}	
	}
	
	
	
	
	
}
