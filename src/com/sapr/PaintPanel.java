package com.sapr;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

//Посоны, недописано и непротестировано =( Строго не судите =) Гриша

public class PaintPanel extends JPanel {
    public static int x_centr, y_centr; //центр панели для рисования. относительно этих точек будет рисоватся модель
    public double mxy = 1; //масштабирование модели
	public static Model m = Gui.getModel();

    protected void paintComponent(Graphics g) { //хз, прокатит ли с 2 параметрами
        super.paintComponent(g);
        x_centr = this.getWidth() / 2;
        y_centr = this.getHeight() / 2;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

//	    тестовая отрисовочка
	    g2d.drawLine(m.details[0].x[0]*10, m.details[0].y[0]*10, m.details[0].x[1]*10, m.details[0].y[1]*10);
	    g2d.drawLine(0, y_centr, this.getWidth(), y_centr);
	    g2d.drawLine(x_centr, 0, x_centr, this.getHeight());

//        for(int i = 0; i < m.numDetails; i++) {
//            for(int j = 0; j <= m.details[i].numPoints; j++) {
//                if(j != m.details[i].numPoints) {
//                    g2d.drawLine(m.details[i].x[j], m.details[i].y[j], m.details[i].x[j+1], m.details[i].y[j+1]);
//                } else
//                {
//
//                }
//            }
//        }
    }
}
