package cn.chenyh.ssq.model;

public class Total {
	
	//合计 统计n期内各号码出现的次数，频率
	
	public int[] total(int[][] haoma) {
		
		int[] _re = new int[33];
		
		int temp = 0;
		
		for(int i = 0;i < haoma.length;i++) {
			
			for(int j = 0; j < 6; j++) {
				
				temp = haoma[i][j]-1; 
				
				++_re[temp];
			}
			
			
		}
	
		return _re;
		
	}
	
	public int[] total(int[][] haoma,int begin,int n) {
		
		int[] _re = new int[33];
		
		int temp = 0;
		
		for(int i = begin; i<begin+n+1;i++) {
			
			for(int j = 0; j < 6; j++) {
				
				temp =  haoma[i][j]-1;
				
				++_re[temp];
				
			}
		}
		
		return _re;
		
	}
	
	public int[] total(int[] haoma) {
		
		int[] _re = new int[33];
		
		int temp = 0;
		
		for(int i = 0;i < haoma.length;i++) {
		
				temp = haoma[i]-1; 
				
				++_re[temp];
			}
	
		return _re;
		
	}
	
	public double[] pinlv(int[] total) {
		
		int sum = 0;
		
		double[] pinlv = new double[total.length];
		
		for(int i = 0;i < total.length;i++) {
			
			sum = sum + total[i];  
		}
		
		//System.out.println(sum);
		
		for(int i =0; i<total.length;i++) {
			
			pinlv[i] = (double)total[i]/(double)sum;
			
		}
		
		return pinlv;
		
		
	}

}
