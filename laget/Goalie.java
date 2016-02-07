package laget;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Goalie extends GoalKeeper {
    public int getNumber() { return 1; }
    public String getName() { return "Herbert"; }
    public boolean isLeftHanded() { return false; }
    public void step() {
        skate(-2550, 0, 200); // Stand in middle of goal 1/2 m in front of it.
        turn(getPuck(), MAX_TURN_SPEED); // Turn against puck
    }
}

