package com.dean.Transcript.Controllers;

import com.dean.Transcript.Service.ServiceInThis;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class ControllerTemp {

    private ServiceInThis serviceInThis;
    private Logger logger = LoggerFactory.getLogger(ControllerTemp.class);

    @Autowired
    public ControllerTemp(ServiceInThis s){
        serviceInThis = s;
    }

    @RequestMapping(path = "/ping", method = RequestMethod.GET)
    public ResponseEntity<?> Ping(){
        logger.info("Working fine");
        return ResponseEntity.status(HttpStatus.OK).body("pong");
    }

    // URL : http://localhost:8000/do_this/2/?num2=25
    @RequestMapping(path = "/do_this/{num1}", method = RequestMethod.GET)
    public ResponseEntity<?> Transcript(@PathVariable Integer num1, @RequestParam(name="num2", required = false, defaultValue = "1") Optional<Integer> num2){
        JsonObject response = new JsonObject();
        logger.info(num1+""+num2);
        Integer ans = serviceInThis.getMun(num1,num2.get());
        response.addProperty("Mul",ans);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
}
