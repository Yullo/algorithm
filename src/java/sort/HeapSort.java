package sort;

/**
 * Created by painsolace on 2017/4/26.
 * 最大堆及堆排序，来自网友
 *
 */
public class HeapSort {
    //调整节点 大根堆
    public void AdjustHeapNode(int a[],int i,int n){ //调整节点i，数组共有N个节点


        if (n==1|| i > (n-2)/2)  //i为叶子节点  (n-2)/2 最后一个非叶子节点的位置
            return;

        int iLeft=2*i+1;
        int iRight=2*i+2;


        if (iRight<=n-1)     //说明i有左右两个子节点         三个节点找最大值
        {
            if (a[i]>=a[iLeft]&&a[i]>=a[iRight])      // i 最大 不用调整
                return;

            if (a[i]<a[iLeft]&&a[iRight]<=a[iLeft])  // iLeft 最大
            {
                int temp=a[iLeft];
                a[iLeft]=a[i];
                a[i]=temp;
                AdjustHeapNode(a,iLeft,n);
                return;
            }

            if (a[i]<a[iRight]&&a[iLeft]<=a[iRight]) // iRight 最大
            {
                int temp=a[iRight];
                a[iRight]=a[i];
                a[i]=temp;

                AdjustHeapNode(a,iRight,n);
                return;
            }

        }else{ // 说明i只有左节点   二个节点找最大值

            //iLeft为最后一个节点


            if (a[i]>=a[iLeft])
                return;
            else
            {
                int temp=a[iLeft];
                a[iLeft]=a[i];
                a[i]=temp;
                AdjustHeapNode(a,iLeft,n);
                return;
            }

        }
    }

    //从最后一个非叶子节点向前开始，调整推
    public void CreateHeap(int a[],int n)  //n为数组个数
    {

        int iFirst=(n-2)/2; //最后一个非叶子节点

        for (;iFirst>=0;iFirst--)
        {
            AdjustHeapNode(a,iFirst,n);
        }


    }

    //堆排序
    //建立大顶堆排序，排序结果为从小到大
    //建立小顶堆排序，排序结果为从大到小
    public void HeapSort(int a[],int n)
    {

        CreateHeap(a,n);

        int temp;
        for (int i=0;i<n-1;i++)
        {
            temp=a[n-1-i];
            a[n-1-i]=a[0];
            a[0]=temp;

            AdjustHeapNode(a,0,n-1-i);
        }

    }

}
