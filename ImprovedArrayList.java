public class ImprovedArrayList implements MyList
{
    private int size;
    private Object[] data;
    
    public ImprovedArrayList()
    {
        // Let the other constructor do the work!
        this(0);
    }

    public ImprovedArrayList(int x)
    {
        size = 0;
        data = new Object[x];
    }

    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(Object obj)
    {
        if(size() + 1 >= data.length){
            Object[] newData = new Object[data.length > 0? data.length * 2:1];
            for(int i = 0; i < data.length; i++)
                newData[i] = data[i];
            data = newData;
        }
        data[size()] = obj;
        size++;
        return true;       
    }

    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj)
    {   
        if(size() + 1 >= data.length){
            Object[] newData = new Object[data.length > 0? data.length * 2:1];
            for(int i = 0; i < data.length; i++)
                newData[i] = data[i];
            data = newData;
        }
        if(index <= 0)
        {
            for(int i = size(); i > 0; i--)
            {
                data[i] = data[i-1];
            }
            data[0] = obj;
            size++;
        }
        else{
            for(int i = size()+1; i > index;i--)
            {
               data[i] = data[i-1];
            }
            data[index] = obj;
            size++;
        }
    }

    public boolean contains(Object obj)
    {
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] ==(null))
                continue;
            if(data[i].equals(obj))
            return true;
        }
        return false;
    }
    
    public Object get(int index)
    {
        if(index > data.length - 1 || index < 0)
            return null;
        return data[index];
    }

    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        if(data.equals(null))
            return false;
        if(size() == 0)
            return true;
        return false;
    }

    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     */
    public Object remove(int index)
    {
        if(data.equals(null) || index >= data.length || index < 0 || index >= size())
        return null;
        Object removed = data[index];
        for(int i = index + 1; i <= size(); i++)
            data[i-1] = data[i];
        size--;
        return removed;
    }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(Object obj)
    {
        for(int i = 0; i < data.length; i++){
        if(data[i] == null)
            continue;
        if(data[i].equals(obj)){
            remove(i);
            return true;
        }
      }
      return false;
    }

    public Object set(int index, Object obj)
    {
        if(data.equals(null) || obj.equals(null) || index >= data.length || index < 0 || data[index] == null)
            return null;
        Object replaced = data[index];
        data[index] = obj;
        return replaced;
    }
    
    public int size()
    { 
        return size;
    }
}