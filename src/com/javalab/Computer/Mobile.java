package com.javalab.Computer;

public class Mobile extends Computer implements Charger
{
    public Mobile(float ramSize, String processor, String motherboard)
    {
        this.ramSize = ramSize;
        this.processor = processor;
        this.motherBoard = motherboard;
    }

    @Override
    public void charge()
    {
        System.out.println("The mobile is charging...");
    }
}
