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
        if (puckY > 70) {
            puckY = 70;
        } else if (puckY < -70) {
            puckY = -70;
        }

        if (getPuck().getSpeed() > 1000) {
            skate(-2550, puckY, 200);
        } else {
            skate(-2550, puckY, 50);
        }

        turn(getPuck(), MAX_TURN_SPEED);

        if (hasPuck()) {
            shoot(700, 1300, 5000);
        }
    }
}

