package vista;

import modelo.Territorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Panel extends JPanel {

    private Image worldMap = new ImageIcon(getClass().getResource("/imagenes/Risk3.png")).getImage();
    private ArrayList<Territorio> territoriosVista;


    public Panel(){

        this.setSize(801,498);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.territoriosVista = new ArrayList<Territorio>();
    }

    public void paint(Graphics g){

        g.drawImage(worldMap,0,0,null);


        for (Territorio t : this.territoriosVista) {

            int x = t.getX();
            int y = t.getY();

            if(t.getPertenece() == 'r'){
                g.setColor(Color.RED);
                g.fillOval(x,y,25,25);
                g.setColor(Color.white);
                g.drawString(String.valueOf(t.getSoldados()),x+8,y+17 );
            }
            else{
                g.setColor(Color.blue);
                g.fillOval(x,y,25,25);
                g.setColor(Color.white);
                g.drawString(String.valueOf(t.getSoldados()),x+8,y+17 );
            }


        }




    }

    public ArrayList<Territorio> getTerritoriosVista() {
        return territoriosVista;
    }

    public void setTerritoriosVista(ArrayList<Territorio> territoriosVista) {
        this.territoriosVista = territoriosVista;
    }
}
