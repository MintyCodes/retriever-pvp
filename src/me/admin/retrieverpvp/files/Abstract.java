package me.admin.retrieverpvp.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.admin.retrieverpvp.Core;

public class Abstract {
	
	protected Core core;
	private File file;
	protected FileConfiguration config;
	
	public Abstract(Core core, String fileName){
		this.core = core;
		this.file = new File(core.getDataFolder(), fileName);
		if(!(file.exists())){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		this.config = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public void save(){
		try {
			config.save(file);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
