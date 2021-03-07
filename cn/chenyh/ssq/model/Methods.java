package cn.chenyh.ssq.model;

public class Methods {
	
	GenerateRandomNums grn = new GenerateRandomNums();
	
	Sort sort = new Sort();
	
	//�ж����ɵ������Ƿ�����
	private int isHit(int[] temp, int[][] data,int haomashu,int qishu) {
		// TODO �Զ����ɷ������
		int count = 0;
		
		int sum =0;
		
		double avg = 0;
		
		for(int i = 0; i <qishu;i++) {
			
			for(int j = 0;j < 6; j++) {
				
				//ǰ������length���ֱ����Ϊ24��21
				for(int k =0;k < 33-haomashu;k++) {
					
					if(data[i][j]==temp[k]) {
						
						++sum;
						
						++count;
						
					}
				}
				
			}
			
			
		}
		
		avg = (double)sum/(double)qishu;
		

		if(avg > 3.0) {
			
			return 0;
		}
		else {
			
			//System.out.println(avg);

		}
		return 1;
	}
	
	//������֤��kaishiqihao��ǰһ��Ϊ���㷨Ԥ����ں�
	private int isHit(int[] temp, int[][] data,int haomashu,int qishu,int yuceqihao) {
		// TODO �Զ����ɷ������
		int count = 0;
		
		int sum =0;
		
		double avg = 0;
		
		for(int i = yuceqihao; i <yuceqihao+qishu;i++) {
			
			for(int j = 0;j < 6; j++) {
				
				//ǰ������length���ֱ����Ϊ24��21
				for(int k =0;k < 33-haomashu;k++) {
					
					if(data[i][j]==temp[k]) {
						
						++sum;
						
						++count;
						
					}
				}
				
			}
			
			
		}
		
		avg = (double)sum/(double)qishu;
		
		//System.out.println("Ԥ���ںź�ƽ������"+yuceqihao+" "+avg);
		
		if(avg > 2.5) {
			
			return 0;
		}
		
		return 1;
	}
	
	//�����������ɵ����� length ΪҪ���ɵ������������Ĵ���
	public int[][] isHitTotal(int[][] data,int length,int qishu,int haomashu) {
		
		int[][] _re_temp = new int[length][haomashu];
		
		int count = 0;
		
		for(int i =0; i < length; i++) {
			
			int[] temp = this.grn.getSequence(36);
			
			int flag = this.isHit(temp, data, haomashu, qishu);
			
			if(flag == 0) {
				
				continue;
			}
			
			_re_temp[i] = this.CopySequence(temp, haomashu, 33);
			
		}
		
		
		return _re_temp;
		
	}
	
	//�����������ɵ�����,�������ΪԤ�����ɣ����ⷢ���䶯
	public int[][] isHitTotal(int[][] data,int[][] sequence,int length,int qishu,int haomashu, int yuceqishu) {
		
		int[][] _re_temp = new int[length][haomashu];
		
		int count = 0;
		
		for(int i =0; i < sequence.length; i++) {
			
			int[] temp = sequence[i];
			
			int flag = this.isHit(temp, data, haomashu, qishu,yuceqishu);
			
			if(flag == 0) {
				
				continue;
			}
			
			_re_temp[count] = this.CopySequence(temp, haomashu, 33);
			
			++count;
			
		}
		
		
		int[][] _re = new int[count-1][haomashu];
		
		for(int i = 0; i < _re.length; i++ ) {
			
			_re[i] = _re_temp[i];
			
		}
		
		return _re;
		
	}
	//ͳ�����������
	public int[] totalHit(int[][] ishittotal,int haomashu) {
		
		int temp_number = 0;
		//ͳ�Ʋ����������
		int[] count = new int[33]; 
		
		for(int i = 0; i < ishittotal.length; i++) {
			
			for(int j = 0; j < haomashu; j++) {
				
				//System.out.println(ishittotal[i][j]);
				
				temp_number = ishittotal[i][j]-1;
				
				++count[temp_number];
			}
			
		}
		
		return count;
		
	}
	
	//�ҳ����ִ�����ߵ�n�����루15����12����
	
	public int[] findnumbers(int[] count,int haomashu) {
		
		int[] final_nums = new int[haomashu];

		int count_temp = 0;
		
		int count_temp_2 = 0;
		
		for(int i = 0;i<33;i++) {
			
			count_temp = 0;
			
			for(int j =0;j<33;j++) {
				
				if(count[i]<=count[j]) {
					
					++count_temp;
					
				}
			}
			
			if(count_temp<haomashu+1) {
				
				final_nums[count_temp_2] = i+1;
				
				++count_temp_2;
				
			}
		}
		
		
		for(int i = 0;i<final_nums.length;i++) {
			
			//System.out.print(final_nums[i]+" ");
		}
		
		return final_nums;
		
	}
	
	//��һ���ҳ�����ķ��� 15��
	public int[] findnumbers_v2(int[] count,int haomashu) {
		
		int[] final_nums = new int[haomashu];

		int count_temp = 0;
		
		int count_temp_2 = 0;
		
		for(int i = 0;i<33;i++) {
			
			count_temp = 0;
			
			for(int j =0;j<33;j++) {
				
				if(count[i]<=count[j]) {
					
					++count_temp;
					
				}
			}
			
			if(count_temp<10||count_temp>22) {
				
				if(count_temp_2 == haomashu) {break;}
				
				final_nums[count_temp_2] = i+1;
				
				++count_temp_2;
				
			}
		}
		
		
		for(int i = 0;i<final_nums.length;i++) {
			
			//System.out.print(final_nums[i]+" ");
		}
		
		
		return final_nums;
		
	}
	
	public int[] findnumbers_v3(int[] count,int haomashu) {
		
		int[] final_nums = new int[haomashu];

		this.sort(count);
		
		for(int i =0;i<haomashu;i++) {
			
			
			final_nums[i] = count[i]+1;
		}
		
		this.sort.MergeSort(final_nums, 0, final_nums.length-1);
		
		return final_nums;
		
	}
	

	public int[] sort(int[] data) {
		
		//ԭ����*100�ټ�����ţ��Ա�������ܻ�ȡ����ǰ����λ��
		for(int i =0;i<data.length;i++) {
			
			data[i] = 100*data[i]+i;
		}
		
		
		
		this.sort.MergeSort(data, 0, data.length-1);
		
		for(int i =0;i<data.length;i++) {
			
			data[i] = data[i]%100;
			
			//System.out.print(data[i]+" ");
			
		}
		
		//System.out.print("\n");
		
		return data;
	}
	
	//��������
	public int[] CopySequence(int[] sequence,int length,int length_total) {
		
		int[] _re = new int[length];
		
		int length_temp = length_total-length;
		
		for(int i =0;i < length; i++) {
			
			_re[i] = sequence[i+length_temp]; 
		}
		
		return _re;
	}
	

	
	//����Ԥ�� ��ʷ���ݣ�����ͳ�Ʒ���
	public int[][] multi_phase(int[][] data,int[][] sequence,int qishu,int haomashu,int length) {
		
		int[][] _re = new int[data.length-qishu-5][haomashu];
		
		for(int i = 0;i < data.length-qishu-5; i++) {
			
			_re[i] = yuce(data,sequence,qishu,haomashu,length,i); 
			
		}
		
		
		return _re;
	}

	//Ԥ�ⵥ��
	public int[] yuce(int[][] data, int[][] sequence, int qishu, int haomashu, int length,int yuceqishu) {
		// TODO �Զ����ɷ������
		int[][] ishits = this.isHitTotal(data, sequence, length, qishu, haomashu,yuceqishu);
		
		int[] count = this.totalHit(ishits,haomashu);
		
		//int[] finds = this.findnumbers(count, haomashu);
		
		int[] finds = this.findnumbers_v3(count, haomashu);
		
		return finds;
	}

}
