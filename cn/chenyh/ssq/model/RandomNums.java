package cn.chenyh.ssq.model;

import java.util.Random;

public class RandomNums {

	 public static int[] getSequence() {
        
		 int[] sequence = new int[33];
         for(int i = 0; i < 33; i++){
             sequence[i] = i;
         }
         Random random = new Random();
         for(int i = 0; i < 33; i++){
             int p = random.nextInt(33);
             int tmp = sequence[i];
             sequence[i] = sequence[p];
             sequence[p] = tmp;
         }
         random = null;
         
         for(int i =0; i < 33; i++) {
        	 
        	 ++sequence[i];
         }
         return sequence;
     }

}
