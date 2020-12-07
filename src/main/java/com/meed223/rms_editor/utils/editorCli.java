package com.meed223.rms_editor.utils;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

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
            System.out.println("Options:\n1. Save\n2. Map Name\n3. Terrain Constants\n4. Object Constants\n5. Cliff Generation\n6. Exit");
            input = sc.nextLine();

            switch (input.toUpperCase()) {
                case "1" :
                case "SAVE" : 
                	RmsWriter.write(builder.build());
                	break;
                case "2" :
                case "NAME" : 
                	updateName(builder, sc);
                	break;
                case "3":
                case "TERRAIN CONSTANTS":
                	updateTerrainConsts(builder, sc);
                	break;
                case "4":
                case "OBJECT CONSTANTS":
                	updateObjectConsts(builder, sc);
                	break;
                case "5" :
                case "CLIFF" : 
                	updateCliffs(builder, sc);
                	break;
                case "6" :
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
    
    public static void updateTerrainConsts(RmsBuilder builder, Scanner sc) {
    	while (true) {
	    	System.out.println("Current Terrain Constants:");
	    	System.out.println("Const ID | Const Name");
	    	for (Map.Entry<String, Long> entry : builder.getTerrainDefs().entrySet()) {
	    		System.out.println(String.format("%8d | ", entry.getValue()) + entry.getKey());
	    	}
	    	System.out.println("\nOptions:\n1. Add Const\n2. Delete Constant\n3. Update\n4. Return");
	    	String input = sc.nextLine();
	    	switch(input.toUpperCase()) {
	    		case "ADD":
	    		case "1":
	    			System.out.println("\nEnter Const. Name");
	    			String newName = sc.nextLine();
	    			System.out.println("\nEnter Const. Value");
	    			Long newValue = sc.nextLong();
	    			builder.addTerrainDef(newName, newValue);
	    			break;
	    		case "DELETE":
	    		case "2":
	    			System.out.println("Enter name of Const. to be removed");
	    			builder.delTerrainDef(sc.nextLine());
	    			break;
	    		case "UPDATE":
	    		case "3":
	    			System.out.println("\nEnter Const. Name");
	    			String updateName = sc.nextLine();
	    			if (builder.terrainDefContains(updateName)) { 
	    				System.out.println("\nEnter Const. Value");
		    			Long updateValue = sc.nextLong();
		    			builder.addTerrainDef(updateName, updateValue);
	    			} else {
	    				System.out.println("Const. not found. Create a new Const. with this name.");
	    			}
	    			break;
	    		case "RETURN":
	    		case "4":
	    			return;
	    		default:
	    			System.out.println("\nInvalid input. Please try again.");
	    	}
    	}
    }
    
    public static void updateObjectConsts(RmsBuilder builder, Scanner sc) {
    	while (true) {
	    	System.out.println("Current Object Constants:");
	    	System.out.println("Const ID | Const Name");
	    	for (Map.Entry<String, Long> entry : builder.getObjectDefs().entrySet()) {
	    		System.out.println(String.format("%8d | ", entry.getValue()) + entry.getKey());
	    	}
	    	System.out.println("\nOptions:\n1. Add Const\n2. Delete Constant\n3. Update\n4. Return");
	    	String input = sc.nextLine();
	    	switch(input.toUpperCase()) {
	    		case "ADD":
	    		case "1":
	    			System.out.println("\nEnter Const. Name");
	    			String newName = sc.nextLine();
	    			System.out.println("\nEnter Const. Value");
	    			Long newValue = sc.nextLong();
	    			builder.addObjectDef(newName, newValue);
	    			break;
	    		case "DELETE":
	    		case "2":
	    			System.out.println("Enter name of Const. to be removed");
	    			builder.delObjectDef(sc.nextLine());
	    			break;
	    		case "UPDATE":
	    		case "3":
	    			System.out.println("\nEnter Const. Name");
	    			String updateName = sc.nextLine();
	    			if (builder.objectDefContains(updateName)) { 
	    				System.out.println("\nEnter Const. Value");
		    			Long updateValue = sc.nextLong();
		    			builder.addObjectDef(updateName, updateValue);
	    			} else {
	    				System.out.println("Const. not found. Create a new Const. with this name.");
	    			}
	    			break;
	    		case "RETURN":
	    		case "4":
	    			return;
	    		default:
	    			System.out.println("\nInvalid input. Please try again.");
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
    		System.out.println("\nOptions:\n1. Update Max Cliff Length\n2. Update Min Cliff Length\n3. Update Maximum number of Cliffs\n4. Update Minimum number of Cliffs\n5. Exit");
    		String input = sc.nextLine();
    		switch(input.toUpperCase()) {
	    		case "1" : 
	    			cliffs.setMaxLength(sc.nextInt());
	    			break;
	    		case "2" : 
	    			cliffs.setMinLength(sc.nextInt());
	    			break;
	    		case "3" : 
	    			cliffs.setMaxNumber(sc.nextInt());
	    			break;
	    		case "4" : 
	    			cliffs.setMinNumberCliffs(sc.nextInt());
	    			break;
	    		case "5" :
	    		case "Exit" : 
	    			builder.setCliffGeneration(cliffs);
	    			return;
	    		default:
	    			System.out.println("\nInvalid input. Please try again.");
    		}
    	}
    }
}
