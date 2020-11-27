package ua.edu.ucu.smartarr;


import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate predicate;
    private Object[] array;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicat) {
        super(smartArray);
        this.array = smartArray.toArray();
        this.predicate = predicat;
        this.array = removeElements();

    }

    @Override
    public Object[] toArray() {
        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "Removes all elements that do not pass " +
                "the predicate test from the array.";
    }

    @Override
    public int size() {
        return this.array.length;
    }


    public Object[] removeElements() {
        Object[] origArray = this.smartArray.toArray();
        Object[] newArray = new Object[origArray.length];
        int ind = 0;
        for (Object o : origArray) {
            if (predicate.test(o)) {
                newArray[ind] = o;
                ind += 1;
            }
        }
        Object[] finalArray = new Object[ind];
        System.arraycopy(newArray, 0, finalArray, 0, ind);
        return finalArray;
    }
}
