package com.vd.producer.controllers;

import com.vd.producer.domain.Message;
import com.vd.producer.repositories.MessageWriterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerResource {

    private MessageWriterRepository messageWriterRepository;

    private EmitterProcessor<String> processor;

    public ProducerResource(MessageWriterRepository messageWriterRepository,
                            EmitterProcessor<String> processor) {
        this.messageWriterRepository = messageWriterRepository;
        this.processor = processor;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Mono<Void> createMessage(@RequestBody Flux<Message> messages) {
        //TODO: update code to send the message/s
        this.processor.onNext("Test123");
        return messages.map(message -> {
            log.info("About to save the message to the DB");
            return messageWriterRepository.save(message).subscribe();
        })
                .then();
    }

}
