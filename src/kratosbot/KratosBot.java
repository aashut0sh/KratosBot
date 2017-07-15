/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kratosbot;

import Commands.PingCommand;
import java.util.HashMap;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author aashutosh
 */
public class KratosBot {

    private static JDA jda;
    public static final CommandParser parser = new CommandParser();
    public static HashMap<String, Command> commands = new HashMap<String, Command>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            jda = new JDABuilder(AccountType.BOT).addEventListener(new BotListener()).setToken("MzM1NzM3MDM5MTM3OTMxMjY0.DEuKiw.ZyvJZL7baByCA0ZBKd4DITvMqUY").buildBlocking();;
            jda.setAutoReconnect(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        commands.put("ping", new PingCommand());
        commands.put("hello", new HelloCommand());
    }
    public static void handleCommand(CommandParser.CommandContainer cmd){
        if(commands.containsKey(cmd.invoke)){
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
        if(safe){
            commands.get(cmd.invoke).action(cmd.args, cmd.event);
            commands.get(cmd.invoke).executed(safe, cmd.event);
        }
        else{
            commands.get(cmd.invoke).executed(safe, cmd.event);
        }
        }
        
    };
    
}
