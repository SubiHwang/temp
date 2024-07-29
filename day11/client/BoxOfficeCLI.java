package com.ssafy.day11.client;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import com.ssafy.day11.dto.BoxOffice;
import com.ssafy.day11.parser.BoxOfficeDomParser;
import com.ssafy.day11.parser.BoxOfficeParser;
import com.ssafy.day11.parser.BoxOfficeSaxParser;

public class BoxOfficeCLI {
    private BoxOfficeParser parser = null;
    private InputStream resource = null;

    public BoxOfficeCLI() {

    }

    public Optional<List<BoxOffice>> readBoxOfficeList(char type) throws Exception {
        // TODO: resource와 parser를 구성해서 정보를 가져와보자.
    	if(type == 'S') {
    		//상대경로로 가져온다. 한칸위에/res밑에
    		this.resource = BoxOfficeCLI.class.getResourceAsStream("../res/boxoffice.xml");
    		this.parser = BoxOfficeSaxParser.getParser();
    	}else if(type == 'D') {
    		this.resource = BoxOfficeCLI.class.getResourceAsStream("../res/boxoffice.xml");
    		this.parser = BoxOfficeDomParser.getParser();
    	}
    	
    	return Optional.ofNullable(this.parser.getBoxOffice(resource));
        // END

    }

    public static void main(String[] args) {
        BoxOfficeCLI cli = new BoxOfficeCLI();
        try {
        	//sax를 사용하면 s를 입력해준다.
            Optional<List<BoxOffice>> result = cli.readBoxOfficeList('D');
            result.ifPresentOrElse(list -> list.forEach(System.out::println), () -> System.out.println("unknown type"));
        } catch (Exception e) {
            System.out.println("오류 발생!: " + e.getMessage());
        }
    }
}
