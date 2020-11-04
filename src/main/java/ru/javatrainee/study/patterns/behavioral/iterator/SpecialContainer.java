package ru.javatrainee.study.patterns.behavioral.iterator;

public class SpecialContainer implements Container{

    private String [] arr = {"A","B","C"};

    public Iterator getIterator(){
        return new SpecialIterator();
    }

    private class SpecialIterator implements Iterator{

        private int index;

        @Override
        public boolean hasNext() {
            return index < arr.length;
        }

        @Override
        public Object next() {
            return arr[index++];
        }
    }
}
