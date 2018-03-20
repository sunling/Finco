package finco.framework.proxy;

/**
 * @author: Enkhbayasgalan Galsandorj
 */
public class EmptyProxyFunc<T> implements ProxyFunctor<T> {
    @Override
    public void pre(T o) {
        // do nothing
    }

    @Override
    public void post(T o) {
        // do nothing
    }
}
