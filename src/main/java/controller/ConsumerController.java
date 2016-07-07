package controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by lucifer on 2016-7-6.
 */
public class ConsumerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String service = "service.sayhello";
        String format = "json";
        String arg1 = "hello";

        String url = String.format("http://localhost:8080/provider.do?service=%s&format=%s&arg1=%s", service, format, arg1);

        // 组装请求
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        // 接收响应
        HttpResponse httpResponse = httpClient.execute(httpGet);

        HttpEntity entity = httpResponse.getEntity();
        byte[] bytes = EntityUtils.toByteArray(entity);
        String jsonResult = new String(bytes, Charset.defaultCharset());

        response.getWriter().write(jsonResult);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
