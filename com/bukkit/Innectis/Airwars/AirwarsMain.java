package com.bukkit.Innectis.Airwars;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;

import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Innectis Airwars plugin class
 *
 * Features:
 *   Accelerators: place rails on Obsidian.
 *
 * @author Innectis
 */
public class AirwarsMain extends JavaPlugin
{
	private final static Logger logger = Logger.getLogger("Minecraft");
	private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

	public AirwarsMain(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader)
	{
		super(pluginLoader, instance, desc, folder, plugin, cLoader);
	}

	public void onEnable()
	{
		// Register events
		PluginManager pm = getServer().getPluginManager();

		// Say hi
		PluginDescriptionFile pdfFile = this.getDescription();
		log(pdfFile.getName() + " v" + pdfFile.getVersion() + " enabled");
	}

	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		log(pdfFile.getName() + " v" + pdfFile.getVersion() + " disabled");
	}

	public void log(String text)
	{
		logger.log(Level.INFO, text);
	}

	public void logWarning(String text)
	{
		logger.log(Level.WARNING, text);
	}

	public boolean isDebugging(final Player player)
	{
		if (debugees.containsKey(player)) {
			return debugees.get(player);
		} else {
			return false;
		}
	}

	public void setDebugging(final Player player, final boolean value)
	{
		debugees.put(player, value);
	}
}
