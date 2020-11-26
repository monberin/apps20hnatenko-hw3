package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private final MyComparator comparator;
    private Object[] array;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        this.comparator = comp;
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, comparator);
        this.array = arr;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator. Sorts all elements in the array using comparator.";

    }

    @Override
    public int size() {
        return this.array.length;
    }
}
