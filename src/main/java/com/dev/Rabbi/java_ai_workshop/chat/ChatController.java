package com.dev.Rabbi.java_ai_workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .build();
    }

    @GetMapping("/")
    public String joke(@RequestParam(value = "message", defaultValue = "Tell me a dad joke about Dogs") String message) {
        return chatClient.prompt().user(message).call().content();
    }
    @GetMapping("/stream")
    public Flux<String> stream() {
        return chatClient.prompt("What is the capital of China?").stream().content();
    }
}
