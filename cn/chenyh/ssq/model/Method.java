package cn.chenyh.ssq.model;

public class Method {
	
	RandomNums rn = new RandomNums();

	public int isUsed(int[] temp, int[][] data) {
		// TODO �Զ����ɷ������
		int count = 0;
		
		int sum =0;
		
		double avg = 0;
		
		for(int i = 0; i <data.length;i++) {
			
			for(int j =0;j <6 ; j++) {
				
				for(int k =0;k < 22;k++) {
					
					if(data[i][j]==temp[k]) {
						
						++sum;
						
						++count;
						
					}
				}
				
			}
			
			
		}
		
		avg = (double)sum/(double)data.length;
		
		//System.out.println(avg);
		
		if(avg > 3.0) {
			
			return 0;
		}
		
		return 1;
	}
	
	//�������У�33�����븴�ƺ���11��
	public int[] CopySequence(int[] sequence) {
		
		int[] _re = new int[11];
		
		for(int i =0;i < 11; i++) {
			
			_re[i] = sequence[i+22]; 
		}
		
		return _re;
	}

}
