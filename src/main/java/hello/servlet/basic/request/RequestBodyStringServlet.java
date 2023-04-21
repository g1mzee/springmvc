package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); //request의 데이터를 바이트코드로 얻어온다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //바이트코드데이터를 String으로 전환(utf-8)
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
