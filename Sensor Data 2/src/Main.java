import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void displayServices() {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			ArrayList<String> arraylist = new ArrayList<String>();
			System.out.println("please choose any service");
			System.out.println("===========================");
			System.out.println("press 1 to add new data");
			System.out.println("press 2 to delete data");
			System.out.println("press 3 to update data");
			System.out.println("press 4 to get data by ID");
			System.out.println("press 5 to get all data");
			System.out.println("press 0 to exit");
			System.out.println("===========================");
			int x =input.nextInt();
			if(x==0) {
				System.out.println("Finish!");
				break;
			}
			else if(x==1) {
				System.out.println("Please enter ID ");
				String id = input.next();
				System.out.println("Please enter Temparature");
				String temparature = input.next();
				System.out.println("Please enter Date");
				String date = input.next();
				System.out.println("Please enter TimeBetweenFrames");
				String timeBetweenFrames = input.next();
				Data data = new Data(id,temparature,date,timeBetweenFrames);
				
				try {
					FileWriter writer = new FileWriter(filename,true);
					writer.append(data.getDatas());
					writer.append("\n");
					writer.close();
					System.out.println("Data added successfully!");
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			else if(x==2) {
				System.out.println("enter any id or word to delete a record");
				String searchKey = input.next();
				String line;
				try {
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					while((line=reader.readLine())!=null) {
						if(line.contains(searchKey)){
							System.out.println(line);
							continue;
						}
						else {
							arraylist.add(line);
						}					
					}
				} 
				catch(Exception e) {
					System.out.println(e);
				}
				try {
					FileWriter writer = new FileWriter(filename);
					for(int i=0;i<arraylist.size();i++) {
						writer.append(arraylist.get(i));
						writer.append("\n");
					}
					writer.close();
					
				}catch(Exception e) {
					System.out.println(e);
				}
				finally {
					System.out.println("done!");
				}
			}
			else if(x==3) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					System.out.println("Please enter any key to update the record");
					String searchKey=input.next();
					String line;
					while((line=reader.readLine())!=null) {
						if(line.contains(searchKey)) {
							System.out.println("enter the text you want to change");
							String oldValue=input.next();
							System.out.println("enter the new text you want to change");
							String newValue=input.next();
							arraylist.add(line.replace(oldValue,newValue));
							
						}else {
							arraylist.add(line);	
						}	
					}		
				}catch(Exception e) {
					System.out.println(e);
				}
				try {
					FileWriter writer = new FileWriter(filename);
					for(int i=0;i<arraylist.size();i++) {
						writer.append(arraylist.get(i));
						writer.append("\n");	
					}
					writer.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			else if(x==4) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					System.out.println("Please enter any key to get the record");
					String searchKey=input.next();
					String line;
					while((line=reader.readLine())!=null) {
						if(line.contains(searchKey)) {
							System.out.println(line);
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}	
			}
			else if(x==5) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(filename));
					String line;
					while((line=reader.readLine())!=null) {
							System.out.println(line);
						}
					}catch(Exception e) {
						System.out.println(e);
				}
			}
			else {
				System.out.println("Please enter a valid number!");
			}
			
		}
	}
	
	public static String filename="database.txt";

	public static void main(String[] args) {
		
		displayServices();
		File database = new File(filename);
		try {
			if(database.createNewFile()==true) {
			}
			else {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
