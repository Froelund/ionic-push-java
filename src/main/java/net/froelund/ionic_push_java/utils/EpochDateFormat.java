package net.froelund.ionic_push_java.utils;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.util.StdDateFormat;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by froelund on 12/16/15.
 */
public class EpochDateFormat extends JsonSerializer<Date> {

    private static final DateFormat iso8601Format =
            StdDateFormat.getBlueprintISO8601Format();

    @Override
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        long secondsSinceEpoch = value.getTime() / 1000;
        jgen.writeNumber(secondsSinceEpoch);
    }
}
