package com.kitkitng.sample.serviceprovider;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
	Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);

	@Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/timeout")
    public String timeOut() throws Exception{
        Thread.sleep(7000);
        return "wait 7 seconds timeout";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
        	logger.info(s);
        }
        return "hello spring cloud!";
    }

    @RequestMapping(value = "/nice")
    public String nice(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
        	logger.info("gogogo" + s);
        }
        return "nice to meet you!";
    }
}
