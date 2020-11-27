package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final Object[] array;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, comp);
        this.array = arr;
    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator. Sorts all elements"
                + " in the array using comparator.";

    }

    @Override
    public int size() {
        return this.array.length;
    }
}
