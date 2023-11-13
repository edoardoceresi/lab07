package it.unibo.inner.api;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IterableWithPolicyImplementation<T> implements IterableWithPolicy<T>{

    private final List<T> elements;

    public IterableWithPolicyImplementation(final T[] elements){
        this.elements = List.of(elements);
    }

    public void setIterationPolicy(Predicate<T> filter){
    }

    private class InnerIterableWithPolicyImplementationIterator implements Iterator<T> {

        private int index = 0;

        @Override 
        public boolean hasNext() {
            if(index < elements.size() && index >= 0){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            if(hasNext()){
                return elements.get(index++);
            } 
            throw new NoSuchElementException();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
   
    public Iterator<T> iterator() {
        return new InnerIterableWithPolicyImplementationIterator();
    }
}