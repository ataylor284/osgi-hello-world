package ca.redtoad.osgi.hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext ctx) {
        System.out.println("Hello world.");
    }

    public void stop(BundleContext bundleContext) {
    }
}
