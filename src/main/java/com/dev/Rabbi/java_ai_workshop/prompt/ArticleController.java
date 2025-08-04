package com.dev.Rabbi.java_ai_workshop.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    private final ChatClient chatClient;

    public ArticleController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping("/post/new")
    public String newPost(@RequestParam(value = "topic", defaultValue = "JDK virtual tread") String topic) {
        return null; //Left of
    }
}
