package com.ridecrew.springbootridecrew.serializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimeDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat format = new SimpleDateFormat("hh:mm");

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) 
        throws IOException, JsonProcessingException {

        String date = p.getText();

        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}