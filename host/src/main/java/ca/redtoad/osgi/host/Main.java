package ca.redtoad.osgi.host;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, String> config = new HashMap<String, String>();
        //config.put("org.osgi.framework.executionenvironment", "J2SE-1.8,JavaSE-1.8");
        config.put("org.osgi.framework.system.capabilities", "osgi.ee; osgi.ee=\"OSGi/Minimum\"; version:List<Version>=\"1.0,1.1,1.2\", osgi.ee; osgi.ee=\"JavaSE\"; version:List<Version>=\"1.0,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8\", osgi.ee; osgi.ee=\"JRE\"; version:List<Version>=\"1.0,1.1\", osgi.ee; osgi.ee=\"JavaSE/compact1\"; version:List<Version>=\"1.8\", osgi.ee; osgi.ee=\"JavaSE/compact2\"; version:List<Version>=\"1.8\", osgi.ee; osgi.ee=\"JavaSE/compact3\"; version:List<Version>=\"1.8\"");
        ServiceLoader<FrameworkFactory> factoryLoader = ServiceLoader.load(FrameworkFactory.class);
        Framework framework = Optional.of(factoryLoader.iterator().next())
            .map(factory -> factory.newFramework(config))
            .orElseThrow(() -> new IllegalStateException("Unable to load FrameworkFactory service"));
        framework.init();
        framework.start();

        BundleContext bundleContext = framework.getBundleContext();
        Bundle bundle = bundleContext.installBundle(args[0]);
        bundle.start();
        bundle.stop();
    }
}
