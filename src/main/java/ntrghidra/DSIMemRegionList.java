/*
* NDSIMemRegionList.java
* Definition of DSIMemRegionList class and
* list of these memory regions. These are
* DSi only memory regions !!!
*
* Pedro Javier Fernández
* 12/06/2022 (DD/MM/YYYY)
*
* See project license file for license information.
*/ 

package ntrghidra;

import java.util.ArrayList;
import java.util.List;

public class DSIMemRegionList {

	//This internal class represents a memory region.
		public class DSIMemRegion {
		    String name;
		    int addr;
		    long size;
		    boolean read;
		    boolean write;
		    boolean execute;
		    public DSIMemRegion(String name, int addr, int size, boolean read, boolean write, boolean execute) {
		            this.name = name;
		            this.addr = addr;
		            this.size = size;
		            this.read = read;
		            this.write = write;
		            this.execute = execute;
		    }
		    public String name() {return name;}
		    public int addr() {return addr;}
		    public long size() {return size;}
		    public boolean read() {return read;}
		    public boolean write() {return write;}
		    public boolean execute() {return execute;}
		}
		
		//This class uses a singleton pattern
		private static DSIMemRegionList _instance = null;
		private static List<DSIMemRegion> _ARM9iregions = new ArrayList<DSIMemRegion>();
		private static List<DSIMemRegion> _ARM7iregions = new ArrayList<DSIMemRegion>();
		
		private DSIMemRegionList()
		{	
			//ARM9
			_ARM9iregions.add(new DSIMemRegion("Shared WRAM",0x03000000,0x000C8000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("ARM9 I/O Ports",0x04000000,0x01000000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("Standard Palettes",0x05000000,0x01000000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("VRAM - Engine A BG VRAM",0x06000000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("VRAM - Engine B BG VRAM",0x06200000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("VRAM - Engine A OBJ VRAM",0x06400000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("VRAM - Engine B OBJ VRAM",0x06600000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("VRAM - LCDC",0x06800000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("New DSi I/O Ports",0x4004000,0x00200000,true,false,false));
			_ARM9iregions.add(new DSIMemRegion("Fake GBA Slot",0x8000000,0x00200000,true,false,false));
			
			//ARM7 
			_ARM7iregions.add(new DSIMemRegion("ARM7 BIOS ",0x00000000,0x00010000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("Shared WRAM",0x03000000,0x000C8000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("ARM7 WRAM (Private memory?)",0x03800000,0x00200000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("ARM7 I/O Ports",0x04000000,0x00800000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("Wireless Communications Wait State 0 (8KB RAM at 4804000h)",0x04800000,0x00008000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("Wireless Communications Wait State 1 (I/O Ports at 4808000h)",0x04808000,0x00200000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("VRAM allocated as Work RAM to ARM7 (max 256K)",0x06000000,0x0040000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("GBA Slot ROM (max 32MB)",0x06600000,0x02000000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("GBA Slot RAM (max 64KB)",0x0A000000,0x00010000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("New DSi I/O Ports",0x4004000,0x00200000,true,false,false));
			_ARM7iregions.add(new DSIMemRegion("Fake GBA Slot",0x8000000,0x00200000,true,false,false));
		}
		
		public static DSIMemRegionList getInstance()
		{
			if(_instance==null)
				_instance=new DSIMemRegionList();
			
			return _instance;
		}
		
		public List<DSIMemRegion> getARM9iRegions()
		{
			return _ARM9iregions;
		}
		
		public List<DSIMemRegion> getARM7iRegions()
		{
			return _ARM7iregions;
		}
	
}
