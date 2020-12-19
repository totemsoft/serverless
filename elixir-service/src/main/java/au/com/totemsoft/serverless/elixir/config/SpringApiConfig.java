package au.com.totemsoft.serverless.elixir.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import au.com.totemsoft.serverless.elixir.controller.ClientController;
import au.com.totemsoft.serverless.elixir.controller.SurveyController;
import au.com.totemsoft.serverless.elixir.service.ClientApiImpl;
import au.com.totemsoft.serverless.elixir.service.SurveyApiImpl;
import au.com.totemsoft.serverless.elixir.service.s3.AwsS3ServiceImpl;
import au.com.totemsoft.serverless.elixir.service.sqs.AwsSqsServiceImpl;
import au.com.totemsoft.serverless.elixir.service.workdocs.AwsWorkDocsServiceImpl;

@Configuration
@EnableWebMvc
@Import({
    SurveyController.class, ClientController.class,
    SurveyApiImpl.class, ClientApiImpl.class,
    AwsSqsServiceImpl.class,
    AwsWorkDocsServiceImpl.class,
    AwsS3ServiceImpl.class,
})
public class SpringApiConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
            .setSerializationInclusion(Include.NON_NULL)
            .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
            .enable (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable (DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            //.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm a z"))
            .registerModule(new AfterburnerModule());
    }

    /*
     * Create required HandlerMapping, to avoid several default HandlerMapping instances being created
     */
    @Bean
    public HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    /*
     * Create required HandlerAdapter, to avoid several default HandlerAdapter instances being created
     */
    @Bean
    public HandlerAdapter handlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

    /*
     * optimization - avoids creating default exception resolvers; not required as the serverless container handles
     * all exceptions
     *
     * By default, an ExceptionHandlerExceptionResolver is created which creates many dependent object, including
     * an expensive ObjectMapper instance.
     * 
     * To enable custom @ControllerAdvice classes remove this bean.
     */
    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
                return null;
            }
        };
    }

}
