package com.eligibility_service.config;



import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EligibilityMessagingConfig {

     public static final String QUEUE_1= "Eligibility_Queue";

    public static final String EXCHANGE_1= "Eligibility_Exchange";

    public static final String ROUTING_KEY_1=  "Eligibility_Routing_key";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE_1);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_1);
    }
    @Bean
    public Binding binding(Queue queue,TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_1);
    }
    @Bean
    public MessageConverter  converter(){
        return new Jackson2JsonMessageConverter();
    }
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate= new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
