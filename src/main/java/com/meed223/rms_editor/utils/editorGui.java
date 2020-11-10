package com.meed223.rms_editor.utils;

import javax.swing.*;

public class editorGui {
    JFrame window;
    // Menu Elements
    JMenuBar menuBar;
    JMenu fileMenu, recent, helpMenu;
    JMenuItem save, saveAs, open, exit;
    // Tabbed Pane Elements
    JTabbedPane tabbedPane;
    JComponent mapBasics, playerSetup, landGeneration, terrainGeneration,
            objectsGeneration, connectionGeneration, elevationGeneration, cliffGeneration;

    public editorGui() {
        window = new JFrame("RMS Editor");
        // Set window details
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(,);

        // ---[ Menu Bar ]---
        menuBar = new JMenuBar();
        // File Menu
        fileMenu = new JMenu("File");
        open = new JMenuItem("Open");
        fileMenu.add(open);
        // TODO Add recent items submenu
        save = new JMenuItem("Save");
        fileMenu.add(save);
        saveAs = new JMenuItem("Save As");
        fileMenu.add(saveAs);
        exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        menuBar.add(fileMenu);

        // Help Menu
        helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        tabbedPane = new JTabbedPane();
    }
}
