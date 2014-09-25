package com.sapr;

import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JPanel {
    public static int x_centr, y_centr; //центр панели для рисования. относительно этих точек будет рисоватся модель
    public int mxy = 10; //масштабирование модели
	public static Model m = Gui.getModel();

    protected void paintComponent(Graphics g) { //хз, прокатит ли с 2 параметрами
        super.paintComponent(g);
        x_centr = this.getWidth() / 2;
        y_centr = this.getHeight() / 2;
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(Color.WHITE);
        g2d.setColor(Color.BLACK);

//	    тестовая отрисовочка
/*	    g2d.drawLine(m.details[0].x[0]*10, m.details[0].y[0]*10, m.details[0].x[1]*10, m.details[0].y[1]*10);
	    g2d.drawLine(0, y_centr, this.getWidth(), y_centr);
	    g2d.drawLine(x_centr, 0, x_centr, this.getHeight());*/

        for(int i = 0; i < m.numDetails; i++) {
            for(int j = 0; j < m.details[i].numPoints; j++) {
                if(j != m.details[i].numPoints-1) {
                    g2d.drawLine(x_centr + m.details[i].x[j]*mxy, y_centr - m.details[i].y[j]*mxy, x_centr + m.details[i].x[j+1]*mxy, y_centr - m.details[i].y[j+1]*mxy);
                } else
                {
                    g2d.drawLine(x_centr + m.details[i].x[j]*mxy, y_centr - m.details[i].y[j]*mxy, x_centr + m.details[i].x[0]*mxy, y_centr - m.details[i].y[0]*mxy);
                }
            }
        }
    }
}
