package p2;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapView extends JLabel {
    private double x1, y1, x2, y2;
    private ArrayList<Road> roadsToShow = new ArrayList<Road>();

    public MapView(String mapfile, double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setIcon(new ImageIcon(mapfile));
    }

    public void showRoads(ArrayList<Road> roads) {
        roadsToShow = roads;
        repaint();
    }

    private int mapX(double x) {
        return (int) (((x - x1) / (x2 - x1)) * getWidth());
    }

    private int mapY(double y) {
        return (int) (((y - y1) / (y2 - y1)) * getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ArrayList<Position> path;
        Road road;
        for (int i = 0; i < roadsToShow.size(); i++) {
            road = roadsToShow.get(i);
            path = road.getPath();
            for(int j=0; j<path.size()-1; j++) {
                g2.setStroke(new BasicStroke(3));
                g2.setColor(Color.RED);
                g2.drawLine(mapX(path.get(j).getLongitude()), mapY(path.get(j).getLatitude()),
                            mapX(path.get(j+1).getLongitude()), mapY(path.get(j+1).getLatitude()));
            }
        }
    }

}