package locator;

/**
 * Created by root on 6-6-14.
 */
public interface IServiceLocator {
    public <T> T getService(Class<T> key);
}
