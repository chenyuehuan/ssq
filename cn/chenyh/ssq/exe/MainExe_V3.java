package cn.chenyh.ssq.exe;

import java.io.IOException;

import cn.chenyh.ssq.getdata.GetData;
import cn.chenyh.ssq.model.Methods;
import cn.chenyh.ssq.model.Methods_V2;
import cn.chenyh.writefile.WriteFile;

public class MainExe_V3 {

	/**
	 * @param args
	 * ���㷨Ϊͳ����ʷ��ÿ�����������Ӧ�����ڿ��������г��ִ�����ߵļ���
	 * �Լ�ĳ�������ͬ��������ߵļ���
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɷ������
		
		GetData gd = new GetData();
		
		WriteFile  wf = new WriteFile();
		
		Methods_V2 mt = new Methods_V2();
		
		//����haomashuΪ33��Ϊ˫ɫ��
		int haomashu = 33;
		
		int[][] haoma_yuansi = gd.getDataInt();
		
		//int[][] zhenlie = gd.zhenlie(haoma_yuansi, haomashu);
		
		//��ת����,�����µ����ݷŵ������
		//zhenlie = gd.nixu(zhenlie);
		
		//wf.writeFile(zhenlie, "c:\\data\\ssq\\���б�ʾ.txt");
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
