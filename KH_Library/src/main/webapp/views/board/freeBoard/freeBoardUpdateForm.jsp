<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.info {
	margin-left: 20px;
}

.category {
	margin-left: -900px;
	font-size: 16px;
}

.cell {
	padding-left: 5px; /* 등록일과 날짜 사이의 여백 조절 */
}

.separator {
	display: inline-block;
	margin: 0 10px;
}

.title {
	width: 100%;
	height: 40px;
	background-color: rgba(128, 128, 128, 0.233);
	border: 1px solid #black;
	padding: 8px;
	font-size: 16px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	font-family: sans-serif;
	font-size: 18px;
	color: #333;
	width: 100%;
	height: 800px;
	resize: none;
}

.list {
	color: #333;
	border: 1px solid #3333335d;
	border-radius: 5px;
	padding: 5px 20px;
	font-size: 16px;
	cursor: pointer;
	position: relative;
	left: 500px;
}
</style>

</head>
<body>

	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>
		<div id="content-area">
				<% Board fb = (Board) request.getAttribute("Freeboard"); %>
				<% int currentPage = (int)request.getAttribute("currentPage"); %>
			
			<div align="center">
				<h2>자유게시판 글 수정</h2>
				<br>
				<br>
				<br>
				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>자유게시판</td>
					</tr>
				</table>
			</div>

			<br> <br> <br>

			<form action="<%=contextPath%>/update.fb" method="post">
				<input type="hidden" name="nno" value="<%=fb.getBoardNo()%>">
				<input type="hidden" name="currentPage" value="${currentPage}">

				<div class="noticeDetail">
					<input type="text" name="title" class="title"
						value="<%=fb.getBoardTitle()%>"></input> <br>
					<br><br>

					<table class="info">
						<tr>
							<td>등록일:</td>
							<td class="cell"><%=fb.getDate()%></td>
							<td class="separator">|</td>
							<td>조회수:</td>
							<td class="cell"><%=fb.getCount()%></td>
						</tr>
					</table>

					<br><br>
					<textarea class="content" name="content">
					<%=fb.getBoardContent()%>
				</textarea>
					<br> <br> <br>
					<button type="submit" class="list">수정하기</button>
					<a href="/library/freeBoard?currentPage=<%=currentPage %>"
						class="list">목록으로</a>
				</div>		
			</form>

		</div>
	</div>

	<%@include file="/views/common/footer.jsp"%>
</body>
</html>