package cn.chenyh.ssq.exe;

import cn.chenyh.ssq.getdata.GetData;
import cn.chenyh.ssq.model.Methods;
import cn.chenyh.ssq.model.Methods_V2;

public class MainExeYiLou {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		Methods_V2 mt = new Methods_V2();
		
		GetData gd = new GetData();
		
		int[][] data = gd.getDataInt();
		
		int[][] yilou = mt.yilou(data);
		
		for(int i =0;i<33;i++) {
			
			System.out.print(i+1+" ");
			
			for(int j =0;j<20;j++) {
				
				System.out.print(yilou[i][j]+" ");
			}
			
			System.out.println();
		}
		
		

	}

}
