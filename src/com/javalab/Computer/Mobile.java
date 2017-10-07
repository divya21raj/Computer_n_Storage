package com.javalab.Computer;

import com.javalab.LabourMethods;
import com.javalab.Storage.Internal;

import java.io.IOException;
import java.util.Scanner;

public class Mobile extends Computer implements Charger
{
    public Mobile(float ramSize, String processor, String motherboard, Double capacity) throws IOException
    {
        this.ramSize = ramSize;
        this.processor = processor;
        this.motherBoard = motherboard;
        this.internal = new Internal(capacity);
    }

    @Override
    public void charge()
    {
        Scanner scanner = new Scanner(System.in);
        String choice;

        LabourMethods.clrscr();

        if(this.charging==false)
        {
            this.charging = true;
            System.out.println("The Laptop is charging...");
            scanner.nextLine();
        }

        else
        {
            System.out.println("It's already charging, unplug?(Y/N): ");
            choice = scanner.nextLine();

            if(choice.equals("Y")||choice.equals("y"))
            {
                this.charging = false;
                System.out.println("Not charging anymore...");
                scanner.nextLine();
            }
        }
    }
}
