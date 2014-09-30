package com.sapr;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created on 17.09.2014.
 */

public class Gui extends JFrame {

    private JPanel contentPane;
    private static Model model; //хз, может не тут стоит объявлять? чё скажете, посоны? (Гриша)
    private PaintPanel paintPanel;
    private static JScrollPane detail_scroll_panel;
    private static DetailPanel panel_1;
    private static DetailBox [] sideButtons;
    private static PaintPanel panel;

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
    }

    /**
     * Create the frame.
     */

    
    public Gui() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        setSize(new Dimension(1200,800)); //- это размер окна когда минимизируешь его, если это убрать то при
        // минимизации окно оно будет очень маленьким. Саня

//      1) не работает 2) 800 ширины както не кошерно, у Грифона ноут 1366х768 3) у меня 1920x1080, пусть луше фуллскрин остается
        //посоны, когда чатимся в комментах, давайте подписыватся)) а то хз кто коммент оставил)) Гриша

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

        JPanel second_panel = new JPanel();
        second_panel.setLayout(new GridLayout(2,2));

        final JTabbedPane tab_panel = new JTabbedPane();
        contentPane.add(tab_panel, BorderLayout.CENTER);

        final JPanel first_panel = new JPanel();
        tab_panel.addTab("Panel 1", null, first_panel, null);
        first_panel.setLayout(new BorderLayout(0, 0));

//		PaintPanel panel = new PaintPanel();
//		first_panel.add(panel, BorderLayout.CENTER);

        panel_1 = new DetailPanel();
        Dimension dim = new Dimension(120, panel_1.getHeight());
        panel_1.setPreferredSize(dim);
        first_panel.add(panel_1, BorderLayout.EAST);

        JPanel panel_2 = new JPanel();
        first_panel.add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Test");
        panel_2.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        panel_2.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        panel_2.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("New button");
        panel_2.add(btnNewButton_3);
        tab_panel.addTab("Panel 2", second_panel);

        //tabs--------------------------------------

        //scroll panels -------------------------------

        //Проверить работу скролл бара. Саня
        //detail_scroll_panel = new JScrollPane(panel_1);
        //detail_scroll_panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //first_panel.add(detail_scroll_panel, BorderLayout.EAST);

        //scroll panels -------------------------------

        //menu--------------------------------------

        JMenuBar menu_bar = new JMenuBar();
        contentPane.add(menu_bar, BorderLayout.NORTH);

        JMenu menu = new JMenu("File");

        JMenuItem menuItem_1 = new JMenuItem("Open (Ctrl + O)");

        menuItem_1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) { }

            @Override
            public void setEnabled(boolean b) { }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                //открываем диалогвое окно с выбором файла, читаем файл и заносим информацию в объект model
                JFileChooser fc = new JFileChooser();

//				Просто для удобства, чтоб не заходить каждый раз в папку
//				а так просто File -> Open -> и тыцяем ентер

                //У нас то пути на компах отличаются =) Гриша
                File f = null;
                try {
                    f = new File(new File("file.dgt").getCanonicalPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                fc.setSelectedFile(f);
//				Конец удобства

                if(fc.showOpenDialog(Gui.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();

                    try {
                        model = new Model(file.getAbsolutePath());

                        panel = new PaintPanel();
                        first_panel.add(panel, BorderLayout.CENTER);
                        Gui.panel.setPaintMode(-1);

                        //добавляем кнопки на боковую панель
                        panel_1.setLayout(new GridLayout(model.numDetails, 1, 120, 120));
                        //panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
                        sideButtons = new DetailBox[model.numDetails];

                        for(int i = 0; i < model.numDetails; i++) {
                            sideButtons[i] = new DetailBox(i);
                            panel_1.add(sideButtons[i]);
                            final int val = i;
                            sideButtons[i].addActionListener(new Action() {
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
                                    Gui.panel.setPaintMode(val);
                                }
                            });
                        }
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

		/* Пока нафиг не надо, только мешает дебажить
		//window listener---------------------------

		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {


			}

			@Override
			public void windowIconified(WindowEvent arg0) {


			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {


			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {


			}

			@Override
			public void windowClosing(WindowEvent event) {

				Object[] options = {"Yes", "No"};
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


			}

			@Override
			public void windowActivated(WindowEvent arg0) {


			}
		});

		//window listener --------------------------------
		*/

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(first_panel, "alert", "alert", JOptionPane.ERROR_MESSAGE);
            }
        });



        //key listener. Саня

        tab_panel.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_O && e.isControlDown()) {

                    JFileChooser fc = new JFileChooser();
                    File f = null;

                    try {
                        f = new File(new File("file.dgt").getCanonicalPath());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    fc.setSelectedFile(f);

                    if (fc.showOpenDialog(Gui.this) == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();

                        try {
                            model = new Model(file.getAbsolutePath());
                            panel = new PaintPanel();
                            first_panel.add(panel, BorderLayout.CENTER);
                            Gui.panel.setPaintMode(-1);

                            panel_1.setLayout(new GridLayout(model.numDetails, 1, 120, 120));
                            sideButtons = new DetailBox[model.numDetails];
                            for (int i = 0; i < model.numDetails; i++) {

                                sideButtons[i] = new DetailBox(i);

                                sideButtons[i].addFocusListener(new FocusListener() {

                                    /*
                                    * Вообщем когда мы делаем кнопки из деталей
                                    * они перехватывают фокус на себя.
                                    * тем самым сбивают keylistener с tab_panel.
                                    * код снизу перехватывает фокус кнопок
                                    * и передает его обратно tab_panel на которой мой keylistener.
                                    * Саня
                                    * */

                                    @Override
                                    public void focusGained(FocusEvent e) {
                                        tab_panel.grabFocus();
                                    }

                                    @Override
                                    public void focusLost(FocusEvent e) {
                                        tab_panel.grabFocus();
                                    }
                                });

                                panel_1.add(sideButtons[i]);
                                final int val = i;
                                sideButtons[i].addActionListener(new Action() {
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
                                        Gui.panel.setPaintMode(val);
                                    }
                                });
                            }
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /**
     * Getter для получения модели, юзается в PaintPanel
     */
    public static Model getModel() {
        return Gui.model;
    }


}