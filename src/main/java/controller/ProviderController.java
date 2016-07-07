package controller;

import com.google.common.collect.Maps;
import service.BaseService;
import service.SayHelloService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lucifer on 2016-7-7.
 */
public class ProviderController extends HttpServlet {
    private static Map<String, BaseService> serviceMap;

    {
        serviceMap = Maps.newHashMap();
        serviceMap.put("service.sayhello", new SayHelloService());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String service = request.getParameter("service");
        String format = request.getParameter("format");
        Map parameters = request.getParameterMap();

        BaseService baseService = serviceMap.get(service);
        Object result = baseService.execute(parameters);

        response.getWriter().write((String) result);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
