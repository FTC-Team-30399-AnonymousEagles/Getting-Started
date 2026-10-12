package org.firstinspires.ftc.teamcode.commands;

import org.firstinspires.ftc.teamcode.actions.Action;

import java.util.ArrayList;
import java.util.Collections;

public class CommandScheduler {
    ArrayList<CommandBase> Commands = new ArrayList<>();
    public CommandScheduler() {
    }
    public void run(){
        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i=0; i<Commands.size(); i++){
            Commands.get(i).execute();
            if (Commands.get(i).isFinished()){
                toRemove.add(i);
            }
        }
        Collections.reverse(toRemove);
        for (int action : toRemove){
            Commands.remove(action);
        }

    }
    public void schedule(CommandBase command){
        command.initialize();
        Commands.add(command);
    }
}