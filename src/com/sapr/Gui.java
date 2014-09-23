package com.sapr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Vlad Rozhenko on 17.09.2014.
 */

//Trying to make some interface. Alekov
//Grisha heranyl LookAndFeel =)
    


public class Gui extends JFrame {

	private JPanel contentPane;
    private Model model; //хз, может не тут стоит объявлять? чё скажете, посоны? (Гриша)

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

        //Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (UnsupportedLookAndFeelException e2) {
            e2.printStackTrace();
        }
        //Look and Feel

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

        JMenu menu = new JMenu("File");

        JMenuItem menuItem_1 = new JMenuItem("Open");

        menuItem_1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                //открываем диалогвое окно с выбором файла, читаем файл и заносим информацию в объект model
                JFileChooser fc = new JFileChooser();

                if(fc.showOpenDialog(Gui.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();

                    try {
                        model = new Model(file.getAbsolutePath());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        menu.add(menuItem_1);

        //menu.addSeparator();
        //menu.addSeparator();
        //menu.addSeparator();

        /*JMenu sub_menu = new JMenu("Items");

        JMenuItem menuItem_1 = new JMenuItem("Item 1");
        sub_menu.add(menuItem_1);
        sub_menu.addSeparator();

        JMenuItem menuItem_2 = new JMenuItem("Item 2");
        sub_menu.add(menuItem_2);
        sub_menu.addSeparator();

        JMenuItem menuItem_3 = new JMenuItem("Item 3");
        sub_menu.add(menuItem_3);*/

        menu.add(menuItem_1);

        menu_bar.add(menu);

        //menu--------------------------------------

        //window listener---------------------------

        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent event) {

                Object[] options = { "Yes", "No" };
                int n = JOptionPane.showOptionDialog(event.getWindow(), "Quit the program?",
                        "Confirm action", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }

            }

            @Override
            public void windowClosed(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }
        });

        //window listener --------------------------------


	}

}
