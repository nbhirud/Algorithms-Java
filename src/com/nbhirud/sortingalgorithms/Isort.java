package com.nbhirud.sortingalgorithms;

import java.io.*;

/*
*Author @nbhirud
*
* Steps:
* 1. Read string from file (file-name to be a command line input) - getInput()
* 2. Separate semicolon separated numbers (assume integers) from the string into individual numbers and write them to array. - breakInput()
* 3. Sort the array using concept of insertion sort and comparing through linear search. - insertionSort()
* 4. Write the output to file - writeAnswer()
*
*
*/


/* Program to sort an input file test.txt containing sequence of numbers separated by semicolon. Note: filename could be different */
public class Isort 
{
	public static void main(String[] args) 
	{
		final String SPLITVAL= ";";
		final String OUTFILE = "answer.txt";
		
		
		String fName = new String(args[0]);
		System.out.println("Input filename: "+ fName);
		String fContent = new String();
		fContent = getInput(fName);
		//System.out.println(fContent);
		int[] sortingList = breakInput(fContent, SPLITVAL);
		System.out.println("Input:");
		for (int i=0; i< sortingList.length; i++)
		{
			System.out.println(sortingList[i]);
		}
		
		sequentialSearch(sortingList);
		System.out.println("Output:");
		for (int i=0; i< sortingList.length; i++)
		{
			System.out.println(sortingList[i]);
		}
		writeAnswer(sortingList, OUTFILE, SPLITVAL);
		System.out.println("Output filename: "+ OUTFILE);
		
		
		
		
	}
	
	public static String getInput(String fName)
	{
		String line, fContent = null;
		try 
		{
			FileReader fReader = new FileReader(fName);
			BufferedReader bReader = new BufferedReader(fReader);
			//There will be no separate lines because the input is supposed to be a single semicolon separated line.
			//for (int i=0; ;i++)
			//while((line = bReader.readLine()) != null)
			for (int i=0; (line = bReader.readLine()) != null ;i++)
			{
				if (i>0)
				{
					System.out.println("Additional line " + i + " from file '" + fName + " ignored");
					continue;
				}
				
				fContent = line;
				//System.out.println(line);
			}
			bReader.close();
		}
		catch(FileNotFoundException ex) 
		{
            System.out.println("No such file: '" + fName + "'");
			ex.printStackTrace();
        }
        catch(IOException ex) 
		{
            System.out.println("IO error '" + fName + "'");
            ex.printStackTrace();
        }
		return fContent;
	}
		
		
	public static int[] breakInput(String fContent, String SPLITVAL)
	{
		String[] strArray = fContent.split(SPLITVAL);
		int[] sortingList = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++) 
		{
			sortingList[i] = Integer.parseInt(strArray[i].trim());
		}
		return sortingList;
	}
	
	
		public static void sequentialSearch(int[] sortingList) 
	{

		for (int key = 1; key < sortingList.length; key++)
		{
			int insertLocation = key;
			//System.out.println("key = " + key);
			for(int i = 0; insertLocation > i; i++)
			{
				if (sortingList[i] > sortingList[key])
				{
					insertLocation = i;
					break;
				}
			}
			
			//Shift elements ahead for insertion:
		if (insertLocation != key)
			{
				swap(sortingList, insertLocation, key);
			}
		}
	}
	
	public static void swap(int[] sortingList, int insertLocation, int key)
	{
		if (insertLocation != key)
		{
			int temp;
			temp = sortingList[key];
			for(int i = key; i > insertLocation; i--)
			{
				sortingList[i] = sortingList[i-1];
			}
			sortingList[insertLocation] = temp;
		}
		
	}
	
	public static void writeAnswer(int[] sortingList, String OUTFILE, String SPLITVAL)
	{
		String outString = new String();					
		for (int i=0; i<sortingList.length; i++)
		{
			if (i == 0)
			{
				outString = String.valueOf(sortingList[i]);
				continue;
			}
			outString = outString + SPLITVAL +" "+ String.valueOf(sortingList[i]);
		}
		try 
		{
			File file = new File(OUTFILE);
			if(!file.exists())
			{
				file.createNewFile();
			}
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, true));
			bWriter.write(outString);
			bWriter.close();
		}
		catch(IOException ex) 
		{
            System.out.println("IO error writing to '"+OUTFILE+"'");
            ex.printStackTrace();
        }		
	}
		
}
