package com.zhangzhuorui.framework.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author :  张涛 zhangtao
 * @version :  1.0
 * @createDate :  2017-01-01
 * @description :
 * @updateUser :
 * @updateDate :
 * @updateRemark :
 */
public class ZtDateDeserializer extends JsonDeserializer<Date> {
    String[] patterns = new String[]{
            "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss", "yyyy-MM-dd hh:mm:ss.SSS", "yyyy/MM/dd", "yyyy/MM/dd hh:mm:ss",
            "MM-dd-yyyy", "dd-MM-yyyy", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ss.SSSZ"};

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Date date = null;
        try {
            date = DateUtils.parseDate(jsonParser.getText(), patterns);
        } catch (ParseException e) {
        }
        return date;
    }
}
