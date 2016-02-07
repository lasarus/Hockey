package team3;

import java.awt.Color;
import hockey.api.GoalKeeper;
import hockey.api.Player;
import hockey.api.ITeam;

public class Pucko implements ITeam {

    public final static int[] numbers = {1, 2, 3, 4, 5, 6};
    public Goalie g;

    public String getShortName() { return "PCK"; }
    public String getTeamName() { return "Pucko"; }
    public Color getTeamColor() {
        return Color.RED;
    }
    public Color getSecondaryTeamColor() { return Color.RED; }
    public int getLuckyNumber() { return 4; }
    public GoalKeeper getGoalKeeper() {
        g = new Goalie();
        return g;
    }
    public Player getPlayer(int index) {

        switch (index) {
            case 1:
                return new AttackerLeft(index, "Atti");
            case 2:
                return new AttackerRight(index, "Atta");
            case 3:
                return new Defender(index, "Deffe");
            case 4:
                return new Defender(index, "Dafii");
            case 5:
                return new Center(index, "Centi");
            default:
                break;
        }
        return new Center(index, "FEL");
    }
}



