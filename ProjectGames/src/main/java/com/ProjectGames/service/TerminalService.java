package com.ProjectGames.service;

import java.util.Scanner;

public class TerminalService {

    public static Integer askNumber(){
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch(NumberFormatException e){
        }
        return null;
    }

    public static String askString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
