package finco.framework.functor;

/**
* @author Sumit Wankhede
*/

public interface Functor<T, R> {

    public void compute(T localDataObject);

    public R getResult();
}
