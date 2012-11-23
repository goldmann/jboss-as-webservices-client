package pl.goldmann.as7.ws.client;

import pl.goldmann.as7.ws.Calculator;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Client {

    public static void main(String args[]) throws Exception {

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());

        factory.setServiceClass(Calculator.class);
        factory.setAddress("http://jboss-as:8080/webservices");

        Calculator client = (Calculator) factory.create();

        System.out.println("1 + 3 = " + client.add(1,3));
        System.out.println("2 - 4 = " + client.sub(2,4));
        System.out.println("2 * 7 = " + client.multiply(2,7));
        System.out.println("3 / 7 = " + client.divide(3,7));
    }
}
