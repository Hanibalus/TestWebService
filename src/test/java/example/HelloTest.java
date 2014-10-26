package example;

import client.HelloWorldService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;


public class HelloTest {

    HelloWorldService helloWorldService = new HelloWorldService();

    @Before
    public void init(){

    }

    @Test
    public void testSayHelloWorldFrom() throws Exception {
        String response = helloWorldService.getHelloWorldPort().sayHelloWorldFrom("Eugen");
        System.out.println(response);
        Assert.assertEquals(response, "Hello, world, from Eugen");

    }

    @Test
    public void testSayHelloWorldFrom2() throws Exception {

        URL url = new URL("http://localhost:8080/TestWebService/service/HelloWorld?wsdl");
        QName qname = new QName("http://example/", "HelloWorldService");

        Service service = Service.create(url, qname);
        client.HelloWorld hello = service.getPort(client.HelloWorld.class);

        String response = hello.sayHelloWorldFrom("Eugen");
        System.out.println(response);
        Assert.assertEquals(response, "Hello, world, from Eugen");

    }
}