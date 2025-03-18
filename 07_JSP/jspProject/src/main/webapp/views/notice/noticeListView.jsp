<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<style>

.outer{
			background: #4b89fc;
			color: white;
			width: 1000PX;
			margin: auto;
			margin-top: 50px;
			padding: 10px 0px 50px;
		}

        .list-area{
            border: 1px solid white;
            text-align: center;
        }

        .list-area tr:hover{
         background-color: #85afff;
         cursor: pointer;
         font-size: 18px;
        }
        
        
        .list-area td, .list-area th{
            border: 1px solid white;
        }

</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">공지사항</h2>
        <br>

        <table align="center" class="list-area">
            <thead>
                <th width="70">글 번호</th>
                <th width="100">카테고리</th>
                <th width="300">제목</th>
                <th width="100">작성자</th>
                <th width="70">조회수</th>
                <th width="100">작성일</th>
            </thead>
            <tbody>
            
            <c:forEach var="b" items="${list}">
            
                <tr>
                    
                    <td>${b.boardNo}</td>
                    <td>${b.categoryName}</td>
                    <td>${b.boardTitle}</td>
                    <td>${b.userId}</td>
                    <td>${b.count}</td>
                    <td>${b.createDate}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
	
	

</body>
</html>