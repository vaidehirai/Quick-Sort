package randomisedquicksort;

import java.util.ArrayList;
import java.util.Scanner;

class Quick
{
    public Integer[] sort(Integer a[],int p,int q,int r)
    {
        System.out.println("r: "+r);
        ArrayList<Integer> sArr=new ArrayList<>();
        ArrayList<Integer> tArr=new ArrayList<>();
       
        int s=0,t=0,k=0;
        
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<a[r])
                sArr.add(a[i]);
            else if(a[i]>a[r])
                tArr.add(a[i]);
        }
        
        System.out.print("s array: ");
        for(int i=0;i<sArr.size();i++)
            System.out.print(sArr.get(i)+" ");
        System.out.println("");
        
        System.out.print("t array: ");
        for(int i=0;i<tArr.size();i++)
            System.out.print(tArr.get(i)+" ");
        System.out.println("");
        
        s=sArr.size();
        t=tArr.size();
        
        System.out.println("s: "+s+" t:"+t);
        
        if(s>=(Math.ceil((q-p)/4)) || t>=(Math.ceil((q-p)/4)))
        {
            a[s]=a[r];
        
            for(int i=0;i<s;i++)
                a[i]=sArr.get(i);
            
            for(int i=s+1;i<a.length;i++)
            {
                a[i]=tArr.get(k);
                k++;
                if(k>(tArr.size()-1))
                    break;
            }
        }
        else
            System.out.println("not valid s or t");
        
        System.out.println("\n");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println("");
        
        return a;
    }
    
    //checking if sortArr is sorted or not
    public boolean isSorted(Integer sortArr[])
    {
        int count=0;
        for(int j=0;j<=sortArr.length-2;j++)
        {
            if(sortArr[j]>sortArr[j+1])
                return false;
        }
        
        return true;
    }
}
public class RandomisedQuickSort {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of elements: ");
        int n=sc.nextInt();
        Integer arr[]=new Integer[n];
        
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
        
        Integer sortArr[]=new Integer[arr.length];
        boolean flag=false;
        int count=0;
        
        Quick q=new Quick();
        
        long begin=System.currentTimeMillis();
        while(flag!=true)
        {
            double random=Math.random()*10000;
            int r=(int)(random%(arr.length));

            sortArr=q.sort(arr,0,arr.length-1,r);

            arr=sortArr;
            flag=q.isSorted(arr);
        }
        long end =System.currentTimeMillis();
        
        System.out.println("");
        System.out.println("Result: ");
        for(int i=0;i<sortArr.length;i++)
            System.out.print(sortArr[i]+" ");
        System.out.println("");
        
        
        System.out.println("Time required "+(end-begin)+" ms.");
    }
    
}
