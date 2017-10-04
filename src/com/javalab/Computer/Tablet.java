package com.javalab.Computer;

public class Tablet extends Computer implements Charger
{
    public Tablet(float ramSize, String processor, String motherboard)
    {
        this.ramSize = ramSize;
        this.processor = processor;
        this.motherBoard = motherboard;
    }

    @Override
    public void charge()
    {
        System.out.println("The tablet is charging...");
    }
}

