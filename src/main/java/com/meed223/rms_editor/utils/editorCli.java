package com.meed223.rms_editor.utils;

import java.util.Scanner;

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
                case "NEW MAP" : L1 = false; break;
                case "2" :
                case "EXIT" : System.exit(15);
            }
        }

        RmsBuilder builder = new RmsBuilder();
        System.out.println("Enter a map name: ");


        boolean L2 = true;
        while (L2) {
            System.out.println("Options:\n1. Save\n2. Exit");
            input = sc.nextLine();

            switch (input.toUpperCase()) {
                case "1" :
                case "SAVE" : RmsWriter.write(builder.build()); L2 = false; break;
                case "2" :
                case "EXIT" : System.exit(15);
            }
        }
    }
}
