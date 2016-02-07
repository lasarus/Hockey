package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;
import hockey.api.Util;
import java.lang.Math;

public class Defender extends Player {

    private int index;
    private String name;
    private boolean attack = false;

    public Defender(int index, String name) {
        this.index = index;
        this.name = name;
    }
    public int getNumber() { return Pucko.numbers[index]; }
    public String getName() { return name; }
    public boolean isLeftHanded() { return false; }

    public void step() {

	int targetX = -500;
	int targetY = 700;

	if(attack) {
	    if(getPuck().getSpeed() > 600) {
		attack = false;
	    }
	    else {
		skate(getPuck(), 1000);
	    }
	}
	else if(getPuck().getSpeed() < 50 &&
		getPuck().isHeld() &&
		Util.dist(getX() - getPuck().getX(), getY() - getPuck().getY()) > 1000) {
		    attack = true;
	}

	if(hasPuck()) {
	    if(getX() * getX() < 100) {
		shoot(2600, 0, 1000);
	    }
	    else {
		skate(0, 0, 1000);
	    }
	}
	else {
	    if(getPuck().getX() < 0) {
		skate(getPuck(), 1000);
	    }
	    else {
		int dist = (int)Util.dist(getX() - targetX, getY() - targetY);
		if(dist > 300)
		    {
		    }
		if(index % 2 == 0) {
		    skate(-500, 700, dist);
		}
		else {
		    skate(-500, -700, dist);
		}
	    }
	}
    }
}
