package cn.chenyh.ssq.exe;

import java.io.IOException;

import cn.chenyh.ssq.getdata.GetData;
import cn.chenyh.ssq.model.Methods;
import cn.chenyh.ssq.model.Methods_V2;
import cn.chenyh.writefile.WriteFile;

public class MainExe_V3 {

	/**
	 * @param args
	 * 该算法为统计历史中每个开奖号码对应的下期开奖号码中出现次数最高的几个
	 * 以及某号码跟其同出次数最高的几个
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自动生成方法存根
		
		GetData gd = new GetData();
		
		WriteFile  wf = new WriteFile();
		
		Methods_V2 mt = new Methods_V2();
		
		//定义haomashu为33，为双色球
		int haomashu = 33;
		
		int[][] haoma_yuansi = gd.getDataInt();
		
		//int[][] zhenlie = gd.zhenlie(haoma_yuansi, haomashu);
		
		//逆转数据,将最新的数据放到最后面
		//zhenlie = gd.nixu(zhenlie);
		
		//wf.writeFile(zhenlie, "c:\\data\\ssq\\阵列表示.txt");
		System.out.println("here");
		//
		//int[] count_total = gd.total(zhenlie);
		
		//System.out.println("there");
		
	/*	for(int i =0;i<33;i++) {
			
			System.out.print(i+1+" ");
		}
		
		for(int i = 0;i<33;i++) {
			
			System.out.print(count_total[i]+" ");
		}
		*/
		int[] count_total = gd.total_v2(haoma_yuansi);
		
		count_total = mt.sort(count_total);
		
		for(int i =0;i<count_total.length;i++) {
			
			++count_total[i];
		}
		
		System.out.println("there");

		for(int i =0;i<33;i++) {
			
			System.out.print(i+1+"\t");
		}
		
		System.out.print("\r\n");
		
		for(int i = 0;i<33;i++) {
			
			System.out.print(count_total[i]+"\t");
		}
	}

}
