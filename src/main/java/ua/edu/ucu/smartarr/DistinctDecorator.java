package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] array;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.array = smartArray.toArray();
        Object[] arr = smartArray.toArray();
        int i = 0;
        while (i < arr.length){
            arr = removeGivenElement(arr, arr[i],i);
            i += 1;
        }
        this.array = arr;

    }

    @Override
    public Object[] toArray() {

        return this.array;
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator. Removes all repeating elements from the array.";
    }

    @Override
    public int size() {
        return this.array.length;
    }

    public static Object[] removeGivenElement(Object[] array, Object element, int ind) {
        int index = 0;
        for (int i = ind; i < array.length; i++) {
            if (array[i].equals(element)) {
                array[index++] = array[i];
            }
        }
        Object[] newArray = new Object[index];
        System.arraycopy(array, 0, newArray, 0, index + 1);
        return newArray;
    }
}

