package cn.chenyh.ssq.model;

public class Sort {
	
	//http://zhaolinjnu.blog.sohu.com/109278177.html何并排序
	public void MergeSort(int a[],int left,int right)
    {
     //合并排序，递归算法,利用分治策略
     if(left<right)
     {
      //至少需要两个元素
      int mid=(left+right)/2;
      //对左侧排序
      MergeSort(a,left,mid);
      //对右侧排序
      MergeSort(a,mid+1,right);
      //合并两段排序数组到数组b中,再拷贝回a中
      merge(a,left,mid,right);       
     }
    }
    
    private void merge(int c[],int left,int mid,int right)
    {
     //合并两段排序数组到数组d中
     int d[]=new int[right-left+1];
     int i,j,k;
     i=left;
     j=mid+1;
     //k为d数组的下标
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
     //将d中数组再拷贝回c中
     int pos=left;
     for(k=0;k<=d.length-1;k++)
     {
      c[pos]=d[k];
         pos++;
     }
    }


}
