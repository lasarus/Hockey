package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class AttackerLeft extends Player {

    private int index;
    private String name;

    public AttackerLeft(int index, String name) {
        this.index = index;
        this.name = name;
    }
    public int getNumber() { return Pucko.numbers[index]; }
    public String getName() { return name; }
    public boolean isLeftHanded() { return false; }
    public void step() {
        setAimOnStick(true);
        if (hasPuck()) { // If this player has the puck
            if(getX()<1000) {
                skate(2000, -2000, MAX_SPEED); // Go for the edge
            }
            else if(getX()<0){
                skate(2630, -100, MAX_SPEED);
            }
            else
                shoot(2600, -91, MAX_SHOT_SPEED);
        }
        else { // If doesn't have puck
            if(getX()>-500 && getY()>-100){ // and is in zone of play
                skate(getPuck(), MAX_SPEED); // Go for the puck
            }

            else if (true) {
                skate(getPuck().getX()+100,getPuck().getY()+100,(MAX_SPEED/2)); //Stay in good pos
            }
        }
    }
}