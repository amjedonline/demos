
package de.zalando.sample;

import javax.jws.WebService;

@WebService(endpointInterface = "de.zalando.sample.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

