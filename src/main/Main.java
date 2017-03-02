package main;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            int amount = Integer.parseInt(input.readLine());
            int[] array = new int[amount];
            int sum = 0, multipl = 1, min = 0, max = 0, minPos = 0, maxPos = 0;
            String[] buff = input.readLine().split(" ");
            input.close();
            for (int i = 0;i < amount;i++)
            {
                array[i] = Integer.parseInt(buff[i]);
                if (array[i] > 0)
                {
                    sum += array[i];
                }
                if (array[i] < min)
                {
                    min = array[i];
                    minPos = i;
                }
                if (array[i] > max)
                {
                    max = array[i];
                    maxPos = i;
                }
            }
            if (minPos < maxPos)
            {
                for (int i = minPos + 1;i<maxPos;i++)
                {
                    multipl = multipl * array[i];
                }
            }
            else
            {
                for (int i = maxPos + 1;i<minPos;i++)
                {
                    multipl = multipl * array[i];
                }
            }
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
            output.write(String.valueOf(sum) + " " + String.valueOf(multipl));
            output.close();
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            return;
        }
    }
}