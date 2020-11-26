package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private final MyFunction function;
    private Object[] array;
    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.array = smartArray.toArray();
        this.function = func;
        this.array = changeElements();

    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator. Changes all elements " +
                "using the function.";
    }

    @Override
    public int size() {
        return this.array.length;
    }

    public Object[] changeElements() {
        Object[] origArray = this.smartArray.toArray();
        Object[] newArray = new Object[origArray.length];
        int ind = 0;
        for (int i = 0; i < origArray.length; i++){
                newArray[i] = this.function.apply(origArray[i]);
            }
        return newArray;
    }
}
