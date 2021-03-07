package cn.chenyh.ssq.model;

public class Validate {
	
	//当期命中个数
	public int validate_single(int[] kaijianghaoma,int[] yuce) {
		
		int hit_count = 0;
		
		for(int i = 0;i < kaijianghaoma.length-1;i++) {
			
			for(int j = 0;j < yuce.length;j++) {
				
				if(kaijianghaoma[i] == yuce[j]) {
					
					++hit_count;
					
					continue;
					
				}
				
			}
		}
		
		return hit_count;
		
	}
	
	//历史统计，从第一期开始统计各期命中的个数
	public int[] validate_history(int[][] kaijianghaoma,int[][] yuce) {
		
		int[] _re = new int[yuce.length-1];
		
		for(int i = 0; i < yuce.length-1; i++) {
			
			_re[i] = this.validate_single(kaijianghaoma[i], yuce[i+1]);
			
		}
		
		return _re;
	}
	
	//统计命中个数出现次数
	public int[] count(int[] hit_counts) {
		
		int[] _re = new int[7];
		
		int temp = 0;
		
		for(int i = 0 ; i <hit_counts.length;i++) {
			
			temp = hit_counts[i];
			

			
				++_re[temp];
			
			
			
		}
		
		return _re;
		
	}
	
	//统计命中个数的频度
	public double[] count_pindu(int[] count) {
		
		double[] _re = new double[7];
		
		int sum = 0;
		
		for(int i = 0; i < count.length;i++) {
			
			sum += count[i];
			
		}
		
		for(int i = 0 ; i < 7; i++) {
			
			_re[i] = (double)count[i]/(double)sum;
		}
		
		return _re;
	}
	
	//统计平均数
	public double avg(int[] hit_count) {
		
		int sum = 0;
		
		for(int i = 0; i < hit_count.length; i++) {
			
			sum += hit_count[i];
		}
		
		return (double)sum/(double)hit_count.length;
	}
	//旋转矩阵命中情况
	public String[] validate_matrix(int[][] data,int[] hit_count,int[][] sequences) {
		
		for(int i = 0;i < hit_count.length;i++) {
			
			
			
		}
		
		
		return null;
	}

}
