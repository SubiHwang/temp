package com.ssafy.day11.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.day11.dto.BoxOffice;

public class BoxOfficeSaxParser extends DefaultHandler implements BoxOfficeParser {
    // TODO: singleton 형태로 작성해보자.
	//이거를 통해서 영화정보에 대한 list를 얻자.
	
	static private BoxOfficeSaxParser parser = new BoxOfficeSaxParser();
	
	private BoxOfficeSaxParser() {
		System.out.println("SAX");
	}
	
	public static BoxOfficeSaxParser getParser() {
		return parser;
	}
	
    // END

    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list;
    // 지금 처리할 객체의 내용
    int rank;
    String movieNm;
    String openDt;
    int audiAcc;

    // 방금 읽은 텍스트 내용
    private String content;

    @Override
    // TODO: getBoxOffice를 재정의하여 SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
     public List<BoxOffice> getBoxOffice(InputStream resource) throws ParserConfigurationException, SAXException, IOException { 
    	list = new ArrayList<>();
    	SAXParserFactory factory = SAXParserFactory.newInstance();
    	SAXParser parser = factory.newSAXParser();
    	parser.parse(resource, this);//parsing 과정에서 데이터를 구성한다.
    	//list에 담아 반환한다.
    	
    	return list;
    }

    // END

    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    @Override
    public void startDocument() throws SAXException {
    	//System.out.println("문서 시작했습니다.");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	//System.out.println("태그가 시작했어요 :"+ qName);
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	String str = String.valueOf(ch,start,length);
    	//System.out.println(str);
    	this.content = str; 
    }
    
//    <TAG>내용</TAG>
//    파서로 긁어오면
//    "내용"만 가져와지는게 아니라
//    <TAG> </TAG>도 같이 가져와진다.
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	if(qName.equals("rank")) {
    		this.rank = Integer.parseInt(content);
    	} else if(qName.endsWith("movieNm")) {
    		this.movieNm = content;
    	}else if(qName.equals("openDt")) {
    		this.openDt = content;
    	}else if(qName.equals("audiAcc")) {
    		this.audiAcc = Integer.parseInt(content);
    	}else if(qName.equals("dailyBoxOffice")) {
    		list.add(new BoxOffice(rank, movieNm, openDt, audiAcc));
    	}
    }

    // END
}
