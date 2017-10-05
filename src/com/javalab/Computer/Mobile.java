package com.javalab.Computer;

import com.javalab.Storage.Internal;

import java.io.IOException;

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
        System.out.println("The mobile is charging...");
    }
}
