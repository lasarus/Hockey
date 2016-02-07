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

	setAimOnStick(true);

	if(hasPuck()) {
	    if(getX() * getX() < 100 || getX() > 200) {
		shoot(2600, 0, 1000);
	    }
	    else {
		skate(2600, 0, 1000);
	    }
	}
	else {
	    if(getPuck().getX() < -200 || getPuck().getX() > 300) {
		skate(getPuck(), 1000);
	    }
	    else {
		int dist = (int)Util.dist(getX() - targetX, getY() - targetY);
		int speed = 200;
		if(dist > 300) {
		    speed = 1000;
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
