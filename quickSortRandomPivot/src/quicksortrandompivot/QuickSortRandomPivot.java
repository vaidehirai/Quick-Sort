package quicksortrandompivot;

import java.util.ArrayList;
import java.util.Scanner;

class Quick
{
    int q;
    int counts=0;
    
    public void quickSort(int aa[],int pp,int rr)
    {
        if(pp<rr)
        {
            q=partitionSwap(aa,pp,rr);
            quickSort(aa,pp,q-1);
            quickSort(aa,q+1,rr);
        }
    }
    
    public int partitionSwap(int a[],int p,int r)
    {
        int swappedValues[],swappedIndexes[],qq;
        double random=Math.random();
        random=random*10000;
        
        int rand=(int)((random%(r-p+1))+p);
        System.out.println("r is "+r);
        
        if(rand!=r)
        {
            swappedValues=swap(a[r],a[rand]);
            a[r]=swappedValues[0];
            a[rand]=swappedValues[1];

            q=partition(a,p,r);
        }
        else if(rand==r)
            q=partition(a,p,r);
        
        return q;
    }
    
    public int partition(int a[],int p,int r)
    {
        int swappedArr[],swappedArr1[],swappedArr2[];
        
        int pivot=a[r];
        int i=p-1;
        
        for(int j=p;j<r;j++)
        {
            if(a[j]<pivot)
            {
                i=i+1;
                
                swappedArr1=swap(a[i],a[j]);
                a[i]=swappedArr1[0];
                a[j]=swappedArr1[1];
            }
        }
        
        swappedArr2=swap(a[i+1],a[r]);
        a[i+1]=swappedArr2[0];
        a[r]=swappedArr2[1];
        
        for(int z=0;z<a.length;z++)
            System.out.print(a[z]+" ");
        System.out.println(" ");
        
        return i+1;
    }
    
    public int[] swap(int x, int y)
    {
        int temp=0;
        temp=x;
        x=y;
        y=temp;
        
        int w[]={x,y};
        return w; 
    }
}
public class QuickSortRandomPivot {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        
        ArrayList<Integer> checkArr=new ArrayList<>();
        
        int w=0;
        while(w<n)
        {
            double random=Math.random();
            random=random*10000;
            Integer rand=(int)(random%n);
            if(!checkArr.contains(rand))
            {
                checkArr.add(rand);
                arr[w]=rand;
                w++;
            }   
        }
        
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
        
        Quick q=new Quick();
        long begin=System.currentTimeMillis();
        q.quickSort(arr,0,arr.length-1);
        long end =System.currentTimeMillis();
        
        System.out.println("Time required "+(end-begin)+" ms.");
        
    }
}
