package me.aloo.javainaction.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

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

    @RequestMapping(value = "/copycat", method = RequestMethod.GET)
    @ApiOperation(value = "copycat")
    public String copycat(@RequestParam(value = "word") String word,
                          @RequestParam(value = "decode") String decode,
                          @RequestParam(value = "encode") String encode) {
        BufferedWriter wr = null;
        try {
            System.out.println("system------------" + System.getProperty("file.encoding"));
            wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:/aaac.txt"), encode));
            String s = new String(word.getBytes(decode), encode);
            System.out.println("word1---------------" + s);
            wr.write(s);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                wr.close();
            } catch (Exception e) {

            }
        }
        return "OK";
    }

}
