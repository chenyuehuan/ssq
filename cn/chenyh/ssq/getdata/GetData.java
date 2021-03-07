package cn.chenyh.ssq.getdata;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetData {
	
	public String[][] getdatafromtxt() {
		
		String line = null;
		
		FileReader fr;
		
		BufferedReader br;
		
		String path = "c:\\data\\ssq\\ssq.txt";
		
		String[][] re_temp = new String[600][7];
		
		int count = 0;
		
		try {
			
			fr = new FileReader(path);
			
			br = new BufferedReader(fr);
			
			do {
				
				line = br.readLine();
				
				if(line == null){ break;}
				
				//System.out.println(line);
				
				String[] temp = line.split("\\s+");
				
				for(int i = 0;i < 7; i++) {
					
					re_temp[count][i] = temp[1+i];
					
				}
				
				++count;
				
				
			}while(line!=null);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
		
		String[][] re = new String[count][7];
		
		for(int i = 0 ; i<re.length;i++) {
			
			for(int j = 0;j < 7;j++) {
				
				re[i][j] = re_temp[i][j];
				
				//System.out.println(re[i][j]);
				
			}
			
		}
		
		
		
		return re;
	}
	
	
	//返回int类型的数据
	public int[][] getDataInt() {
		
		String[][] string = this.getdatafromtxt();
		
		int[][] re = new int[string.length][7];
		
		for(int i = 0;i < re.length;i++) {
			
			for(int j =0 ;j < 7; j++) {
				
				re[i][j] = Integer.parseInt(string[i][j]);
			}
			
		}
		
		
		return re;
		
	}
	
	
	public int[][] string2int(String[][] string) {
		
		int[][] re = new int[string.length][7];
		
		for(int i = 0;i < re.length;i++) {
			
			for(int j =0 ;j < 7; j++) {
				
				re[i][j] = Integer.parseInt(string[i][j]);
			}
			
		}
		
		
		return re;
		
	}
	
	//双色球历史号码的阵列表示，以便统计 haoma[i]包括了蓝码
	public int[][] zhenlie(int[][] haoma,int haomashu) {
		
		int[][] _re = new int[haoma.length][haomashu];
		
		int temp = 0;
		
		for(int i =0;i<_re.length;i++) {
			
			for(int j = 0;j < _re[i].length;j++) {
				
				_re[i][j] =0;
			}
		}
		
		for(int i =0;i<_re.length;i++) {
			
			for(int j = 0;j < haoma[i].length-1;j++) {
				
				temp = haoma[i][j];
				
				_re[i][temp-1] = 1;
				
			}
		}
		
		
		return _re;
	}
	
	public int[] total(int[][] zhenlie) {
		
		int[] _re = new int[33];
		
		for(int i =0;i<zhenlie.length;) {
			
			for(int j =0;j<zhenlie[i].length;j++) {
				
				_re[j] += zhenlie[i][j];
			}
		}
		
		return _re;
		
	}
	
	//将排序转为从最老的期数到最新的期数
	public int[][] nixu(int[][] zhenlie) {
		
		int length = zhenlie.length;
		
		int[] temp;
		
		int[][] _re = new int[zhenlie.length][zhenlie[0].length];
		
		for(int i = 0;i<(int)length/2;i++) {
			
			temp = _re[i];
			
			_re[i] = zhenlie[length-1-i];
			
			zhenlie[length-1-i] = temp;
		}
		
		
		return _re;
	}
	
	public int[] total_v2(int[][] haoma_yuansi) {
		
		int[] _re = new int[33];
		
		int temp = 0;
		
		for(int i =2;i<7;i++) {
			
			for(int j =0;j < haoma_yuansi[i].length;j++) {
				
				temp = haoma_yuansi[i][j]-1;
				
				++_re[temp];
			}
		}
		
		return _re;
	}

}
