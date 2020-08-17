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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>
	<form name="paging">
    	<input type="hidden" name="resrv_email"/>
    </form>
	<div id="container">
		<div class="header">
			<header class="header_tit">
				<h1 class="logo">
					<a href="www.naver.com" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
					<a href="./main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
				</h1>
				<a href="#" class="btn_my"> <span title="내예약" class="viewReservation"></span> </a>
			</header>
		</div>
		<hr>
		<div class="ct">
			<div class="section_my">
				<!-- 예약 현황 -->
				<div class="my_summary">
					<ul class="summary_board">
						<li class="item">
							<!--[D] 선택 후 .on 추가 link_summary_board -->
							<a class="link_summary_board on"> <i class="spr_book2 ico_book2"></i> <em class="tit">전체</em> <span class="figure">6</span> </a>
						</li>
						<li class="item">
							<a class="link_summary_board"> <i class="spr_book2 ico_book_ss"></i> <em class="tit">이용예정</em> <span class="figure">3</span> </a>
						</li>
						<li class="item">
							<a class="link_summary_board"> <i class="spr_book2 ico_check"></i> <em class="tit">이용완료</em> <span class="figure">2</span> </a>
						</li>
						<li class="item">
							<a class="link_summary_board"> <i class="spr_book2 ico_back"></i> <em class="tit">취소·환불</em> <span class="figure">2</span> </a>
						</li>
					</ul>
				</div>
				<!--// 예약 현황 -->

				<!-- 내 예약 리스트 -->
				<div class="wrap_mylist">
					<ul class="list_cards" ng-if="bookedLists.length > 0">
						<!--[D] 예약확정: .confirmed, 취소된 예약&이용완료: .used 추가 card -->
						<li class="card" style="display: none;">
							<div class=link_booking_details>
								<div class="card_header">
									<div class="left"></div>
									<div class="middle">
										<!--[D] 예약 신청중: .ico_clock, 예약확정&이용완료: .ico_check2, 취소된 예약: .ico_cancel 추가 spr_book2 -->
										<i class="spr_book2 ico_clock"></i>
										<span class="tit">예약 신청중</span>
									</div>
									<div class="right"></div>
								</div>
							</div>
							<article class="card_item">
								<a href="#" class="link_booking_details">
									<div class="card_body">
										<div class="left"></div>
										<div class="middle">
											<div class="card_detail">
												<em class="booking_number">No.0000001</em>
												<h4 class="tit">서비스명/상품명1</h4>
												<ul class="detail">
													<li class="item">
														<span class="item_tit">일정</span>
														<em class="item_dsc">
															2000.0.00.(월)2000.0.00.(일)
														</em>
													</li>
													<li class="item">
														<span class="item_tit">내역</span>
														<em class="item_dsc">
															내역이 없습니다.
														</em>
													</li>
													<li class="item">
														<span class="item_tit">장소</span>
														<em class="item_dsc">
															내역이 없습니다.
														</em>
													</li>
													<li class="item">
														<span class="item_tit">업체</span>
														<em class="item_dsc">
															업체명이 없습니다.
														</em>
													</li>
												</ul>
												<div class="price_summary">
													<span class="price_tit">결제 예정금액</span>
													<em class="price_amount">
														<span>000,000,000</span>
														<span class="unit">원</span>
													</em>
												</div>
												<!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
												<div class="booking_cancel">
													<button class="btn"><span>취소</span></button>
												</div>
											</div>
										</div>
										<div class="right"></div>
									</div>
									<div class="card_footer">
										<div class="left"></div>
										<div class="middle"></div>
										<div class="right"></div>
									</div>
								</a>
								<a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
							</article>
							<article class="card_item">
								<a href="#" class="link_booking_details">
									<div class="card_body">
										<div class="left"></div>
										<div class="middle">
											<div class="card_detail">
												<em class="booking_number">No.0000000</em>
												<h4 class="tit">서비스명/상품명</h4>
												<ul class="detail">
													<li class="item">
														<span class="item_tit">일정</span>
														<em class="item_dsc">
															2000.0.00.(월)2000.0.00.(일)
														</em>
													</li>
													<li class="item">
														<span class="item_tit">내역</span>
														<em class="item_dsc">
															내역이 없습니다.
														</em>
													</li>
													<li class="item">
														<span class="item_tit">장소</span>
														<em class="item_dsc">
															내역이 없습니다.
														</em>
													</li>
													<li class="item">
														<span class="item_tit">업체</span>
														<em class="item_dsc">
															업체명이 없습니다.
														</em>
													</li>
												</ul>
												<div class="price_summary">
													<span class="price_tit">결제 예정금액</span>
													<em class="price_amount">
														<span>000,000,000</span>
														<span class="unit">원</span>
													</em>
												</div>
												<!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
												<div class="booking_cancel">
													<button class="btn"><span>취소</span></button>
												</div>
											</div>
										</div>
										<div class="right"></div>
									</div>
									<div class="card_footer">
										<div class="left"></div>
										<div class="middle"></div>
										<div class="right"></div>
									</div>
								</a>
								<a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
							</article>
						</li>
						<li class="card confirmed" id="confirmed">
							<div class="link_booking_details">
								<div class="card_header">
									<div class="left"></div>
									<div class="middle">
										<!--[D] 예약 신청중: .ico_clock, 예약확정&이용완료: .ico_check2, 취소된 예약: .ico_cancel 추가 spr_book -->
										<i class="spr_book2 ico_check2"></i>
										<span class="tit">예약 확정</span>
									</div>
									<div class="right"></div>
								</div>
							</div>
							<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
													<!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
													<div class="booking_cancel">
														<button class="btn cancel" onclick="cancel_btn(this);"><span>취소</span></button>
													</div>

												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
									<a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
								</article>
								<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
													<!-- [D] 예약 신청중, 예약 확정 만 취소가능, 취소 버튼 클릭 시 취소 팝업 활성화 -->
													<div class="booking_cancel">
														<button class="btn cancel" onclick="cancel_btn(this);"><span>취소</span></button>
													</div>

												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
									<a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
								</article>
							</li>
							<li class="card used" id="used">
								<div class="link_booking_details">
									<div class="card_header">
										<div class="left"></div>
										<div class="middle">
											<!--[D] 예약 신청중: .ico_clock, 예약확정&이용완료: .ico_check2, 취소된 예약: .ico_cancel 추가 spr_book -->
											<i class="spr_book2 ico_check2"></i>
											<span class="tit">이용 완료</span>
										</div>
										<div class="right"></div>
									</div>
								</div>
								<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
													<div class="booking_cancel">
														<a href="./reviewWrite.html"><button class="btn"><span>예매자 리뷰 남기기</span></button></a>
													</div>
												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
								</article>
								<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
													<div class="booking_cancel">
														<a href="./reviewWrite.html"><button class="btn"><span>예매자 리뷰 남기기</span></button></a>
													</div>
												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
								</article>
							</li>
							<li class="card used cancel" id="canceled">
								<div class="link_booking_details">
									<div class="card_header">
										<div class="left"></div>
										<div class="middle">
											<!--[D] 예약 신청중: .ico_clock, 예약확정&이용완료: .ico_check2, 취소된 예약: .ico_cancel 추가 spr_book -->
											<i class="spr_book2 ico_cancel"></i>
											<span class="tit">취소된 예약</span>
										</div>
										<div class="right"></div>
									</div>
								</div>
								<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
								</article>
								<article class="card_item">
									<a href="#" class="link_booking_details">
										<div class="card_body">
											<div class="left"></div>
											<div class="middle">
												<div class="card_detail">
													<em class="booking_number">No.0000000</em>
													<h4 class="tit">서비스명/상품명</h4>
													<ul class="detail">
														<li class="item">
															<span class="item_tit">일정</span>
															<em class="item_dsc">
																2000.0.00.(월)2000.0.00.(일)
															</em>
														</li>
														<li class="item">
															<span class="item_tit">내역</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">장소</span>
															<em class="item_dsc">
																내역이 없습니다.
															</em>
														</li>
														<li class="item">
															<span class="item_tit">업체</span>
															<em class="item_dsc">
																업체명이 없습니다.
															</em>
														</li>
													</ul>
													<div class="price_summary">
														<span class="price_tit">결제 예정금액</span>
														<em class="price_amount">
															<span>000,000,000</span>
															<span class="unit">원</span>
														</em>
													</div>
												</div>
											</div>
											<div class="right"></div>
										</div>
										<div class="card_footer">
											<div class="left"></div>
											<div class="middle"></div>
											<div class="right"></div>
										</div>
									</a>
								</article>
							</li>
						</ul>
					</div>
					<!--// 내 예약 리스트 -->

					<!-- 예약 리스트 없음 -->
					<div class="err"> <i class="spr_book ico_info_nolist"></i>
						<h1 class="tit">예약 리스트가 없습니다</h1>
					</div>
					<!--// 예약 리스트 없음 -->
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

		<!-- 취소 팝업 -->
		<!-- [D] 활성화 display:block, 아니오 버튼 or 닫기 버튼 클릭 시 숨김 display:none; -->
		<div class="popup_booking_wrapper" style="display:none;">
			<div class="dimm_dark" style="display:block"></div>
			<div class="popup_booking refund">
				<h1 class="pop_tit">
					<span>서비스명/상품명</span>
					<small class="sm">2000.0.00.(월)2000.0.00.(일)</small>
				</h1>
				<div class="nomember_alert">
					<p>취소하시겠습니까?</p>
				</div>
				<div class="pop_bottom_btnarea">
					<div class="btn_gray">
						<a class="btn_bottom" href="javascript:history.back();"><span>아니오</span></a>
					</div>
					<div class="btn_green">
						<a class="btn_bottom"><span>예</span></a>
					</div>
				</div>
				<!-- 닫기 -->
				<a class="popup_btn_close" title="close" href="javascript:history.back();">
					<i class="spr_book2 ico_cls"></i>
				</a>
				<!--// 닫기 -->
			</div>
		</div>
		<!--// 취소 팝업 -->
	
	<script>
	//전체, 이용예정, 이용완료, 취소 목록 count 출력하기
		var resrv_confirm_list = document.querySelectorAll('#confirmed > .card_item');
		var resrv_used_list = document.querySelectorAll('#used > .card_item');
		var resrv_canceled_list = document.querySelectorAll('#canceled > .card_item');
		
		var total_count = document.querySelector('.spr_book2.ico_book2').nextElementSibling.nextElementSibling;
		var count_confirmed = document.querySelector('.spr_book2.ico_book_ss').nextElementSibling.nextElementSibling;
		var count_used = document.querySelector('.spr_book2.ico_check').nextElementSibling.nextElementSibling;
		var count_canceled = document.querySelector('.spr_book2.ico_back').nextElementSibling.nextElementSibling;
		
		count_confirmed.innerText = resrv_confirm_list.length;
		count_used.innerText = resrv_used_list.length;
		count_canceled.innerText = resrv_canceled_list.length;
		total_count.innerText = resrv_confirm_list.length+resrv_used_list.length+resrv_canceled_list.length;
		
		//향후 취소기능 구현(취소시 취소태그로 아이템 이동), 각 탭 클릭할때 해당 항목들만 나타나게 하기(전체,예정,완료,취소 탭), DB에서 예약 정보 가져와서 정보 등록하기.
		
		var summary_board = document.querySelector('.summary_board');
		var link_summary_board = document.querySelectorAll('.link_summary_board');
		var all_card = document.querySelectorAll('.card');
		summary_board.addEventListener('click',function(e){
			if(e.target.nodeName == 'A'){
				if(e.target.innerText.indexOf('전체')==1){
					all_card[1].setAttribute('class','card confirmed');
					all_card[2].setAttribute('class','card used');
					all_card[3].setAttribute('class','card used cancel');
					for(var i=1;i<all_card.length;i++){
						all_card[i].style.display='block';
					}
				}
				else if(e.target.innerText.indexOf('이용예정')==1){
					console.log(1);
					all_card[1].setAttribute('class','card confirmed');
					all_card[2].setAttribute('class','card');
					all_card[3].setAttribute('class','card');
					for(var i=1;i<all_card.length;i++){
						if(i != 1){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
				else if(e.target.innerText.indexOf('이용완료')==1){
					all_card[1].setAttribute('class','card');
					all_card[2].setAttribute('class','card used');
					all_card[3].setAttribute('class','card');
					for(var i=1;i<all_card.length;i++){
						if(i != 2){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
				else{
					all_card[1].setAttribute('class','card');
					all_card[2].setAttribute('class','card');
					all_card[3].setAttribute('class','card used cancel');
					for(var i=1;i<all_card.length;i++){
						if(i != 3){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
			}
			else{
				console.log(e.target.parentNode.innerText);
				if(e.target.parentNode.innerText.indexOf('전체')==1){
					all_card[1].setAttribute('class','card confirmed');
					all_card[2].setAttribute('class','card used');
					all_card[3].setAttribute('class','card used cancel');
					for(var i=1;i<all_card.length;i++){
						all_card[i].style.display='block';
					}
				}
				else if(e.target.parentNode.innerText.indexOf('이용예정')==1){
					all_card[1].setAttribute('class','card confirmed');
					all_card[2].setAttribute('class','card');
					all_card[3].setAttribute('class','card');
					for(var i=1;i<all_card.length;i++){
						if(i != 1){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
				else if(e.target.parentNode.innerText.indexOf('이용완료')==1){
					all_card[1].setAttribute('class','card');
					all_card[2].setAttribute('class','card used');
					all_card[3].setAttribute('class','card');
					for(var i=1;i<all_card.length;i++){
						if(i != 2){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
				else{
					all_card[1].setAttribute('class','card');
					all_card[2].setAttribute('class','card');
					all_card[3].setAttribute('class','card used cancel');
					for(var i=1;i<all_card.length;i++){
						if(i != 3){
							all_card[i].style.display='none';
						}
						else{
							all_card[i].style.display='block';
						}
					}
				}
			}
		});
		
		var btn_cancel;
		var cancel_alert = document.querySelector('.popup_booking_wrapper');
		function cancel_btn(tag){
			console.log(tag);
			cancel_alert.style.display='block';
			btn_cancel = tag;
		}
		/*
		var btn_cancel = document.querySelectorAll('.booking_cancel > .btn.cancel');
		var cancel_alert = document.querySelector('.popup_booking_wrapper');
		for(var i=0;i<btn_cancel.length;i++){
			btn_cancel[i].addEventListener('click',function(e){
				//var item = e.currentTarget.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
				//var cancel_tag = document.querySelector('#canceled');
				cancel_alert.style.display='block';
				//e.currentTarget.parentNode.removeChild(e.currentTarget);
				//item.removeChild(item.lastElementChild);
				//cancel_tag.appendChild(item);
			});
		}
		*/
		var cancel_yes = document.querySelector('.btn_green');
		cancel_yes.firstElementChild.setAttribute('href',"javascript:goPage('${sessionScope.email}');");//goPage 대신에 cancel_item 넣고 태그 이통 테스트 완료
		
		/*
		//시험삼아 링크 이동 없이(DB적용 없이 태그 이동 되는지) 테스트
		function cancel_item(){
			var item = btn_cancel.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
			var cancel_tag = document.querySelector('#canceled');
			btn_cancel.parentNode.removeChild(btn_cancel);
			item.removeChild(item.lastElementChild);
			cancel_tag.appendChild(item);
		}*/
		
		// email을 인수로 받아 form 태그로 전송하는 함수
	    function goPage(email) {
		    // name이 paging인 태그
		    var f = document.paging;
	
		    // form 태그의 하위 태그 값 매개 변수로 대입
		    f.resrv_email.value = email;
			
		    //나중에 DB 내용 적용할 때, 여기에다가 cancel_flag 값 올려서 페이지 열렸을때 아이템 이동 적용되도록 하면 될것 같다.
		    var item = btn_cancel.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
			var cancel_tag = document.querySelector('#canceled');
			btn_cancel.parentNode.removeChild(btn_cancel);
			item.removeChild(item.lastElementChild);
			cancel_tag.appendChild(item);
		    // input태그의 값들을 전송하는 주소
		    f.action = "./myreservation"
	
		    // 전송 방식 : post
		    f.method = "post"
		    f.submit();
	    };
		
		cancel_yes.addEventListener('click', function(){
			console.log('취소 되었습니다.');
			cancel_alert.style.display='none';
			
		});
		var cancel_no = document.querySelector('.btn_gray');
		cancel_no.addEventListener('click',function(){
			console.log('not canceled');
			cancel_alert.style.display='none';
		});
		
		var x_btn = document.querySelector('.popup_btn_close');
		x_btn.addEventListener('click',function(){
			cancel_alert.style.display='none';
		})
		
		
		//DB에서 예약 정보 가져와서 정보 등록하기 기능.
	</script>
</body>

</html>