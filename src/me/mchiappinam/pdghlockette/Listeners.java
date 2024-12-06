package me.mchiappinam.pdghlockette;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public class Listeners implements Listener {

	private Main plugin;
	public Listeners(Main main) {
		plugin=main;
	}

	@EventHandler
    public void onChunkLoad(ChunkLoadEvent event){
        Chunk chunk = event.getChunk();
        if(event.getWorld().getName().equalsIgnoreCase("plotworld")){
        for (int x = 0; x < 16; x++)
            for (int y = 0; y < 256; y++)
                for(int z = 0; z <16; z++){
                    Block block = chunk.getBlock(x, y, z);

                    if (block.getType().equals(Material.SIGN_POST) || block.getType().equals(Material.WALL_SIGN)) {
             
                        Sign sign = (Sign) block.getState();
             
                        if (sign.getLine(0).toLowerCase().equalsIgnoreCase("pdgh")) {
                        	plugin.log(block, sign.getLine(0)+","+sign.getLine(1)+","+sign.getLine(2)+","+sign.getLine(3));
                            sign.setLine(0, "O MC");
                            sign.setLine(1, "PASSOU");
                            sign.setLine(2, "POR AQUI");
                            sign.setLine(3, "beijos");
                            sign.update();
                        }
                    }
                }
            }
} 
}
