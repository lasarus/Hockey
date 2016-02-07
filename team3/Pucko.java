package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Pucko implements ITeam {

    public final static int[] numbers = {1, 2, 3, 4, 5, 6};

    public String getShortName() { return "JR"; }
    public String getTeamName() { return "Junior League"; }
    public Color getTeamColor() { return Color.BLUE; }
    public Color getSecondaryTeamColor() { return Color.RED; }
    public int getLuckyNumber() { return 13; }
    public GoalKeeper getGoalKeeper() { return new Goalie(); }
    public Player getPlayer(int index) {

        switch (index) {
            case 0:
                return new Center(index, "Centi");
            case 1:
                return new Attacker(index, "Atti");
            case 2:
                return new Attacker(index, "Atta");
            case 3:
                return new Defender(index, "Deffe");
            case 4:
                return new Defender(index, "Dafii");
            default:
                break;
        }
        return new Center(index, "Centi");
    }
}



