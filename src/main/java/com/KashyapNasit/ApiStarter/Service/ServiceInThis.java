package com.KashyapNasit.ApiStarter.Service;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


@Service
public class ServiceInThis  {

    private Logger logger = LoggerFactory.getLogger(ServiceInThis.class);

    @Autowired
    ServiceInThis(){
        logger.debug("Service started");
    }

    public Integer getMun(Integer num1, Integer num2){
        return num1*num2;
    }

}
