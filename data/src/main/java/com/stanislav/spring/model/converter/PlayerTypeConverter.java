package com.stanislav.spring.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.stanislav.spring.model.PlayerType;

@Converter
public class PlayerTypeConverter
        implements AttributeConverter<PlayerType, Character> {

    public Character convertToDatabaseColumn( PlayerType value ) {
        if ( value == null ) {
            return null;
        }

        return value.getCode();
    }

    public PlayerType convertToEntityAttribute( Character value ) {
        if ( value == null ) {
            return null;
        }

        return PlayerType.fromCode( value );
    }
}