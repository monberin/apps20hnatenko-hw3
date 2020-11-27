package ua.edu.ucu.smartarr;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private Object[] array;

    public DistinctDecorator(SmartArray smartArray) {

        super(smartArray);
        this.array = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];

        int finalSize = 0;

        int repeated;
        for (Object o : array) {
            repeated = 0;
            for (Object obj : newArray) {
                if (o.equals(obj)) {
                    repeated += 1;
                    break;
                }
            }
            if (repeated == 0) {
                newArray[finalSize++] = o;
            }
        }

        Object[] finalArray = new Object[finalSize];
        System.arraycopy(newArray, 0, finalArray, 0, finalSize);
        this.array = finalArray;

    }

    @Override
    public Object[] toArray() {

        return this.array.clone();
    }

    @Override
    public String operationDescription() {
        return "Removes all repeating elements from the array.";
    }

    @Override
    public int size() {
        return this.array.length;
    }

}

