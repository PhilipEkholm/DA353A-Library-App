package collections;
import javax.swing.*;
import java.awt.*;

public class ShowAVL<K,V> extends JLabel {
    private AVLNode<K,V> node;
    
    public ShowAVL( AVLNode<K,V> node, int width, int height ) {
        this.node = node;
        this.setPreferredSize( new Dimension( width, height ) ); // beräknas avseende djup
    }
    
    public void setNode( AVLNode<K,V> node ) {
        this.node = node;
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(node!=null) {
            int levels = node.height()+1;
            if(levels > 0) {
                int width = (this.getWidth()-40)/(int)Math.pow(2,levels-1);
                int height = this.getHeight()/levels;
                int x = this.getWidth()/2 - width/2;
                showNodes(g,node,1,x,0,width,height,(this.getWidth()-40)/4,x+width/2);
            }
        }
    }
    
    public void showNodes(Graphics g, AVLNode<K,V> node, int level, int x, int y, int width, int height, int dx, int lineX) {
        if(node!=null) {
            showNodes(g,node.left,level+1,x-dx,y+height,width,height,dx/2,x+width/2);
            showNode( g, node, x+width/8 ,y+height/8 ,width-width/4 ,height-height/4 );
            if(level>1) {
                g.drawLine(x+width/2,y+height/8,lineX,y-height/8);
            }
            showNodes(g,node.right,level+1,x+dx,y+height,width,height,dx/2,x+width/2);
        }
    }
    
    public void showNode(Graphics g, AVLNode<K,V> node, int x, int y, int width, int height) {
        g.setFont(new Font("SansSerif",Font.BOLD,12));
        g.setColor(Color.cyan);
        g.fillRect(x,y,width,height);
        g.setColor(Color.black);
        g.drawRect(x,y,width,height);
        g.drawString(node.key.toString()+","+node.height(),x+4,y+height/2+4);
    }
}
