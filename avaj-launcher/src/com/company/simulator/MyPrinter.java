package com.company.simulator;

import java.io.*;

public class MyPrinter {
    public static  MyPrinter  myPrinter;

    private MyPrinter() {
        myPrinter = new MyPrinter();
    }

    public MyPrinter  getMyPrinter() {
        if (myPrinter == null) {
            return new MyPrinter ();
        } else
            return myPrinter;
    }

    public static void writetoFile(String date) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("simulation.txt", true));) {
            printWriter.write(date + "\n");
        } catch (FileNotFoundException a) {
            System.out.println("smth wrong");
        } catch (UnsupportedEncodingException g) {
            System.out.println("smth wrong");
        } catch (IOException f) {
            System.out.println("smth wrong");
        }
    }
}
