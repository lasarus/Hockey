package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Goalie extends GoalKeeper {
    public int getNumber() { return 1; }
    public String getName() { return "Golle"; }
    public boolean isLeftHanded() { return false; }
    public void step() {

        int puckY = getPuck().getY();

        int max = 50;

        if (getPuck().getSpeed() > 700) {
            max = 45;
        }

        if (puckY > max) {
            puckY = max;
        } else if (puckY < (max * -1)) {
            puckY = -1 * max;
        }

        if (getPuck().getSpeed() > 1000) {
            if (getPuck().getX() < 0) {
                skate(-2550, puckY, 300);
            } else {
                skate(-2550, puckY, 200);
            }
        } else {
            skate(-2550, puckY, 50);
        }


        int pX = getPuck().getX();
        if (pX < -2550) {
            pX = -2550;
        };

        turn(pX, getPuck().getY(), MAX_TURN_SPEED);

        if (hasPuck()) {
            shoot(700, 1300, MAX_SHOT_SPEED);
        }
    }
}

