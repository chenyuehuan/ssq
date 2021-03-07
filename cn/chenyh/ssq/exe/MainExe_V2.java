package cn.chenyh.ssq.exe;

import java.io.IOException;

import cn.chenyh.matrix.Matrix;
import cn.chenyh.ssq.getdata.GetData;
import cn.chenyh.ssq.model.GenerateRandomNums;
import cn.chenyh.ssq.model.Methods;
import cn.chenyh.ssq.model.Validate;
import cn.chenyh.writefile.WriteFile;

public class MainExe_V2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɷ������
		Methods mt = new Methods();
		
		GetData gd = new GetData();
		
		GenerateRandomNums grn = new GenerateRandomNums();
		
		Matrix mtr = new Matrix();
		
		Validate vd = new Validate();
		
		WriteFile  wf = new WriteFile();
		
		//��ȡ��������
		int[][] data = gd.getDataInt();
		//�������
		int length = 100000;
		
		int qishu = 5;
		
		int haomashu = 15;
		//�����������
		int[][] sequences = grn.getSequences(33, length);
		//��ȡԤ������
		int[][] result_1 = mt.multi_phase(data, sequences, qishu, haomashu, length);
		
		//System.out.println("running 1");
		//�����������
		int[] hit_count = vd.validate_history(data, result_1);
		
		//System.out.println("running 2");
		//ͳ�Ƹ����и������ִ���
		int[] count = vd.count(hit_count);
		
		for(int i = 0;i<count.length;i++) {
			
			System.out.println(i+" "+count[i]);
			
		}
		
		double avg = vd.avg(hit_count);
		
		double[] pindu = vd.count_pindu(count);
		
		System.out.println("avg:"+avg);
		
		System.out.println("Ƶ��:");
		
		for(int i = 0;i <pindu.length;i++) {
			
			System.out.println(i+" "+pindu[i]);
		}
		
		wf.writeFile(result_1, "c:\\data\\ssq\\Ԥ����.txt");
		
		wf.writeFile(hit_count,"c:\\data\\ssq\\Ԥ�����и���.txt" );
		
	}

}
