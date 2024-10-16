package com.example.trello.domain.slack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@EnableAspectJAutoProxy
@SpringBootTest
class SlackServiceTest {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SlackService slackService;

    @Test
    @DisplayName("Slack AOP Test")
    void test1(){
        slackService.SlackTest();
    }

    @Test
    @DisplayName("Slack AOP Member Add Test")
    void test2(){
        String name = "test";
        slackService.memberAddSlackTest(name);
    }

}