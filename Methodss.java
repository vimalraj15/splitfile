package collectionpractice.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Methodss {

	public static void main(String[] args) throws Exception {
		FileInputStream fin = new FileInputStream("src/collectionpractice/file/ex3input.txt");
		InputStreamReader source = new InputStreamReader(fin);
		BufferedReader br = new BufferedReader(source);
		try
		{
	    FileOutputStream fout=new FileOutputStream("src/collectionpractice/outputfile11.txt");
	  
	    String g="\n";                            
	    byte[] four=g.getBytes();
	    int count=0;
	    
	    
	    
	    String line = br.readLine();
	    String student[]=line.split(",");            //for printing the "student" in a file;
	    String temp0=student[0]+"\t";               
	    byte one[]=temp0.getBytes();                //for printing the "student" in a file;
		fout.write(one);                           //write "student" in a file; 
		
		LinkedHashMap<String,LinkedHashMap<String,Integer>> a =new LinkedHashMap<>();
		
		String SecondLine=br.readLine();
		String temp=SecondLine;                  //same subject for all student;
		String line2[]=temp.split(",");         //line2[1] contains subjects
	    String temp2=line2[1];    
	    String check=temp2;
	    String Line2[]=temp2.split(":");       
		
	    
	    for(int v=0;v < Line2.length;v++)       //we don't know how many subjects;we use length 
	    {                                        
	         String temp3=Line2[v];            //Creating Output File format;  
	         temp3=temp3+"\t";                //That is file header details;
	    	 byte[] two=temp3.getBytes();         
	    	 fout.write(two);                 
	    }
	    fout.write(four);
	    
	    
		String key;
		while(SecondLine != null)                               //we making names as key
		{
		 	String split1 [] = SecondLine.split(",");	
			key=split1[0];                                    //key as Student Name
		    String sub=split1[1],mark=split1[2];              
			String check1=sub;
			if(check.contains(check1))
			{
		    String subjects[]=sub.split(":");               //getting subjects for making key;
			   
			
			String marks[]=mark.split(":");               //getting marks; 
			
			LinkedHashMap<String, Integer> in = new LinkedHashMap<>();
		
			
			for(int i=0;i<subjects.length;i++)
			{
				int r=Integer.parseInt(marks[i]);
				in.put(subjects[i],r);	               //->Key student subject and Corresponding                      
			}	                                      //->subjects and their marks; 
			a.put(key,in);
		    SecondLine=br.readLine();
			}
			else
			{
				System.out.println("SUBJECTS ARE NOT SAME---CHECK THE SUBJECTS");
				count=count+1;
				break;
				
			}
		}	
		
		Set<Entry<String, LinkedHashMap<String, Integer>>> data= a.entrySet();
		Iterator<Entry<String, LinkedHashMap<String, Integer>>> it = data.iterator();
		   
		   while(it.hasNext())
		   {
				Entry<String, LinkedHashMap<String, Integer>> data1= it.next();
				String names = data1.getKey();
				
				
				String temp5=names+"\t";               //for correct format we use temp5 variable
				byte[] three = temp5.getBytes();
				fout.write(three);
				
			    Map<String, Integer> v=data1.getValue();
				Set<String> j=v.keySet();
				Iterator<String> o=j.iterator();       
				while(o.hasNext())
				   {
				       String inner =o.next();                      //names means student name;
				       Integer f=(a.get(names).get(inner));        //inner means subject;
                       String g1=f.toString()+"\t";
                       byte four1[]=g1.getBytes();
                       fout.write(four1);     
				    }
				    fout.write(four);                           //for nextLine			    
		        }
		   br.close();
		   fin.close();
		   fout.close();
		   if(count <= 0 )
		    {
			   System.out.println("<<<<<<<<<{---FILE CREATED SUCESSFULLY---}>>>>>>>>>");
		    }
		   }
		  catch(Exception ex)
		  {
			ex.printStackTrace();
			System.out.println("NOT ALL EQUAL CHECK");
		  }
	     }
	
	}
