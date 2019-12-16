package com.example;

import com.example.producer.MyProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private MyProvider provider;

    @Test
    void contextLoads() {
        provider.send();
    }

}
