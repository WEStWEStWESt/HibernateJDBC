package utils.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/*прописать в консоли БД: CREATE EXTENSION IF NOT EXISTS pgcrypto */

@Converter
public class UserNameConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String s) {
        return s.toLowerCase();
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}
