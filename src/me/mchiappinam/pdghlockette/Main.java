package me.mchiappinam.pdghlockette;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2iniciando...");
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2registrando eventos...");
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2ativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2Acesse: https://hostload.com.br/");
	}
	    
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2desativado - Developed by mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2Acesse: http://pdgh.com.br/");
		getServer().getConsoleSender().sendMessage("§3[PDGHLockette] §2Acesse: https://hostload.com.br/");
	}
    
    public static String calendario(String dateFormat) {
		Calendar agora = Calendar.getInstance();
		SimpleDateFormat gdf = new SimpleDateFormat(dateFormat);
        return gdf.format(agora.getTime());
    }

    public void log(Block p, String mensagem) {
        try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(getDataFolder()+File.separator+"log.txt", true)));
            out.println("DIA: "+calendario("dd/MM/yyyy")+" HORAS: "+calendario("HH:mm:ss.SSS")+" - loc: "+p.getLocation().getBlockX()+","+p.getLocation().getBlockY()+","+p.getLocation().getBlockZ()+" - "+mensagem);
		    out.close();
		    for(Player stf : getServer().getOnlinePlayers())
		    	if(stf.hasPermission("pdgh.moderador")) {
		    		stf.sendMessage(" ");
		    		stf.sendMessage(" ");
		    		stf.sendMessage("§c§l[PDGHLockette] §cEncontramos uma placa:");
		    		stf.sendMessage("loc: "+p.getLocation().getBlockX()+","+p.getLocation().getBlockY()+","+p.getLocation().getBlockZ()+" - "+mensagem);
		    		stf.sendMessage(" ");
		    		stf.sendMessage(" ");
		    	}
        } catch (IOException ex) {
        	getLogger().warning("Erro ao salvar as informações na log. Mensagem do servidor: "+ex.getMessage());
        }
    }
}
