package com.javalab.Computer;

import com.javalab.Storage.Internal;

import java.io.IOException;
import java.util.Scanner;

public class Desktop extends Computer implements Charger
{

    public Desktop(float ramSize, String processor, String motherboard, Double capacity) throws IOException
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

        System.out.println("A desktop doesn't charge, you stupid idiot!");
        scanner.nextLine();
    }
}
