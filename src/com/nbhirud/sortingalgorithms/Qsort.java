import java.io.*;

public class Qsort
{
	public static void main(String[] args)
	{
		final String SPLITVAL= ";";
		final String OUTFILE = "answer.txt";

		QuickSorter s1 = new QuickSorter();
		s1.setinputFName(args[0]);
		s1.printinputFName();
		s1.setSplitVal(SPLITVAL);
		s1.printSplitVal();

		s1.getInput();
		System.out.println("Input String: ");
		s1.printFContent();

		s1.breakInput();
		//System.out.println("Array to be sorted: ");
		//s1.printSortingList();
		long initTime = System.currentTimeMillis();
		s1.quickSort(0,s1.getLengthOfSortingList()-1);
		long endTime = System.currentTimeMillis();
		//System.out.println("Sorted Array: ");
		//s1.printSortingList();
		
		s1.setOContent();
		System.out.println("Output String: ");
		s1.printOContent();
		
		s1.setOutputFName(OUTFILE);
		s1.writeAnswer(initTime, endTime);
		
	}
}

class QuickSorter
{
	private String splitVal, inputFName, fContent, oContent, outputFName;
	private int[] sortingList;

	public void setSplitVal(String SPLITVAL)
	{
		this.splitVal = SPLITVAL;
	}


	public void printSplitVal()
	{
		System.out.println("Split Value is: "+ splitVal);
	}
	
	
	
	public void setinputFName(String inputFName)
	{
		this.inputFName = inputFName;
	}

	public void printinputFName()
	{
		System.out.println("Input File Name: "+inputFName);
	}


	public void setOutputFName(String oFName) 
	{
		this.outputFName = oFName;
	
		
	}
	
	public void getInput()
	{
		String line, fContent = null;
		try
		{
			FileReader fReader = new FileReader(inputFName);
			BufferedReader bReader = new BufferedReader(fReader);
			//There will be no separate lines because the input is supposed to be a single semicolon separated line.
			//for (int i=0; ;i++)
			//while((line = bReader.readLine()) != null)
			for (int i=0; (line = bReader.readLine()) != null ;i++)
			{
				if (i>0)
				{
					System.out.println("Additional line " + i + " from file '" + inputFName + " ignored");
					continue;
				}

				fContent = line;
				//System.out.println(line);
			}
			bReader.close();
		}
		catch(FileNotFoundException ex)
		{
            System.out.println("No such file: '" + inputFName + "'");
			ex.printStackTrace();
        }
        catch(IOException ex)
		{
            System.out.println("IO error '" + inputFName + "'");
            ex.printStackTrace();
        }
		this.fContent = fContent;
	}

	public String getFContent()
	{
		return fContent;
	}
	public void printFContent()
	{
		System.out.println(fContent);
	}

	public void breakInput()
	{
		String[] strArray = fContent.split(splitVal);
		int[] sortingList = new int[strArray.length];
		for(int i = 0; i < strArray.length; i++)
		{
			sortingList[i] = Integer.parseInt(strArray[i].trim());
		}
		this.sortingList = sortingList;
	}

	public void printSortingList()
	{
	for (int i=0; i< sortingList.length; i++)
		{
			System.out.println(sortingList[i]);
		}
	}
	
	public int getLengthOfSortingList()
	{
		return(sortingList.length);
	}
	
	public void quickSort(int start, int end)
	{
		if (start<end)
		{
			int partitionIndex = partition(start, end);
			//System.out.println(partitionIndex);
			quickSort(start, partitionIndex -1);
			quickSort(partitionIndex + 1, end);
		}
		
	}
	
	//The following function partition() reads the array from the instance variable 'sortingList'
	private int partition(int start, int end)
	{
		int pivot = sortingList[end];
		//set partition index as start initially
		int partitionIndex = start;
		int temp;
		
		for(int i = start; i<end; i++)
		{
			if(sortingList[i] <= pivot)
			{
				//Swap if element is leser than pivot
				temp = sortingList[i];
				sortingList[i] = sortingList[partitionIndex];
				sortingList[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		//swap pivot with element at pivot index
		temp = sortingList[partitionIndex];
		sortingList[partitionIndex] = sortingList[end];
		sortingList[end] = temp;
		
		return partitionIndex;
	}
	
	public void setOContent()
	{
		String outString = new String();					
		for (int i=0; i<sortingList.length; i++)
		{
			if (i == 0)
			{
				outString = String.valueOf(sortingList[i]);
				continue;
			}
			outString = outString + splitVal +" "+ String.valueOf(sortingList[i]);
		}
		this.oContent = outString;
	}
	
	public void printOContent()
	{
		System.out.println(oContent);
	}
	
	
	public void writeAnswer(long initTime, long endTime)  
	{
		try 
		{
			File file = new File(outputFName);
			if(!file.exists())
			{
				file.createNewFile();
			}
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, true));
			bWriter.write(oContent);
			
			System.out.println("Performance Analysis: ");
			bWriter.newLine();
			bWriter.newLine();
			bWriter.write("Performance Analysis: ");
			long diff = endTime - initTime;
			if(diff == 0)
			{
				System.out.println("Quicksort for size "+ sortingList.length +" took less than a millisecond");
				bWriter.newLine();
				bWriter.write("Quicksort for size "+ sortingList.length +" took less than a millisecond");
			}
			else
			{
				System.out.println("Quicksort for size "+ sortingList.length +" took "+ diff +" milliseconds");
				bWriter.newLine();
				bWriter.write("Quicksort for size "+ sortingList.length +" took "+ diff +" milliseconds");
				
			}
			System.out.println("Output written to file: "+outputFName);
			bWriter.close();
		}
		catch(IOException ex) 
		{
            System.out.println("IO error writing to '"+outputFName+"'");
            ex.printStackTrace();
        }	
	}

}