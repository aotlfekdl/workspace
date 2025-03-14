<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <style>
        table * {margin:5px;}
        table {width:100%;}
    </style>
</head>
<body onload="init()">
<jsp:include page="../common/header.jsp" />

<div class="content">
    <br><br>
    <div class="innerOuter">
        <h2>사진게시글 상세보기</h2>
        <br>

        <a class="btn btn-secondary" style="float:right;" href="list.th">목록으로</a>
        <br><br>

        <table id="contentArea" align="center" class="table">
            <tr>
                <th width="100">제목</th>
                <td colspan="3">${board.boardTitle }</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${board.boardWriter }</td>
                <th>작성일</th>
                <td>${board.createDate }</td>
            </tr>
            <tr>
                <div>
                <th>대표이미지</th>
                <td colspan="3">
                    <!-- case1 -->
                    <img src="${board.changeName}" alt="썸네일 이미지" download="${board.originName}" onclick="location.href='${board.changeName}">
                    <a href="${board.changeName}" download="${board.originName }"></a>

                </td>
                </div>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3"></td>
            </tr>
            <tr>
                <td>세부 이미지</td>
                <td colspan="3">

                    <c:forEach var="b" items="${attachment}">
                        <img src="${b.changeName}" alt="세부 이미지">
                        <a href="${b.changeName }" download="${b.originName }">${b.originName }</a>
                    </c:forEach>
                </td>
            </tr>

            <tr>
                <td colspan="4"><p style="height:150px;">${board.boardContent }</p></td>
            </tr>
        </table>
        <br>


        <!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
        <div align="center">
            <c:if test="${loginUser.userId eq b.boardWriter}">

                <a class="btn btn-primary" onclick="location.href = 'updateForm.bo?bno=${board.boardNo}'">수정하기</a>
                <a class="btn btn-danger" onclick="postFormSubmit('delete')">삭제하기</a>
            </c:if>
        </div>
        <br><br>

        <form action="" method="GET" id="getForm">
            <input type="hidden" name="bno" value="${board.boardNo}">
        </form>

        <script>
            function postFormSubmit(type){
                const formEl = document.querySelector("#postForm");
                switch(type){
                    case "edit" : {
                        //formEl.action = "updateForm.bo";
                        $(formEl).attr("action", "updateForm.bo");
                    }break;
                    case "delete":{
                        //formEl.action = "delete.bo";
                        $(formEl).attr("action", "delete.bo")
                    }break;
                }

                $(formEl).submit();
            }
        </script>


        <table id="replyArea" class="table" align="center">
            <thead>
            <c:choose>
                <c:when test="${empty loginUser }">
                    <tr>
                        <th colspan="2">
                            <textarea class="form-control" readonly cols="55" rows="2" style="resize:none; width:100%;">로그인 후 이용 가능합니다.</textarea>
                        </th>
                        <th style="vertical-align:middle"><button class="btn btn-secondary disabled">등록하기</button></th>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <th colspan="2">
                            <textarea class="form-control" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
                        </th>
                        <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="addReply();">등록하기</button></th>
                    </tr>
                </c:otherwise>
            </c:choose>



            <tr>
                <td colspan="3">댓글(<span id="rcount">0</span>)</td>
            </tr>

            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
    <br><br>


</div>

<jsp:include page="../common/footer.jsp" />
</body>
</html>