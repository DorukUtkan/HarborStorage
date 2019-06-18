package de.tuhh.diss.harborstorage;
import de.tuhh.diss.harborstorage.sim.HighBayStorage;
import de.tuhh.diss.harborstorage.sim.PhysicalHarborStorage;
import de.tuhh.diss.harborstorage.sim.StorageException;


public class HarborStorageManagement implements HighBayStorage {
	
	private int storedPacketID=-1;
	private Slot[] slots;
	private Packet[] packets;
    private	PhysicalHarborStorage physicalHarborStorage;
    private CraneControl craneControl;
	public HarborStorageManagement(){
		physicalHarborStorage= new PhysicalHarborStorage();
		craneControl=new CraneControl(physicalHarborStorage.getCrane());
		
	}

	public int storePacket(int width, int height, int depth, String description, int weight) throws StorageException {
		Packet packet=new Packet (description,width,height,depth,weight);
		int slotNumber = findSuitableSlot(packet);
		craneControl.storePacket(slots[slotNumber].getPositionX(), slots[slotNumber].getPositionY(), packet);
		storedPacketID++;
		return storedPacketID; 
		
	}
	
	public void retrievePacket(String description) throws StorageException {
		int slotNumber=findWhichSlotHasThisPacket();
		craneControl.retrievePacket(slots[slotNumber].getPositionX(), slots[slotNumber].getPositionY());
	} 
	
	public Packet[] getPackets() {
		return null; 
	}
	
	public void shutdown() {
		craneControl.shutdown();
	}
	
	public Slot[] synchronize(){
		
		slots=new Slot[physicalHarborStorage.getStoragePlacesAsArray().length];
		for (int i=0; i<physicalHarborStorage.getStoragePlacesAsArray().length ; i++){
			slots[i]=new Slot(physicalHarborStorage.getStoragePlacesAsArray()[i].getNumber(),physicalHarborStorage.getStoragePlacesAsArray()[i].getHeight(),physicalHarborStorage.getStoragePlacesAsArray()[i].getWidth(),physicalHarborStorage.getStoragePlacesAsArray()[i].getDepth(),physicalHarborStorage.getStoragePlacesAsArray()[i].getLoadCapacity(),physicalHarborStorage.getStoragePlacesAsArray()[i].getPositionX(),physicalHarborStorage.getStoragePlacesAsArray()[i].getPositionY());
		}
		return slots;
	} 
}
