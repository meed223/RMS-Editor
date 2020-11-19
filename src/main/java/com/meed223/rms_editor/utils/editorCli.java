package com.meed223.rms_editor.utils;

import java.util.Scanner;

import com.meed223.rms_editor.map.elements.Cliff;

public class editorCli {
    static Scanner sc;

    public static void editor() {
        sc = new Scanner(System.in);
        String input;

        boolean L1 = true;
        while (L1) {
            System.out.println("Options:\n1. New Map\n2. Exit");
            input = sc.nextLine();

            switch (input.toUpperCase()) {
                case "1" :
                case "NEW MAP" : 
                	L1 = false; 
                	break;
                case "2" :
                case "EXIT" : System.exit(15);
            }
        }

        RmsBuilder builder = new RmsBuilder();
        System.out.println("Enter a map name: ");
        builder.setMapName(sc.nextLine());

        boolean L2 = true;
        while (L2) {
            System.out.println("Options:\n1. Save\n2. Update Map Name\n3. Update Cliffs\n4. Exit");
            input = sc.nextLine();

            switch (input.toUpperCase()) {
                case "1" :
                case "SAVE" : 
                	RmsWriter.write(builder.build()); L2 = false; 
                	break;
                case "2" :
                case "NAME" : 
                	updateName(builder, sc);
                	break;
                case "3" :
                case "CLIFF" : 
                	updateCliffs(builder, sc);
                	break;
                case "4" :
                case "EXIT": System.exit(15);
            }
        }
    }
    
    public static void updateName(RmsBuilder builder, Scanner sc) {
    	while(true) {
    		System.out.println("\nCurrent Map Name: " + builder.getMapName() + " \n");
    		System.out.println("Options:\n1. Set New Name\n2. Exit");
    		
    		String input = sc.nextLine();
    		switch(input.toUpperCase()) {
	    		case "1" :
	    		case "NAME" : 
	    			builder.setMapName(sc.nextLine());
	    			return;
	    		case "2" :
	    		case "Exit" : 
	    			return;
	    		default:
	    			System.out.println("Invalid input. Please try again.");
    		}
    	}
    }
    
    public static void updateCliffs(RmsBuilder builder, Scanner sc) {
    	while(true) {
    		Cliff cliffs = builder.getCliffGeneration();
    		System.out.println("\nCurrent Setup of Cliffs:"
    				+ "\nMax Cliff Length: " + cliffs.getMaxLength()
    				+ "\nMin Cliff Length: " + cliffs.getMinLength()
    				+ "\nMax No. Cliffs: " + cliffs.getMaxNumber()
    				+ "\nMin No. Cliffs: " + cliffs.getMinNumber());
    		return;
    	}
    }
}
