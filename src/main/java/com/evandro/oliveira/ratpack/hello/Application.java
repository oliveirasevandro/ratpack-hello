package com.evandro.oliveira.ratpack.hello;

import com.evandro.oliveira.ratpack.hello.filter.RequestValidatorFilter;
import com.evandro.oliveira.ratpack.hello.pojo.Employee;
import ratpack.jackson.Jackson;
import ratpack.server.RatpackServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eso on 17/03/17.
 */
public class Application {

    public static void main(String[] args) throws Exception {

//      Creates some mock data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Mr", "John Doe"));
        employees.add(new Employee(2L, "Mr", "White Snow"));

        RatpackServer.start(server -> server.handlers(chain -> chain
//                It can be achieved by using a Handler. (i.e.: RequestValidatorFilter)
//                .all(ctx -> {
//                    MutableHeaders headers = ctx.getResponse().getHeaders();
//                    headers.set("Access-Control-Allow-Origin", "*");
//                    headers.set("Accept-Language", "en-us");
//                    headers.set("Accept-Charset", "UTF-8");
//                    ctx.next();
//                })
                .all(new RequestValidatorFilter())
                .get(ctx -> ctx.render("Welcome to Ratpack Hello"))
                .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!!!"))
                .get("data/employees", ctx -> ctx.render(Jackson.json(employees)))
        ));

    }
}
