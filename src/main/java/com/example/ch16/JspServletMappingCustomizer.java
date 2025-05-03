package com.example.ch16;

import org.apache.catalina.Wrapper;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class JspServletMappingCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addContextCustomizers(context -> {
            final Wrapper jspServlet = (Wrapper) context.findChild("jsp");
            jspServlet.removeMapping("*.jsp");
            jspServlet.addMapping("/WEB-INF/views/*");
        });
    }
}
