package cn.chenyh.ssq.model;

public class Validate {
	
	//�������и���
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
	
	//��ʷͳ�ƣ��ӵ�һ�ڿ�ʼͳ�Ƹ������еĸ���
	public int[] validate_history(int[][] kaijianghaoma,int[][] yuce) {
		
		int[] _re = new int[yuce.length-1];
		
		for(int i = 0; i < yuce.length-1; i++) {
			
			_re[i] = this.validate_single(kaijianghaoma[i], yuce[i+1]);
			
		}
		
		return _re;
	}
	
	//ͳ�����и������ִ���
	public int[] count(int[] hit_counts) {
		
		int[] _re = new int[7];
		
		int temp = 0;
		
		for(int i = 0 ; i <hit_counts.length;i++) {
			
			temp = hit_counts[i];
			

			
				++_re[temp];
			
			
			
		}
		
		return _re;
		
	}
	
	//ͳ�����и�����Ƶ��
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
	
	//ͳ��ƽ����
	public double avg(int[] hit_count) {
		
		int sum = 0;
		
		for(int i = 0; i < hit_count.length; i++) {
			
			sum += hit_count[i];
		}
		
		return (double)sum/(double)hit_count.length;
	}
	//��ת�����������
	public String[] validate_matrix(int[][] data,int[] hit_count,int[][] sequences) {
		
		for(int i = 0;i < hit_count.length;i++) {
			
			
			
		}
		
		
		return null;
	}

}
