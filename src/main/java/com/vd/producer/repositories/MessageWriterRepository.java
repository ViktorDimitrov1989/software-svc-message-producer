package com.vd.producer.repositories;

import com.vd.producer.domain.Message;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MessageWriterRepository
        extends org.springframework.data.repository.Repository<Message, String> {

    Mono<Message> save(Message message);

    //Needed to support save()
    Mono<Message> findById(String id);

}
