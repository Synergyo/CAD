package com.sapr;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Григорий on 25.09.2014.
 */
public class DetailBox extends JButton {
    public int detNum = 0; //номер детали, которая будет отрисована на кнопке
    public int mxy = 3;
    public static Model m = Gui.getModel();
    private int x_centr, y_centr;

    DetailBox(int detNum) {
        super();
        this.detNum = detNum;
        setSize(new Dimension(120, 120));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        x_centr = this.getWidth() / 2;
        y_centr = this.getHeight() / 2;
        this.setBackground(Color.WHITE);
        g2d.setColor(Color.BLACK);

        for(int j = 0; j < m.details[detNum].numPoints; j++) {
            if(j != m.details[detNum].numPoints-1) {
                g2d.drawLine(x_centr + m.details[detNum].x[j]*mxy, y_centr - m.details[detNum].y[j]*mxy, x_centr + m.details[detNum].x[j+1]*mxy, y_centr - m.details[detNum].y[j+1]*mxy);
            } else
            {
                g2d.drawLine(x_centr + m.details[detNum].x[j]*mxy, y_centr - m.details[detNum].y[j]*mxy, x_centr + m.details[detNum].x[0]*mxy, y_centr - m.details[detNum].y[0]*mxy);
            }
        }
    }
}
