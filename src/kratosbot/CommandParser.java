/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kratosbot;

import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author aashutosh
 */
public class CommandParser {
    public CommandContainer parse(String rw, MessageReceivedEvent e){
        ArrayList<String> split = new ArrayList<String>();
        String raw = rw;
        String beheaded = raw.replaceFirst("~!", "");
        String[] splitbeheaded = beheaded.split(" ");
        for(String s: splitbeheaded){split.add(s);}
        String invoke= split.get(0);
        String[] args= new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);
        
        return new CommandContainer(raw, beheaded, splitbeheaded, invoke, args,e);
    }
    public class CommandContainer{
        public final String raw;
        public final String beheaded;
        public final String[] splitbeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;
        
        public CommandContainer(String rw, String beheaded, String[] splitbeheaded, String invoke,String[] args, MessageReceivedEvent event){
        
        this.raw=rw;
        this.beheaded=beheaded;
        this.splitbeheaded= splitbeheaded;
        this.invoke= invoke;
        this.args= args;
        this.event= event;
        }
    }
}
