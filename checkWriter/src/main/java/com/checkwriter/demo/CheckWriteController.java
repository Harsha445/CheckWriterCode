package com.checkwriter.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CheckWriteController {
	
	

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "name-----"+name;
    }
    
    @RequestMapping("/checkWriter")
    public String checkWriter(@RequestParam(value="name", defaultValue="0.00") double value) {
        return CheckWriteUtil.doubleConvert(value);
    }
	
   
}
