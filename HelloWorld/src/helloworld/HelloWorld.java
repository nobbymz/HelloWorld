/***
 * Excerpted from "Learn to Program with Minecraft Plugins, CanaryMod Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/ahmine2 for more book information.
***/

package helloworld;

import net.canarymod.Canary;
import net.canarymod.chat.MessageReceiver;
import net.canarymod.commandsys.Command;
import net.canarymod.commandsys.CommandDependencyException;
import net.canarymod.commandsys.CommandListener;
import net.canarymod.logger.Logman;
import net.canarymod.plugin.Plugin;

public class HelloWorld extends Plugin implements CommandListener {

	public static Logman logger;
	
	public HelloWorld() { 
	    logger = getLogman();
	  }
	
	  @Override	
	  public boolean enable() { 
		    logger.info("Starting up");   
		    try {
		      Canary.commands().registerCommands(this, this, false);
		    } catch (CommandDependencyException e) {
		      logger.error("Duplicate command name");
		    }
		    return true;
		  }
	  
	  @Override
	  public void disable() {
	  } 

	  @Command(aliases = { "hello" },
	            description = "Displays the hello world message.",
	            permissions = { "" },
	            toolTip = "/hello")
	  public void helloCommand(MessageReceiver caller, String[] parameters) {
	    String msg = "That'sss a very niccce EVERYTHING you have there...";
	    Canary.instance();
	    Canary.getServer().broadcastMessage(msg);
	  }
}
