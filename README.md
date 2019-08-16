OSGI Hello World
================

Hello world with OSGI using the felix framework.

To run:

    cd client
    mvn install
    cd ../host
    mvn install
    java -jar target/osgi-hello-world-host-1.0.0.jar file:../client/target/osgi-hello-world-bundle-1.0.0.jar

TODO:

* Discover an OSGI service defined in client and run from host
