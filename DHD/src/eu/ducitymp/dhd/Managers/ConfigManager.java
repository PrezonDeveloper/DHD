package eu.ducitymp.dhd.Managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class ConfigManager { 
	
    private ConfigManager(){ 
    }
   
    static ConfigManager instance = new ConfigManager();
   
    public static ConfigManager getInstance() {
            return instance;
    }
   
    Plugin p;
   
    FileConfiguration playerdata;
    File playerdatafile;
    
    FileConfiguration config;
    File cfile;
    
            public void setup(Plugin p) {
                cfile = new File(p.getDataFolder(), "config.yml");
                config = p.getConfig();
                config.options().copyDefaults(true);
                saveConfig();
               
                if (!p.getDataFolder().exists()) {
                        p.getDataFolder().mkdir();
                }
                
              //===============================//
                
                playerdatafile = new File(p.getDataFolder(), "playerdata.yml");
                
                if (!playerdatafile.exists()) {
                        try {
                        	playerdatafile.createNewFile();
                        }
                        catch (IOException e) {
                                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create playerdata.yml!");
                        }
                }
               
                playerdata = YamlConfiguration.loadConfiguration(playerdatafile);
           
               }

   
            public FileConfiguration getPlayerData() {
                return playerdata;
        }
       
        public void savePlayerData() {
                try {
                	playerdata.save(playerdatafile);
                }
                catch (IOException e) {
                        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save playerdata.yml!");
                }
        }
       
        public void reloadPlayerData() {
        	playerdata = YamlConfiguration.loadConfiguration(playerdatafile);
        }
            
      //===============================//  
        
    
public FileConfiguration getConfig() {
        return config;
}

public void saveConfig() {
        try {
                config.save(cfile);
        }
        catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
        }
}

public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(cfile);
}

public PluginDescriptionFile getDesc() {
        return p.getDescription();
}
}