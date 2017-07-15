/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import kratosbot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author aashutosh
 */
public class PingCommand implements Command{
    
    private final String HELP="USAGE: ~!ping";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("PONG").complete();
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
    
}
