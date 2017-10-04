package com.javalab;

import com.javalab.Computer.Desktop;
import com.javalab.Computer.Laptop;
import com.javalab.Computer.Mobile;
import com.javalab.Computer.Tablet;
import com.javalab.Storage.External;
import com.javalab.Storage.Removable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Laptop> laptops= new ArrayList<>();
    private static ArrayList<Desktop> desktops= new ArrayList<>();
    private static ArrayList<Mobile> mobiles= new ArrayList<>();
    private static ArrayList<Tablet> tablets= new ArrayList<>();

    private static Removable usb = new Removable();
    private static External hdd = new External();


    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        int cho;

        do
        {
            System.out.printf("What do you want to do?\n1.Check out the cool computers!\n2.See the content of the storage devices\n3.Exit\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            switch(cho)
            {
                case 1:
                    computers();
                    break;

                case 2:
                    storage();
                    break;

                default: break;
            }

        }while(cho!=3);
    }

    static void storage() throws IOException
    {
        int cho;

        do
        {
            System.out.printf("\nYou want to see the contents of:\n1.USB device\n2.External HDD\n3.To previous menu");
            cho = Integer.parseInt(bufferedReader.readLine());



        }while(cho!=3);
    }

    static void computers() throws IOException
    {
        int cho;

        do
        {
            System.out.printf("\nChoose b/w:\n1.Laptop\n2.Desktop\n3.Tablet\n4.Mobile\n5.To previous menu\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            if(cho != 5)
                initDevice(cho);

        }while(cho != 5);
    }

    static void initDevice(int cho) throws IOException
    {
        String processor, motherboard;
        Float ramSize;

        System.out.printf("\nEnter the following details for this device:\nProcessor model: ");
        processor = bufferedReader.readLine();
        System.out.printf("\nMotherboard model: ");
        motherboard = bufferedReader.readLine();
        System.out.printf("\nRam size: ");
        ramSize = Float.parseFloat(bufferedReader.readLine());

        switch (cho)
        {
            case 1:
                Laptop templ = new Laptop(ramSize, processor, motherboard);
                laptops.add(templ);
                break;

            case 2:
                Desktop tempd = new Desktop(ramSize, processor, motherboard);
                desktops.add(tempd);
                break;

            case 3:
                Tablet tempt = new Tablet(ramSize, processor, motherboard);
                tablets.add(tempt);
                break;

            case 4:
                Mobile tempm = new Mobile(ramSize, processor, motherboard);
                mobiles.add(tempm);
                break;
        }
    }
}
