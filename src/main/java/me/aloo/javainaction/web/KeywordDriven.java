package me.aloo.javainaction.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.aloo.javainaction.action.keyworddriven.Loader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;

/**
 * Created by walbx on 2017/7/12.
 */
@RestController
@RequestMapping("/key")
@Api(value = "keyword driven", description = "keyword driven by reflect")
public class KeywordDriven {

    private static String SCRIPT_PATH = "E:/222.txt"; //文件内容：callByScript

    /**
     * 先把函数名和函数建立映射关系,java里面就是函数名和Method对象建立映射关系,然后解析脚本
     * 遇到指定符号开头(本例未指定符号),判断是不是方法  如果是  就从映射表里面查到对应的Method 然后调用
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    @ApiOperation(value = "simpleDemo")
    public String simpleKey() throws Exception {

        System.out.println("methodname -----------");
            new Loader().init();
            BufferedReader fr = new BufferedReader(new FileReader(SCRIPT_PATH));
            String methodName = fr.readLine();
            System.out.println("methodname -----------" + methodName);
            Method method = Loader.METHOD_MAP.get(methodName);
        /*
         * 第一个参数是方法所属对象，如果是静态方法，该参数将被忽略，所以可以为Null
         * 第二个参数是方法的入参，如果方法没有入参，该参数可以是length为0的数组，或者null
         */
            Object result = method.invoke(null, (Object[]) null);
            return result.toString();


    }
}
