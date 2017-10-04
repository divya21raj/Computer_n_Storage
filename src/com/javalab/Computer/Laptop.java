package com.javalab.Computer;

public class Laptop extends Computer implements Charger
{
    public Laptop(float ramSize, String processor, String motherboard)
    {
        this.ramSize = ramSize;
        this.processor = processor;
        this.motherBoard = motherboard;
    }

    @Override
    public void charge()
    {
        System.out.println("The Laptop is charging...");
    }
}
