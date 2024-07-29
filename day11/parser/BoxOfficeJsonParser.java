package com.ssafy.day11.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.day11.dto.BoxOffice;

public class BoxOfficeJsonParser implements BoxOfficeParser {

    private static BoxOfficeJsonParser parser = new BoxOfficeJsonParser();

    public static BoxOfficeJsonParser getParser() {
        return parser;
    }

    private BoxOfficeJsonParser() {
        System.out.println("json");
    }

    private List<BoxOffice> list;

    @Override
    public List<BoxOffice> getBoxOffice(InputStream resource) throws IOException  {
        
        // TODO: json을 파싱해서 list를 구성하시오.
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map<Stirng,Object>> result =
        mapper.readValue(resource,new TypeReference<>() {
        	
        });
        
        List<Map<String,Object>>result.get("boxOfficeResult").get("dailyBoxOffice");
        
        List = officelist.stream().map(info -> mapper.convertValue(info,BoxOffice.class))
        .collect(Collectors.toList());
        
        // END
        return list;
    }
}
