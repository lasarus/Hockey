package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;
import hockey.api.Util;
import java.lang.Math;
import java.util.Random;
import java.util.Base64;

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
    public boolean isLeftHanded() { return index % 2 == 0; }

    public void step() {

	int targetX = -1500;
	int targetY = 700;

	moveStick(45, 100);

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
		int speed = 0;
		if(dist > 300) {
		    speed = 1000;
		}
		else if(dist > 150) {
		    speed = 200;
		}
		else if(dist > 100) {
		    speed = 50;
		}
		else {
		    speed = 0;
		}
		if(index % 2 == 0) {
		    skate(targetX, targetY, speed);
		}
		else {
		    skate(targetX, -targetY, speed);
		}
	    }
	}
    }
}
