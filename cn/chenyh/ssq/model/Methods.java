package cn.chenyh.ssq.model;

public class Methods {
	
	GenerateRandomNums grn = new GenerateRandomNums();
	
	Sort sort = new Sort();
	
	//判断生成的数组是否有用
	private int isHit(int[] temp, int[][] data,int haomashu,int qishu) {
		// TODO 自动生成方法存根
		int count = 0;
		
		int sum =0;
		
		double avg = 0;
		
		for(int i = 0; i <qishu;i++) {
			
			for(int j = 0;j < 6; j++) {
				
				//前期区长length，分别可以为24或21
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
	
	//用于验证，kaishiqihao的前一期为该算法预测的期号
	private int isHit(int[] temp, int[][] data,int haomashu,int qishu,int yuceqihao) {
		// TODO 自动生成方法存根
		int count = 0;
		
		int sum =0;
		
		double avg = 0;
		
		for(int i = yuceqihao; i <yuceqihao+qishu;i++) {
			
			for(int j = 0;j < 6; j++) {
				
				//前期区长length，分别可以为24或21
				for(int k =0;k < 33-haomashu;k++) {
					
					if(data[i][j]==temp[k]) {
						
						++sum;
						
						++count;
						
					}
				}
				
			}
			
			
		}
		
		avg = (double)sum/(double)qishu;
		
		//System.out.println("预测期号和平均数："+yuceqihao+" "+avg);
		
		if(avg > 2.5) {
			
			return 0;
		}
		
		return 1;
	}
	
	//总体命中生成的数组 length 为要生成的随机号码数组的次数
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
	
	//总体命中生成的数组,随机数组为预先生成，避免发生变动
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
	//统计整理出号码
	public int[] totalHit(int[][] ishittotal,int haomashu) {
		
		int temp_number = 0;
		//统计并整理出号码
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
	
	//找出出现次数最高的n个号码（15个或12个）
	
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
	
	//另一个找出号码的方法 15码
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
		
		//原数据*100再加上序号，以便排序后能获取排序前所在位置
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
	
	//复制数组
	public int[] CopySequence(int[] sequence,int length,int length_total) {
		
		int[] _re = new int[length];
		
		int length_temp = length_total-length;
		
		for(int i =0;i < length; i++) {
			
			_re[i] = sequence[i+length_temp]; 
		}
		
		return _re;
	}
	

	
	//多期预测 历史数据，用于统计分析
	public int[][] multi_phase(int[][] data,int[][] sequence,int qishu,int haomashu,int length) {
		
		int[][] _re = new int[data.length-qishu-5][haomashu];
		
		for(int i = 0;i < data.length-qishu-5; i++) {
			
			_re[i] = yuce(data,sequence,qishu,haomashu,length,i); 
			
		}
		
		
		return _re;
	}

	//预测单期
	public int[] yuce(int[][] data, int[][] sequence, int qishu, int haomashu, int length,int yuceqishu) {
		// TODO 自动生成方法存根
		int[][] ishits = this.isHitTotal(data, sequence, length, qishu, haomashu,yuceqishu);
		
		int[] count = this.totalHit(ishits,haomashu);
		
		//int[] finds = this.findnumbers(count, haomashu);
		
		int[] finds = this.findnumbers_v3(count, haomashu);
		
		return finds;
	}

}
