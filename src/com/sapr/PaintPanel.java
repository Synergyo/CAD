package com.sapr;

import javax.swing.*;
import java.awt.*;

//Посоны, недописано и непротестировано =( Строго не судите =) Гриша

public class PaintPanel extends JPanel {
    public static int x_centr, y_centr; //центр панели для рисования. относительно этих точек будет рисоватся модель
    public double mxy = 1; //масштабирование модели

    protected void paintComponent(Graphics g, Model m) { //хз, прокатит ли с 2 параметрами
        super.paintComponent(g);
        x_centr = this.getWidth() / 2;
        y_centr = this.getHeight() / 2;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        for(int i = 0; i < m.numDetails; i++) {
            for(int j = 0; j <= m.details[i].numPoints; j++) {
                if(j != m.details[i].numPoints) {
                    g2d.drawLine(m.details[i].x[j], m.details[i].y[j], m.details[i].x[j+1], m.details[i].y[j+1]);
                } else
                {

                }
            }
        }
    }
}
