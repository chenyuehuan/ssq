package cn.chenyh.ssq.model;

public class Methods_V2 {
	
	Sort sort = new Sort();
	
	//同出号码统计
	public int[] tongchu(int[][] zhenlie ,int haoma,int qishu,int yuceqishu) {
		
		int[] _re = new int[33];
		
		for(int i =yuceqishu;i<qishu;i++) {
			
			if(zhenlie[i][haoma-1] ==1) {
				
				for(int j =0;j<33;j++) {
					
					_re[j] += zhenlie[i][j]; 
				}
			}
		}
		
		return _re;
	}
	
	//统计当某号码出现后，下期出现号码次数统计
	
	public int[] next(int[][] zhenlie,int haoma,int qishu,int yuceqishu) {
		
		int[] _re = new int[33];
		
		for(int i =yuceqishu;i<qishu;i++) {
			
			if(zhenlie[i+1][haoma-1] ==1) {
				
				for(int j =0;j<33;j++) {
					
					_re[j] += zhenlie[i][j]; 
				}
			}
		}
		
		return _re;
	}
	
	//排序
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
	
	//
	public int[][] get_tongchu(int[][] zhenlie,int[] haoma,int qishu,int yuceqishu) {
		
		int[][] tongchu = new int[haoma.length][33];
		
		for(int i =0;i<haoma.length;i++) {
			
			tongchu[i] = this.tongchu(zhenlie, haoma[i], qishu, yuceqishu);
			
		}
		
		return tongchu;
	}
	
	public int[][] get_next(int[][] zhenlie,int[]haoma,int qishu,int yuceqishu) {
		
		int[][] next = new int[haoma.length][33];
		
		for(int i = 0;i<haoma.length;i++) {
			
			next[i] = this.next(zhenlie, haoma[i], qishu, yuceqishu);
			
		}
		
		return next;
		
	}
	
	
	//找出各号码出现的序号列
	
	public int[][] xuhaolie(int[][] data) {
		
		int[][] _re = new int[33][300];
		
		int[] count = new int[33];
		
		for(int i = 0;i<data.length;i++) {
			
			for(int j = 1;j < 34; j++) {
				
				if(this.isIn(data[i], j) == 1) {
					
					_re[j-1][count[j-1]] = i;
					
					++count[j-1];
				}
				
			}
		}
		
		
		return _re;
	}
	
	public int[][] yilou(int[][] data){
		
		int[][] _re = new int[33][299];
		
		int[][] xuhaolie = this.xuhaolie(data);
		
		for(int i =0;i<xuhaolie.length;i++) {
			
			for(int j =0;j<299;j++) {
				
				_re[i][j] = xuhaolie[i][j+1]-xuhaolie[i][j];
			}
		}
		
		return _re;
	}
	//判断号码是否在次期开奖号码中 红码
	private int isIn(int[] data,int number) {
		
		for(int i =0;i < data.length-1;i++) {
			
			if(number == data[i]) {
				
				return 1;
			}
		}
		
		return 0;
	}
	
	//判断该随机数列前几个数字包含的开奖号码个数 data为开奖号码，n为参数，seq 为随机数列 单期
	private int baohangeshu(int[] data,int[] seq,int n) {
	
		int count = 0;
		
		for(int i = 0;i < n; i++) {
			
			if(this.isIn(data, seq[i])==1) {
				
				++count;
			}
			
		}
	
		return count;
	}
	
	//判断该随机数列前几个数字包含的开奖号码个数 data为开奖号码，n为参数，seq 为随机数列 多期
	public int[] baohangeshu(int[][] data,int[] seq,int n) {
		
		int[] count = new int[data.length];
		
		for(int i =0;i<count.length;i++) {
			
			count[i] = this.baohangeshu(data[i], seq, n);
		
		}
		
		return count;
	
	}
	
	//根据count的情况推算出这组数列是否可用
	public boolean isUseful(int[] count) {
		
		
		
		return false;
	}
	
	//统计count数列中“0”出现的频度
	private double countZero(int[] count) {
		
		int countzero = 0;
		
		int[] zero = new int[count.length/4];
		
		int count_temp =0;
		
		int sum =0;
		
		//求出出现“0”的时机，次数
		for(int i =0;i<count.length;i++) {
			
			if(count[i] == 0) {
				
				++countzero;
				
				zero[count_temp] = i;
				
				++count_temp;
			}
		}
		
		for(int i =0;i<count_temp;i++) {
			
			
			
		}
		
		return 0;
		
	}
	
	
	
	

}
