package p2;
import java.util.ArrayList;

public class Road {
    private String from;
    private String to;
    private int cost;
    private ArrayList<Position> path;

    public Road(String from, String to, int cost, ArrayList<Position> path) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        this.path = path;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getCost() {
        return this.cost;
    }
    
    public ArrayList<Position> getPath() {
    	return this.path;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString() {
        return this.from + " - " + this.to + ": " + this.cost;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Road) && from.equals(((Road) obj).getFrom())
                && to.equals(((Road) obj).getTo());
    }
}
