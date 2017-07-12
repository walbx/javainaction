package me.aloo.javainaction.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by walbx on 2017/7/12.
 */
@RestController
@RequestMapping("/fort")
@Api(value = "For test", description = "Provide for testing")
public class ForT {
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ApiOperation(value = "Greeting")
    public String greeting(@RequestParam(value = "word", defaultValue = "World") String word) {
        return String.format(TEMPLATE, word);
    }
}
