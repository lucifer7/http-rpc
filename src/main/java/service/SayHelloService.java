package service;

import java.util.Map;

/**
 * Created by lucifer on 2016-7-6.
 */
public class SayHelloService implements BaseService {
    public Object execute(Map<String, Object> args) {
        //resultMap.getParameterMap();
        String[] helloArgs = (String[]) args.get("arg1");

        if ("hello".equals(helloArgs[0])) {
            return "hello";
        } else {
            return "bye";
        }
    }
}
