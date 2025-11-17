package com.codeline.ccsb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        if (name.isEmpty()) {
            return "Hello Guest";
        }
        return "Hello " + name;
    }

    @GetMapping("/sum")
    public Integer sum(@RequestParam int a, int b) {
        return a + b;
    }

    @GetMapping("/info")
    public Map<String, String> info(){
        Map<String, String> info = new LinkedHashMap<>();
        info.put("Name", "Hawraa");
        info.put("City", "Muscat");
        info.put("Language", "Arabic");
        return info;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/upper")
    public String text(@RequestParam String text) {
        return text.toUpperCase();
    }

    @GetMapping("/random")
    public Integer random() {
        return new Random().nextInt(100) + 1;
    }
}