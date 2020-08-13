<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.connect.reservation.dto.*" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
</head>

<body>
    <div id="container">
		<!-- [D] 예약하기로 들어오면 header에 fade 클래스 추가로 숨김 -->
		<div class="header fade">
			<header class="header_tit">
				<h1 class="logo">
					<a href="#" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
					<a href="#" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				</h1>
				  <a href="./bookinglogin" class="btn_my"> <span title="예약확인">예약확인</span> </a>
			</header>
		</div>
        <div class="ct">
            <div class="wrap_review_list">
                <div class="review_header">
                    <div class="top_title gr">
                        <a href="./detail.html" class="btn_back" title="이전 화면으로 이동"> <i class="fn fn-backward1"></i> </a>
                        <h2><a class="title" href="#">오디컴퍼니 주식회사</a></h2>
                    </div>
                </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area"> <span class="graph_mask"> <em class="graph_value" style="width: 88%;"></em> </span> <strong class="text_value"> <span>4.4</span> <em class="total">5.0</em> </strong> <span class="join_count"><em class="green">20건</em> 등록</span>                                </div>
                            <ul class="list_short_review">
                                <!-- 탬플릿으로 작성 -->
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                </div>
            </div>
        </div>
        <hr> 
    </div>
		<footer>
	        <div class="gototop">
	            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
	        </div>
	        <div id="footer" class="footer">
	            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
	            <span class="copyright">© NAVER Corp.</span>
	        </div>
	    </footer>
	    
	<script type="rv-template" id="reviewLists">
	    <li class="list_item">
		    <div>
		        <div class="review_area">
		            <div class="thumb_area">
		                <a href="#" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="${pageContext.request.contextPath}/img/{{fileName}}" alt="리뷰이미지"> </a> <span class="img_count" style="display:none;">1</span>                                                </div>
		            <h4 class="resoc_name">{{description}}</h4>
		            <p class="review">{{comment}}</p>
		        </div>
		        <div class="info_area">
		            <div class="review_info"> <span class="grade">{{score}}.0</span> <span class="name">{{reservationName}}</span> <span class="date">{{createDate}} 방문</span> </div>
		        </div>
		    </div>
		</li>
    </script>
    <script type="rv-template" id="reviewLists2">
	    <li class="list_item">
		    <div>
		        <div class="review_area no_img">
		            <h4 class="resoc_name">{{description}}</h4>
		            <p class="review">{{comment}}</p>
		        </div>
		        <div class="info_area">
		            <div class="review_info"> <span class="grade">{{score}}.0</span> <span class="name">{{reservationName}}</span> <span class="date">{{createDate}} 방문</span> </div>
		        </div>
		    </div>
		</li>
    </script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.min.js" integrity="sha512-zT3zHcFYbQwjHdKjCu6OMmETx8fJA9S7E6W7kBeFxultf75OPTYUJigEKX58qgyQMi1m1EgenfjMXlRZG8BXaw==" crossorigin="anonymous"></script>
    <script>
    	//뒤로가기 버튼 설정
    	var id = "${id}";
    	var btn_back = document.querySelector('.btn_back');
    	btn_back.setAttribute('href','./detail?id='+id);
    
    	//별점 설정
    	var avg_rate = document.querySelector('.text_value span');
	    var star_rate = document.querySelector('.graph_value');
	    var total_comment = document.querySelector('.green');
	    var avg = "${avgRate}"*1.0;
	    var total = "${countComment}";
	    
	    avg_rate.innerHTML = avg;
	    var star = (avg/5.0)*100+'';
	    console.log(star);
	    star_rate.style.width=star+'%';
	    total_comment.innerHTML = total+"건";
	    
	    //한줄평 리스트 전체 출력
	    var id_product = "${id_product}";
	    var commentCount=0;
	    var ul_comment = document.querySelector('.list_short_review');
	    var commentHTML ='';
	    var commentTemp = document.querySelector('#reviewLists').innerHTML;
	    var commentTemp2 = document.querySelector('#reviewLists2').innerHTML;
	    console.log(commentTemp);
	    <c:forEach items="${allComment}" var = "commentlist">
	    	<c:forEach items="${productImg}" var = "image" varStatus="status">
	    		if("${image.fileName}".startsWith(id_product+"_th")){
	    			var commentJSON = new Object();
		    		commentJSON.comment = "${commentlist.comment}";
		    		commentJSON.reservationName = "${commentlist.reservationName}";
		    		commentJSON.score = "${commentlist.score}";
		    		commentJSON.createDate = "${commentlist.createDate}";
		    		commentJSON.fileName = "${image.fileName}";
		    		commentJSON.description = "${commentlist.description}";
	    			if(commentCount ===0){
	    				var bindTemplate = Handlebars.compile(commentTemp);
	    				commentHTML = bindTemplate(commentJSON);
	    				ul_comment.innerHTML += commentHTML;
	    			}
	    			else{
	    				var bindTemplate = Handlebars.compile(commentTemp2);
	    				commentHTML = bindTemplate(commentJSON);
	    				ul_comment.innerHTML += commentHTML;
	    			}commentCount++;
	    		}
	    	</c:forEach>
	    </c:forEach>
    </script>
</body>

</html>
