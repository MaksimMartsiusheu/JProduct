package com.jhipster.listener;

import com.jhipster.domain.EntityEvent;
import com.jhipster.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

@Component
public class KafkaDeletedMessageListener {

    private final ProductRepository productRepository;

    @Autowired
    public KafkaDeletedMessageListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @StreamListener(Processor.INPUT)
    public void consumeEmployeeDetails(EntityEvent entityEvent) {
        productRepository.changeCategoryToDefault(entityEvent.getEntityId());
    }
}
