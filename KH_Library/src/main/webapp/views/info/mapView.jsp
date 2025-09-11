<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library>오시는 길</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>

</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp" %>
    <div class="center-img">
        <img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
    </div>
    <div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp" %>
		<script>	
			$(function(){
				$.ajax({
					url : '${contextPath}/getenv.do',
					type : "GET",
					dataType: 'text',
					success : function(data){
				  			// console.log(data);
							var kakaoKey = data;
				            var script = document.createElement('script');
				            script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + kakaoKey + "&autoload=false";
				            script.onload = function() {
				                kakao.maps.load(function() {
				                    var container = document.getElementById('map');
				                    var options = { center: new kakao.maps.LatLng(37.5665,126.9780), level: 3 };
				                    var map = new kakao.maps.Map(container, options);
				                    
				                    var coords = new kakao.maps.LatLng(37.5665,126.9780);
				        			
				    			    // 결과값으로 받은 위치를 마커로 표시합니다
				    			    var marker = new kakao.maps.Marker({
				    			        map: map,
				    			        position: coords
				    			    });
				    			
				    			    // 인포윈도우로 장소에 대한 설명을 표시
				    			    var infowindow = new kakao.maps.InfoWindow({
				    			        content: '<div style="width:150px;text-align:center;padding:6px 0;">Library</div>'
				    			    });
				    			    infowindow.open(map, marker);
				    			
				    			    // 지도의 중심을 결과값으로 받은 위치로 이동
				    			    map.setCenter(coords);
				                    
				                });
				            };
				          document.head.appendChild(script); 
					},
					error : function(){
						console.log("통신오류");
					}
				});  
				
				var sidemenu = $(".side-title-menu").eq(2);
				sidemenu.siblings("ul").children().show();
				sidemenu.siblings("ul").children().eq(1).addClass("menu-click");
			})
		</script>
        <div id="content-area">			
			<div id="map" style="width: 100%; height: 500px;"></div> 			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>