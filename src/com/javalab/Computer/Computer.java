package com.javalab.Computer;

import com.javalab.Storage.Internal;

public class Computer
{
    String processor, motherBoard;
    float ramSize;
    boolean hasUSB, hasHDD, charging;

    Internal internal;

    Computer()
    {
        hasHDD = false;
        hasUSB = false;
        charging = false;
    }

    public void setCharging(boolean charging)
    {
        this.charging = charging;
    }

    public boolean isHasUSB()
    {
        return hasUSB;
    }

    public void setHasUSB(boolean hasUSB)
    {
        this.hasUSB = hasUSB;
    }

    public boolean isHasHDD()
    {
        return hasHDD;
    }

    public void setHasHDD(boolean hasHDD)
    {
        this.hasHDD = hasHDD;
    }

    public Internal getInternal()
    {
        return internal;
    }

}

