package ro.teamnet.hello;

import org.junit.Test;

/**
 * Created by Florin on 22.04.2015.
 */
public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }


}
