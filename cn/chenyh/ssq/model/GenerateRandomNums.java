package cn.chenyh.ssq.model;

import java.util.Random;

public class GenerateRandomNums {
	
	 public static int[] getSequence(int length) {
	        
		 int[] sequence = new int[length];
		 
         for(int i = 0; i < length; i++){
            
        	 sequence[i] = i;
        	 
         }
         Random random = new Random();
         
         for(int i = 0; i < length; i++){
        	 
             int p = random.nextInt(length);
             
             int tmp = sequence[i];
             
             sequence[i] = sequence[p];
             
             sequence[p] = tmp;
             
         }
         random = null;
         
         for(int i =0; i < length; i++) {
        	 
        	 ++sequence[i];
        	 
         }
         
         return sequence;
     }

	 public int[][] getSequences(int haomashu,int length) {
		 
		 int[][] sequences = new int[length][haomashu];
		 
		 for(int i = 0; i < length; i++) {
			 
			 sequences[i] = this.getSequence(haomashu);
		 }
		 
		 return sequences;
		 
	 }
}
