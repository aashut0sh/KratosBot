/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kratosbot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author aashutosh
 */
public class HelloCommand implements Command{
    private final String HELP="USAGE: ~!hello";
    private final String msg="Hello, I am a bot. My name is Kratos! You may have heard about me from the video game God Of War"
            + ". But here i am as a bot made by @aashutoshrestha. Currently i am in early stages so i can't"
            + " perform much actions. Thank You!";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(msg).complete();
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
