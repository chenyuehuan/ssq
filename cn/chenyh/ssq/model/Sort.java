package cn.chenyh.ssq.model;

public class Sort {
	
	//http://zhaolinjnu.blog.sohu.com/109278177.html�β�����
	public void MergeSort(int a[],int left,int right)
    {
     //�ϲ����򣬵ݹ��㷨,���÷��β���
     if(left<right)
     {
      //������Ҫ����Ԫ��
      int mid=(left+right)/2;
      //���������
      MergeSort(a,left,mid);
      //���Ҳ�����
      MergeSort(a,mid+1,right);
      //�ϲ������������鵽����b��,�ٿ�����a��
      merge(a,left,mid,right);       
     }
    }
    
    private void merge(int c[],int left,int mid,int right)
    {
     //�ϲ������������鵽����d��
     int d[]=new int[right-left+1];
     int i,j,k;
     i=left;
     j=mid+1;
     //kΪd������±�
     k=0;
     while(i<=mid && j<=right)
     {
      if(c[i]>c[j])
      {
       d[k]=c[j];
       k++;
       j++;
      }
      else
      {
       d[k]=c[i];
       k++;
       i++;
      }
     }//end while
     
     for(int q=j;q<=right;q++)
      {
       d[k]=c[q];
       k++;
      }
     
     for(int q=i;q<=mid;q++)
      {
       d[k]=c[q];
       k++;
      }
     //��d�������ٿ�����c��
     int pos=left;
     for(k=0;k<=d.length-1;k++)
     {
      c[pos]=d[k];
         pos++;
     }
    }


}
