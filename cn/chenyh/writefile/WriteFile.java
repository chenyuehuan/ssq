package cn.chenyh.writefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	
	public void writeFile(int[][] numbers,String path) throws IOException {
		
		//System.out.println("numbers.length ="+numbers.length);
		
		File file = new File(path);
		
		if(file.exists()== false) {file.createNewFile();}
		
		
		FileWriter fw = new FileWriter(path);
		
		//System.out.println("write file");
		
		for(int i = 0 ; i< numbers.length ;i++) {
			
		 
			fw.write(Integer.toString(i+1));
			fw.write("\t");
			
			for(int j = 0 ; j < numbers[i].length ; j++) {
				
				fw.write(" ");
				
				fw.write(Integer.toString(numbers[i][j]));
				
			}
			
			fw.write("\r\n");
			
		}
		
		fw.close();
	}
	
	
	public void writeFile(int[] numbers,String path) throws IOException {
		
		//System.out.println("numbers.length ="+numbers.length);
		
		File file = new File(path);
		
		if(file.exists()== false) {file.createNewFile();}
		
		
		FileWriter fw = new FileWriter(path);
		
		//System.out.println("write file");
		
		for(int i = 0 ; i< numbers.length ;i++) {
			
		 
			fw.write(Integer.toString(i+1));
				
			fw.write(" ");
				
			fw.write(Integer.toString(numbers[i]));
				
			fw.write("\r\n");
			
		}
		
		fw.close();
	}

}
