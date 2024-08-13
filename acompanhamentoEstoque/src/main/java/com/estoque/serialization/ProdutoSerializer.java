package com.estoque.serialization;

import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import com.estoque.model.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProdutoSerializer implements Serializer<Produto> {

	private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Produto produto) {
        try {
            return objectMapper.writeValueAsBytes(produto);
        } catch (Exception e) {
            throw new SerializationException("Error serializing value", e);
        }
    }

}
