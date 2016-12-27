package me.jpomykala.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evelan on 26/12/2016.
 */
@RestController
public class ExampleApi {

    @GetMapping("/api")
    public Map<String, String> restrictedResource() {
        Map<String, String> out = new HashMap<>();
        out.put("Hello", "World");
        return out;
    }


}
