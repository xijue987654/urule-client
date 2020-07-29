package com.xijue.uruleclient;

import org.springframework.stereotype.Component;

@Component
public class URuleServletRegistration {
    // 此Servlet用于接收Urule服务端发布的知识包，使用开源版本时删除或者注释这个bean
//    @Bean
//    public ServletRegistrationBean registerURuleServlet() {
//        return new ServletRegistrationBean(new KnowledgePackageReceiverServlet(), "/knowledgepackagereceiver");
//    }
}