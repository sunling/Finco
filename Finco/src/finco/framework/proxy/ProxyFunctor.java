package finco.framework.proxy;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public interface ProxyFunctor<T> {
    void pre(T t);
    void post(T t);
}
