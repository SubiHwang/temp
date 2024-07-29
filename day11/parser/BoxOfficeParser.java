package com.ssafy.day11.parser;

import java.io.InputStream;
import java.util.List;

import com.ssafy.day11.dto.BoxOffice;

public interface BoxOfficeParser {
//이거를 BoxOfficeSaxParser가 구현하고 있다.
    public abstract List<BoxOffice> getBoxOffice(InputStream resource) throws Exception;
}
