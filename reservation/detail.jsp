<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.or.connect.reservation.dto.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>네이버 예약</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <style>
        .container_visual {
            height: 414px;
        }
    </style>
</head>

<body>
    <div id="container">
        <div class="header fade">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="www.naver.com" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="#" class="btn_my"> <span title="예약확인">예약확인</span> </a>
            </header>
        </div>
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <header>
                        <h1 class="logo">
                            <a href="www.naver.com" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                            <a href="./main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                        </h1>
                        <a href="./myreservation.html" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
                    </header>
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num">1</span>
                            <span class="num off">/ <span>2</span></span>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img detail_swipe">
                                <!-- 템플릿으로 태그 추가 -->
                                </ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a class="btn_prev" title="이전">
                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="group_btn_goto"  style="display: none;">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div class="section_store_details">
                    <!-- [D] 펼쳐보기 클릭 시 store_details에 close3 제거 -->
                    <div class="store_details close3">
                        <p class="dsc">
                        </p>
                    </div>
                    <!-- [D] 토글 상황에 따라 bk_more에 display:none 추가 -->
                    <a class="bk_more _open"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                    <a class="bk_more _close" style="display: none;"> <span class="bk_more_txt">접기</span> <i class="fn fn-up2"></i> </a>
                </div>
                <div class="section_event">
                    <div class="event_info_box">
                        <div class="event_info_tit">
                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
                        </div>
                        <div class="event_info">
                            <div class="in_dsc">[네이버예약 특별할인]<br>R석 50%, S석 60% 할인</div>
                        </div>
                    </div>
                </div>
                <div class="section_btn"> <button type="button" class="bk_btn"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
                                <span class="graph_mask"> <em class="graph_value" style="width: 84%;"></em> </span>
                                <strong class="text_value"> <span></span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green"></em> 등록</span>
                            </div>
                            <ul class="list_short_review">
                                <!-- 템플릿으로 추가완료 -->
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="./review.html"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
                <div class="section_info_tab">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                        <li class="item active _detail">
                            <a class="anchor active"> <span>상세정보</span> </a>
                        </li>
                        <li class="item _path">
                            <a class="anchor"> <span>오시는길</span> </a>
                        </li>
                    </ul>
                    <!-- [D] 상세정보 외 다른 탭 선택 시 detail_area_wrap에 hide 추가 -->
                    <div class="detail_area_wrap">
                        <div class="detail_area">
                        <div class="detail_info">
                                <h3 class="blind">상세정보</h3>
                                <ul class="detail_info_group">
                                    <li class="detail_info_lst">
                                        <strong class="in_tit">[소개]</strong>
                                        <p class="in_dsc">
                                        </p>
                                    </li>
                                    <li class="detail_info_lst"> <strong class="in_tit">[공지사항]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_238/14858250829398Pnx6_JPEG/%B0%F8%C1%F6%BB%E7%C7%D7.jpg?type=a1000"> </li>
                                        </ul>
                                    </li>
                                    <!-- <li class="detail_info_lst"> <strong class="in_tit">[공연정보]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_255/1485825099482NmYMe_JPEG/%B0%F8%BF%AC%C1%A4%BA%B8.jpg?type=a1000"> </li>
                                        </ul>
                                    </li> -->
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- [D] 오시는길 외 다른 탭 선택 시 detail_location에 hide 추가 -->
                    <div class="detail_location hide">
                        <div class="box_store_info no_topline">
                            <a href="#" class="store_location" title="지도웹으로 연결">
                                <img class="store_map img_thumb" alt="map" src="https://simg.pstatic.net/static.map/image?version=1.1&amp;crs=EPSG:4326&amp;baselayer=bl_vc_bg&amp;exception=xml&amp;scale=2&amp;caller=mw_smart_booking&amp;overlayers=ol_vc_an&amp;center=127.0011948,37.5717079&amp;markers=type,default2,127.0011948,37.5717079&amp;level=11&amp;w=340&amp;h=150">
                                <span class="img_border"></span>
                                <span class="btn_map"><i class="spr_book2 ico_mapview"></i></span>
                            </a>
                            <h3 class="store_name">엔에이치엔티켓링크(주)</h3>
                            <div class="store_info">
                                <div class="store_addr_wrap">
                                    <span class="fn fn-pin2"></span>
                                    <p class="store_addr store_addr_bold">서울특별시 종로구 종로33길 15 </p>
                                    <p class="store_addr">
                                        <span class="addr_old">지번</span>
                                        <span class="addr_old_detail">서울특별시 종로구 연지동 270 </span>
                                    </p>
                                    <p class="store_addr addr_detail">두산아트센터 연강홀</p>
                                </div>
                                <div class="lst_store_info_wrap">
                                    <ul class="lst_store_info">
                                        <li class="item"> <span class="item_lt"> <i class="fn fn-call2"></i> <span class="sr_only">전화번호</span> </span> <span class="item_rt"> <a href="tel:02-548-0597" class="store_tel">02-548-0597</a></span> </li>
                                    </ul>
                                </div>
                            </div>
							<!-- [D] 모바일 브라우저에서 접근 시 column2 추가와 btn_navigation 요소 추가 -->
                            <div class="bottom_common_path column2">
                                <a href="#" class="btn_path"> <i class="fn fn-path-find2"></i> <span>길찾기</span> </a>
								<a href="#" class="btn_navigation before"> <i class="fn fn-navigation2"></i> <span>내비게이션</span> </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
    <div id="photoviwer"></div>
    
    <script type="rv-template" id="itemDetail">
        <li class="item" style="width: 414px;"> <img alt="" class="img_thumb" src="${pageContext.request.contextPath}/img/{image}"> <span class="img_bg"></span>
        	<div class="visual_txt">
            	<div class="visual_txt_inn">
                	<h2 class="visual_txt_tit"> <span></span> </h2>
                    <p class="visual_txt_dsc">{description}</p>
                </div>
            </div>
        </li>
    </script>
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
    	var ul_img = document.querySelector(".visual_img.detail_swipe");
    	var img_template = document.querySelector("#itemDetail").innerHTML;
    	var id_product = 0;
    	console.log(ul_img);
    	var resultHTML='';
    	var img_count=0;
    	var doneLoop = false;
    	var description='';
    	<c:forEach items="${toId}" var = "toid" varStatus="status">
    		id_product = "${toid.productId}";
    	</c:forEach>
    	<c:forEach items="${itemDetail}" var = "item">
    		description = "${item.description}";
    	</c:forEach>
	    <c:forEach items="${productImg}" var = "image" varStatus="status">
		    	if(!doneLoop){
		    		if("${image.fileName}".startsWith(id_product+"_th") || "${image.fileName}".startsWith(id_product+"_ma") || "${image.fileName}".startsWith(id_product+"_et")){
			    		resultHTML = img_template.replace("{image}","${image.fileName}")
			    								.replace("{description}",description);
			    		ul_img.innerHTML += resultHTML;
			    		img_count++;
			    	}
		    		if(img_count===3){//해당 아이템의 이미지는 3개까지만 저장.
		    			doneLoop = true;
		    		}
		    	}
	    </c:forEach>

	    var prevBtn = document.querySelector('.btn_prev');
	    var nextBtn = document.querySelector('.btn_nxt');
	    if(img_count ===1){
	    	prevBtn.style.display = 'none';
	    	nextBtn.style.display = 'none';
	    }
	    
	    var slideWrapper = document.querySelector('.container_visual');
	    var slides = document.querySelectorAll('.container_visual .item');
	    var totalSlides = slides.length;
	    var sliderWidth = slideWrapper.clientWidth;
	    var slideIndex = 0;
	    var slider = document.querySelector('.visual_img');
	    slider.style.width = sliderWidth * totalSlides + 'px';
	    var img_num = document.querySelector('.num');
	    var img_total = document.querySelector('.num.off span');
	    img_total.innerHTML = img_count;
	    function showSlides(n) {
	        slideIndex = n;
	        if (slideIndex == -1) {
	            slideIndex = totalSlides - 1;
	        } else if (slideIndex === totalSlides) {
	            slideIndex = 0;
	        }
	        slider.style.left = -(sliderWidth * slideIndex) + 'px';
	        
	        img_num.innerHTML = slideIndex+1;
	    }

	    function plusSlides(n){
	        showSlides(slideIndex += n);
	    }
	      
	    function currentSlide(n) {
	        showSlides(slideIndex = n);
	    }
	    
	    nextBtn.addEventListener('click', function () {
	        plusSlides(1);
	        console.log(slideIndex);
	    });
	    prevBtn.addEventListener('click', function () {
	        plusSlides(-1);
	        console.log(slideIndex);
	    });//이전, 다음 버튼 클릭시 이미지 슬라이드 이벤트 등록 완료.
	    
	    //추후 진행 : 아이템 description 이미지 위에 노출 시키고, 이미지 밑에 content 항목 넣고 펼치기 접기 기능 구현하기
	    
	    //아이템 상세내용 작성
	    var item_content = document.querySelector('.store_details .dsc');
	    var item_detail = document.querySelector('.detail_info_lst .in_dsc');
	    <c:forEach items="${itemDetail}" var = "item">
	    	item_content.innerHTML = "${item.content}";
	    	item_detail.innerHTML = "${item.content}";
	    </c:forEach>
	    
	    //펼쳐보기 접기 기능 store_details close3 
	    var more_open = document.querySelector('.bk_more._open');
	    var fold_more = document.querySelector('.bk_more._close');
	    var store_details = document.querySelector('.store_details.close3');
	    console.log(more_open);
	    more_open.addEventListener('click', function(){
	    	store_details.setAttribute('class','store_details');
	    	more_open.style.display = 'none';
	    	fold_more.style.display = 'block';
	    });
	    
	    fold_more.addEventListener('click', function(){
	    	store_details.setAttribute('class','store_details close3');
	    	more_open.style.display = 'block';
	    	fold_more.style.display = 'none';
	    });
    </script>
    
    <script>
    //평균 별점,comment count갯수
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
    //comment 한줄평 정보 출력
    	var id = "${id}";
   		var commentCount=0;
	    var ul_comment = document.querySelector('.list_short_review');
	    var commentHTML ='';
	    var commentTemp = document.querySelector('#reviewLists').innerHTML;
	    var commentTemp2 = document.querySelector('#reviewLists2').innerHTML;
	    
	    <c:forEach items="${commentLists}" var = "commentlist">
	    	<c:forEach items="${productImg}" var = "image" varStatus="status">
	    		if("${image.fileName}".startsWith(id+"_th")){
	    			console.log("${commentlist.description}");
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
    //한줄평 더보기 버튼 링크설정
	    var more_review_btn = document.querySelector('.btn_review_more');
	    var item_id = "${id}"
	    more_review_btn.setAttribute('href','./review?id='+item_id);
    
    //상세정보 및 오시는길 탭
	    var tab_detail = document.querySelector('.item.active._detail');
	    var tab_path = document.querySelector('.item._path');
	    var tab_ul = document.querySelector('.info_tab_lst');
	    var detail_area = document.querySelector('.detail_area_wrap');
	    var path_area = document.querySelector('.detail_location.hide');
	    var addr_str = document.querySelector('.store_addr.store_addr_bold');
	    var addr_old = document.querySelector('.addr_old_detail');
	    var addr_detail = document.querySelector('.store_addr.addr_detail');
	    
	    tab_ul.addEventListener('click', function(e){
	    	if(e.target.innerText==='오시는길'){
	    		tab_detail.firstElementChild.setAttribute('class','anchor');
	    		tab_path.firstElementChild.setAttribute('class','anchor active');
	    		detail_area.setAttribute('class','detail_area_wrap hide');
	    		path_area.setAttribute('class','detail_location');
	    		<c:forEach items="${itemLocation}" var = "location">
	        		addr_str.innerHTML = "${location.placeStreet}";
	        		addr_old.innerHTML = "${location.placeLot}";
	        		addr_detail.innerHTML = "${location.placeName}";
	        	</c:forEach>
	    	}
	    	else if(e.target.innerText==='상세정보'){
	    		tab_detail.firstElementChild.setAttribute('class','anchor active');
	    		tab_path.firstElementChild.setAttribute('class','anchor');
	    		detail_area.setAttribute('class','detail_area_wrap');
	    		path_area.setAttribute('class','detail_location hide');
	    	}
	    });
	    
	    var path_map = document.querySelector('.store_map.img_thumb');
	    <c:forEach items="${mapImg}" var = "map">
	    	path_map.setAttribute("src","${pageContext.request.contextPath}/img_map/"+"${map.fileName}");
	    </c:forEach>
    </script>
</body>

</html>