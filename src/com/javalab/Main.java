package com.javalab;

import com.javalab.Computer.*;
import com.javalab.Storage.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import static com.javalab.LabourMethods.checkUser;
import static com.javalab.LabourMethods.clrscr;

public class Main {

    private static ArrayList<User> users = new ArrayList<>();

    private static User currentUser;

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {
        int cho;

        do
        {
            System.out.printf("\nWelcome!\n1.Login as user\n2.Exit\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            if(cho==1)
            {
                userLogin();

                userMenu();
            }

        }while(cho != 2);


    }

    static void userLogin() throws IOException
    {
        String name;

        LabourMethods.clrscr();

        System.out.printf("\nEnter name: \t\t");
        name = bufferedReader.readLine();

        int index = checkUser(name, users);

        if(index == -1)
        {
            User temp = new User();
            temp.name = name;

            users.add(temp);

            currentUser = temp;
        }

        else
            currentUser = users.get(index);
    }

    static void userMenu() throws IOException
    {
        int cho;

        do
        {
            LabourMethods.clrscr();

            System.out.printf("\nWhat do you want to do?\n1.Check out your cool computers!\n2.See the content of your storage devices\n3.Logout\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            switch(cho)
            {
                case 1:
                    computersMenu();
                    break;

                case 2:
                    storageMenu();
                    break;

                default: break;
            }

        }while(cho!=3);
    }



    static void computersMenu() throws IOException
    {
        int cho;
        String choice;

        do
        {
            LabourMethods.clrscr();

            System.out.printf("\nWhat do you want to access?:\n1.Laptop\n2.Desktop\n3.Tablet\n4.Mobile\n5.To previous menu\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            if(cho != 5)
            {
                switch(cho)
                {
                    case 1:
                        beforeInitDevice(currentUser.laptop, cho);
                        break;
                    case 2:
                        beforeInitDevice(currentUser.desktop, cho);
                        break;
                    case 3:
                        beforeInitDevice(currentUser.tablet, cho);
                        break;
                    case 4:
                        beforeInitDevice(currentUser.mobile, cho);
                        break;

                    default:break;
                }

            }

        }while(cho != 5);
    }

    static void beforeInitDevice(Computer computer, int cho) throws IOException
    {
        String choice;

        if(computer == null)
        {
            System.out.printf("\nYou don't have this device, do you want one?(Y/N): ");
            choice = bufferedReader.readLine();

            if ((choice.equals("Y") || choice.equals("y")))
                initDevice(cho);
        }

        else
            deviceMenu(computer);
    }

    static void deviceMenu(Computer computer) throws IOException
    {
        int choice;

        do
        {
            clrscr();

            System.out.printf("\nWhat do you want to do with this device?:\n1.See its contents\n2.Charge it\n3.Plug in external HDD\n4.Plug in USB\n5.To previous menu\n");
            choice = Integer.parseInt(bufferedReader.readLine());

            switch(choice)
            {
                case 1:
                    System.out.println("Internal: ");
                    displayData(computer.getInternal().getD());

                    if(computer.isHasHDD())
                    {
                        System.out.println("External HDD: ");
                        displayData(currentUser.hdd.getD());
                    }

                    if(computer.isHasUSB())
                    {
                        System.out.println("USB:");
                        displayData(currentUser.usb.getD());
                    }

                    break;

                case 2:
                    /*computer.setCharging(true);
                    computer.charge();
                    break;*/

                case 3:
                    computer.setHasHDD(true);
                    break;

                case 4:
                    computer.setHasUSB(true);

                default:break;

            }
        }while(choice != 5);
    }

    static void storageMenu() throws IOException
    {
        int cho;

        do
        {
            clrscr();

            System.out.printf("\nYou want to see the contents of:\n1.USB device\n2.External HDD\n3.To previous menu\n");
            cho = Integer.parseInt(bufferedReader.readLine());

            switch (cho)
            {
                case 1:
                    displayData(currentUser.usb.getD());
                    break;

                case 2:
                    displayData(currentUser.hdd.getD());
                    break;

                default:break;
            }

        }while(cho!=3);
    }

    static void displayData(Data data)
    {
        clrscr();

        Scanner scanner = new Scanner(System.in);

        System.out.println("It has the following files and folders.....");
        for(String file: data.getFiles())
        {
            System.out.println(file);
        }

        System.out.println("///////////////////////////////////////////////////////////////////////////");
        System.out.printf("%3f GB of %3f GB used... i.e %4f%c\n", data.getUsedSpace()/1024,data.getCapacity()/1024, 100*(data.getUsedSpace()/data.getCapacity()), '%' );
        System.out.println("//////////////////////////////////////////////////////////////////////////");

        scanner.nextLine();
    }

    static void initDevice(int cho) throws IOException
    {
        String processor, motherboard;
        Float ramSize;
        Double internal;

        System.out.printf("\nEnter the following details for this device:\nProcessor model: ");
        processor = bufferedReader.readLine();
        System.out.printf("\nMotherboard model: ");
        motherboard = bufferedReader.readLine();
        System.out.printf("\nRam size(GB): ");
        ramSize = Float.parseFloat(bufferedReader.readLine());
        System.out.printf("\nInternal memory size(GB): ");
        internal = Double.parseDouble(bufferedReader.readLine());

        switch (cho)
        {
            case 1:
                currentUser.laptop = new Laptop(ramSize*1024f, processor, motherboard, internal*1024d);
                break;

            case 2:
                currentUser.desktop = new Desktop(ramSize*1024f, processor, motherboard, internal*1024d);
                break;

            case 3:
                currentUser.tablet = new Tablet(ramSize*1024f, processor, motherboard, internal*1024d);
                break;

            case 4:
                currentUser.mobile = new Mobile(ramSize*1024f, processor, motherboard, internal*1024d);
                break;
        }

    }


}
