package com.javalab.Computer;

public class Desktop extends Computer implements Charger
{
    Desktop(float ramSize, String processor, String motherboard)
    {
        this.ramSize = ramSize;
        this.processor = processor;
        this.motherBoard = motherboard;
    }

    @Override
    public void charge()
    {
        System.out.println("A desktop doesn't charge, you stupid idiot!");
    }
}
