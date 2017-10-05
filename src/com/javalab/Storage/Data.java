package com.javalab.Storage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Data
{
    ArrayList<String> files;
    ArrayList<Double> size; //size of each file in files

    Double usedSpace; //memory taken up by files

    static ArrayList<String> allFiles;
    static ArrayList<Double> allFileSize;
    private Double capacity;

    public Double getCapacity()
    {
        return capacity;
    }

    Data(Double capacity) throws IOException
    {
        if(allFiles.isEmpty() == true)
            allFilesInit();

        usedSpace = 0d;

        this.capacity = capacity;

        fillData(files);

    }

    private void fillData(ArrayList<String> files) throws IOException
    {
        Random random = new Random();

        ArrayList<Integer> numList = new ArrayList<>();
        for(int i=0; i<allFiles.size(); i++)
            numList.add(i);

        Collections.shuffle(numList);

        int numofFiles = random.nextInt(allFiles.size());

        for(int i =0; i< numofFiles; i++)
        {
            if(usedSpace + allFileSize.get(numList.get(i)) <= capacity)
            {
                files.add(allFiles.get(numList.get(i)));
                size.add(allFileSize.get(numList.get(i)));

                usedSpace += allFileSize.get(numList.get(i));
            }
        }



    }

    private void allFilesInit() throws IOException
    {
        String fileSource = "files/fileNames.txt";
        String sizeSource = "files/fileSizes.txt";
        FileReader fileReader1 = new FileReader(fileSource);
        FileReader fileReader2 = new FileReader(sizeSource);

        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        while(true)
        {
            String fileLine = bufferedReader1.readLine();
            String sizeLine = bufferedReader2.readLine();

            if(fileLine == null)
                break;

            else
            {
                allFiles.add(fileLine);
                allFileSize.add(Double.parseDouble(sizeLine));
            }
        }

        bufferedReader1.close();
        bufferedReader2.close();
        fileReader1.close();
        fileReader2.close();
    }

    public ArrayList<String> getFiles()
    {
        return files;
    }

    public ArrayList<Double> getSize()
    {
        return size;
    }

    public Double getUsedSpace()
    {
        return usedSpace;
    }
}
