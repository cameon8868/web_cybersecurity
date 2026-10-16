
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Отдаём HTML на "/"
        server.createContext("/", exchange -> {
            byte[] bytes = Files.readAllBytes(Paths.get("html/index.html"));
            exchange.sendResponseHeaders(200, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        });

        // Принимаем форму на "/Form"  ← как в action=""
        server.createContext("/Form", exchange -> {
            String body = new String(
                exchange.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
            );

            Map<String, String> params = parseForm(body);
            String login    = params.get("login");      // ← name="login"
            String password = params.get("password");   // ← name="password"

            System.out.println("Login: " + login + ", Password: " + password);

            // Ответ клиенту
            String response = "Hi, " + login + "!";
            byte[] out = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, out.length);
            exchange.getResponseBody().write(out);
            exchange.close();
        });

        //Принимает CSS файл
        server.createContext("/css", exchange -> {
            byte[] bytes = Files.readAllBytes(Paths.get("./css/style.css"));
            exchange.getResponseHeaders().set("Content-Type", "text/css; charset=utf-8");
            exchange.sendResponseHeaders(200, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.close();
        });
        //Принимает Js файл
        server.createContext("/js", exchange -> {
        byte[] bytes = Files.readAllBytes(Paths.get("./js/main.js"));
        exchange.getResponseHeaders().set("Content-Type", "application/javascript; charset=utf-8");
        exchange.sendResponseHeaders(200, bytes.length);
        exchange.getResponseBody().write(bytes);
        exchange.close();
});

        server.start();
        System.out.println("Open http://localhost:8080");
    }

    private static Map<String, String> parseForm(String body) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        for (String pair : body.split("&")) {
            String[] kv = pair.split("=");
            if (kv.length == 2) {
                map.put(
                    URLDecoder.decode(kv[0], "UTF-8"),
                    URLDecoder.decode(kv[1], "UTF-8")
                );
            }
        }
        return map;
    }
}