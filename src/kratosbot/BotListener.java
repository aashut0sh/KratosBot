/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kratosbot;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 *
 * @author aashutosh
 */
public class BotListener extends ListenerAdapter{
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith("~!") && event.getMessage().getAuthor().getId() !=event.getJDA().getSelfUser().getId()) KratosBot.handleCommand(KratosBot.parser.parse(event.getMessage().getContent().toLowerCase(), event));
            
    }
    
    @Override
    public void onReady(ReadyEvent event){
    
    //KratosBot.log("status", "Logged in as: "+ event.getJDA().getSelfUser().getName());
    }
    
}
