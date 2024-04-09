package org.example.ai.actions.direct;

import com.dingtalk.open.app.api.OpenDingTalkClient;
import com.dingtalk.open.app.api.OpenDingTalkStreamClientBuilder;
import com.dingtalk.open.app.api.security.AuthClientCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author feiyin
 * @date 2024/4/8
 */
@Configuration
public class StreamClientConfigure {

    @Value("${dingtalk.app.client-id}")
    private String clientId;

    @Value("${dingtalk.app.client-secret}")
    private String clientSecret;

    @Value("${server.port}")
    private int port;

    @Bean(initMethod = "start")
    public OpenDingTalkClient configure() {
        return OpenDingTalkStreamClientBuilder.custom()
                .credential(new AuthClientCredential(clientId, clientSecret))
                .forwardGraphRequestToHTTP(port)
                .build();
    }
}
