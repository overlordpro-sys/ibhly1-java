
import java.util.*;

public class Sorts
{
    private long mySteps;   // disregard this for now

    public Sorts()
    {
        mySteps = 0;    // disregard this for now
    }

    public void bubbleSort(List <Comparable> arr)
    {
        for (int outer = 0; outer < arr.size() - 1; outer++, mySteps++)
        {
            for (int inner = 0; inner < arr.size() - outer - 1; inner++, mySteps++)
            {
                if (arr.get(inner).compareTo(arr.get(inner+1))  > 0)
                {                
                    Comparable temp = arr.get(inner);
                    arr.set(inner,arr.get(inner+1));
                    arr.set(inner+1,temp);
                    
                }
                
            }
        }
    } 

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(List <Comparable> arr)
    {
       int min;
        Comparable temp;

        for (int outer = 0; outer < arr.size() - 1; outer++)
        {
            min = outer;
            for (int inner = outer + 1; inner < arr.size(); inner++)
            {
                if (arr.get(inner).compareTo(arr.get(min)) < 0)
                    min = inner;  
                
            }
            temp = arr.get(outer);
            arr.set(outer,arr.get(min));
            arr.set(min,temp);
            
        }
    }    

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(List <Comparable> arr)
    {
       for (int outer = 1; outer < arr.size(); outer++)
        {
            int position = outer;
            Comparable key = arr.get(position);

            while (position > 0 && arr.get(position - 1).compareTo(key) > 0)
            {
                arr.set(position,arr.get(position-1));
                position--;
                
            }
            arr.set(position,key);
        }
    }

    //  Recursively divides a list in half, over and over. When the
    //  sublist has one or two values, stop subdividing.
    public void mergeSort(List <Comparable> list, int first, int last)
    {
        int len = last - first +1;
        if (len<=1)
        {
            
        }
        else if (len<=2)
        {
            if (list.get(first).compareTo(list.get(last)) > 0)
            {
                Comparable temp = list.get(first);
                list.set(first,list.get(last));
                list.set(last, temp);
                
            }
            
        }
        else
        {
            int mid = (first+last)/2;
            mergeSort(list, first, mid);
            mergeSort(list, mid+1, last);
            merge(list, first, mid, last);
            
        }
    }

    // creates a copy of ArrayList list called temp, and uses temp’s values to properly merge(sort) list
    // from first to last 

    public void merge(List<Comparable> list, int first, int mid, int last)   
    {
        int index1 = first;
        int index2 = mid+1;
        ArrayList<Comparable> copy = new ArrayList<Comparable>();
        for (Comparable val : list)
            copy.add(val);
        
        for (int i = first; i <= last; i++)
        {
            if (index1 > mid)
            {
                list.set(i, copy.get(index2));
                
                index2++;
            }
            else if (index2 > last)
            {
                list.set(i, copy.get(index1));
                
                index1++;
            }
            else if (copy.get(index1).compareTo(copy.get(index2))<0)
            {
                list.set(i, copy.get(index1));
                mySteps+=3;
                index1++;
            }
            else
            {
                list.set(i, copy.get(index2));
                mySteps+=4;
                index2++;
            }
        }
    }


    public void quickSort (ArrayList <Comparable> list, int first, int last){
      	int g = first, h = last;

      	int midIndex = (first + last) / 2;
      	Comparable dividingValue = list.get(midIndex);
      	do{
       		while (list.get(g).compareTo(dividingValue) < 0) 
       		{
       			g++;
       			
       		}
        	while (list.get(h).compareTo(dividingValue) > 0) 
        	{
        		h--;
        		
        	}
        	if (g <= h){
          		//swap(list[g], list[h]);
          		Comparable temp = list.get(g);
          		list.set(g, list.get(h));
          		list.set(h, temp);
          		g++;
          		h--;
        	}
        	
      	}while (g < h);
      	if (h > first) quickSort (list,first,h);
      	if (g < last) quickSort (list,g,last);
      }


    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return mySteps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount)
    {
        mySteps = stepCount;
    }   
}