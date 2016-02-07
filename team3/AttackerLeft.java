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
    int a=0;
    public void step() {
        setAimOnStick(true);
        if (hasPuck()) { // If this player has the puck
            ++a;
            turn(2600, 91, MAX_TURN_SPEED);

            if(a>2){
                shoot(2600, -91, MAX_SHOT_SPEED);
            }   
        }
        else { // If doesn't have puck
            if(getX()>-5000 && getY()>-1000){ // and is in zone of play
                skate(getPuck(), MAX_SPEED); // Go for the puck
            }

            else if (getPuck().getX()>860) {
                skate(getPuck().getX()+1000,getPuck().getY()-450,100); //Stay in good pos
            }

            else if(true) {
                skate(getPuck().getX()-10,getPuck().getY()-450,100); //Stay in good pos
            }
         }
    }
}