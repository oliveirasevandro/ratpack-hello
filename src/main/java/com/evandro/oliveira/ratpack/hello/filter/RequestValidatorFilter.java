package com.evandro.oliveira.ratpack.hello.filter;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.MutableHeaders;

/**
 * Created by eso on 17/03/17.
 */
public class RequestValidatorFilter implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {

        MutableHeaders headers = ctx.getResponse().getHeaders();
        headers.set("Access-Control-Allow-Origin", "*");
        ctx.next();
    }
}
