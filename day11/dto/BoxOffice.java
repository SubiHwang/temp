package com.ssafy.day11.dto;

public record BoxOffice(Integer rank,String movieNum,String openDt,Integer audiAcc) { //내가 사용할 변수를 괄호 안에 사용한다.
	//사용자 정의 메소드 추가 가능
	public String sayHello() {
		return "Hello";
	}
	
	@Override
	public final String toString() {
		return "박스오피스 정보: "+ rank+":"+movieNum+":" + openDt+":"+audiAcc;
	}
	
}

//public record BoxOffice(Integer rank, String movieNm, String openDt, Integer audiAcc) {
//
//    public Date toDate() {
//        Date dateObj = null;
//        // TODO: 문자열 형태의 날짜를 Date로 변환해서 반환하시오.
//
//        // END
//        return dateObj;
//    }
//
//    @Override
//    public String toString() {
//        return "BoxOffice [순위=" + rank + ", 제목=" + movieNm + ", 관객수=" + audiAcc + ", 개봉일=" + openDt + "]";
//    }
//    
//    
//}
