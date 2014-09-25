package com.sapr;

import javax.swing.*;
import java.awt.*;

/**
 * Панель для деталей, справа от основной для рисования
 */
public class DetailPanel extends JPanel {

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

        //this.setBackground(Color.WHITE);
		//g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
	}

}
