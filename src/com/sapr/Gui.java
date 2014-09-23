package com.sapr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Vlad Rozhenko on 17.09.2014.
 */

//Trying to make some interface. Alekov
    


public class Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        //Model model = new Model("D:\\IDEA Workspace\\CAD\\file.dgt");
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        setLayout(new BorderLayout());

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setTitle("Some name of our project");

        //tabs--------------------------------------

        JPanel first_panel = new JPanel();
        first_panel.setLayout(new GridLayout(2,2));

        JPanel second_panel = new JPanel();
        second_panel.setLayout(new GridLayout(2,2));

        JTabbedPane tab_panel = new JTabbedPane();
        add(tab_panel, BorderLayout.CENTER);

        tab_panel.addTab("Panel 1", first_panel);
        tab_panel.addTab("Panel 2", second_panel);

        //tabs--------------------------------------

        //menu--------------------------------------

        JMenuBar menu_bar = new JMenuBar();
        add(menu_bar, BorderLayout.NORTH);

        JMenu menu = new JMenu("Menu");

        //menu.addSeparator();
        //menu.addSeparator();
        //menu.addSeparator();

        JMenu sub_menu = new JMenu("Items");

        JMenuItem menuItem_1 = new JMenuItem("Item 1");
        sub_menu.add(menuItem_1);
        sub_menu.addSeparator();

        JMenuItem menuItem_2 = new JMenuItem("Item 2");
        sub_menu.add(menuItem_2);
        sub_menu.addSeparator();

        JMenuItem menuItem_3 = new JMenuItem("Item 2");
        sub_menu.add(menuItem_3);

        menu.add(sub_menu);

        menu_bar.add(menu);

        //menu--------------------------------------


	}

}
