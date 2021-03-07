package cn.chenyh.ssq.exe;

import cn.chenyh.ssq.getdata.GetData;
import cn.chenyh.ssq.model.Method;
import cn.chenyh.ssq.model.RandomNums;
import cn.chenyh.ssq.model.Total;

public class MainExe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		
		GetData gd = new GetData();
		
		Total tt = new Total();
		
		String[][] data_string = gd.getdatafromtxt();
		
		int[][] data = gd.string2int(data_string);
		
		/*for(int i = 0 ;i < data.length; i++) {
			
			System.out.println(i+" "+data[i][0]+" "+data[i][1]+" "+data[i][2]+" "+data[i][3]+" "+data[i][4]+" "+data[i][5]);
			
		}*/
		
		//统计各号码出现次数以及频度
		/*	int[] count = tt.total(data,1,11);
		
		double[] pinlv = tt.pinlv(count);
		
		for(int i = 0 ;i < count.length;i++) {
			
			System.out.println(i+1+" "+count[i]);
			
		}
		*/
		//随机数列选号算法
		RandomNums rn = new RandomNums();
		
		Method mt = new Method();
		
		int[][] useful = new int[30000][11];
		
		int count_1 = 0;
		//挖掘符合条件的数列
		for(int i = 0;i < 30000; i++) {
			
			//
			int[] temp = rn.getSequence();
			
			int flag = mt.isUsed(temp,data);
			
			if(flag == 0) {
				
				continue;
				
			}
			//该数列可用，下面应扩展使用
			
			//复制储存数列
			useful[count_1] = mt.CopySequence(temp);
			
			count_1++;
			
		}
		int temp_number = 0;
		//统计并整理出号码
		int[] count_33 = new int[33]; 
		
		for(int i = 0; i < count_1; i++) {
			
			for(int j = 0; j < 11; j++) {
				
				temp_number = useful[i][j]-1;
				
				++count_33[temp_number];
			}
			
		}
		
		//统计并合计出各号码出现次数
		for(int i =0;i<33;i++) {
			
			//System.out.println(i+1+" "+count_33[i]);
		}
		//System.out.println(" ");
		
		//挑出11个出现次数最高的号码
		
		int[] final_nums = new int[15];
		
		int count_temp = 0;
		
		int count_temp_2 = 0;
		
		for(int i = 0;i<33;i++) {
			
			count_temp = 0;
			
			for(int j =0;j<33;j++) {
				
				if(count_33[i]<=count_33[j]) {
					
					++count_temp;
					
				}
			}
			
			if(count_temp<16) {
				
				final_nums[count_temp_2] = i+1;
				
				++count_temp_2;
				
			}
		}
		
		
		for(int i = 0;i<final_nums.length;i++) {
			
			System.out.print(final_nums[i]+" ");
		}
		
	}

}
