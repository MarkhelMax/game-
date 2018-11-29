package com.markhel;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Menu {
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;

    public JMenuBar createMenu(){
        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
                "File menu");
        menuBar.add(menu);

        menuItem = new JMenuItem("New",
                new ImageIcon("images/new.gif"));
        menuItem.setMnemonic(KeyEvent.VK_N);
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Pause", new ImageIcon("images/pause.gif"));
        menuItem.setMnemonic(KeyEvent.VK_P);
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit", new ImageIcon("images/exit.gif"));
        menuItem.setMnemonic(KeyEvent.VK_E);
        menu.add(menuItem);
        return menuBar;
    }
}