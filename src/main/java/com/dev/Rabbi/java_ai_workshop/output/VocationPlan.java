package com.dev.Rabbi.java_ai_workshop.output;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VocationPlan {
    private final ChatClient chatClient;


    public VocationPlan(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/vocation/unstructured")
    public String unstructured() {
        return chatClient
                .prompt()
                .user("I want to plan a trip to Hawaii. Give me a list of things to do.")
                .call()
                .content();
    }
    @GetMapping("/vocation/structured")
    public Itinerary structured(@RequestParam(value = "destination",defaultValue = "New york, NY") String destination) {
        return chatClient.prompt()
                .user(u -> {
                    u.text("What's a good vocation plan while I'm in {destination} for 3 days?");
                    u.param("destination", destination);
                })
                .call()
                .entity(Itinerary.class);
    }
}
