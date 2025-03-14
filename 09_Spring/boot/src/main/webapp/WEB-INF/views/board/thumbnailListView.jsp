
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>


<div class="content">
  <br><br>
  <div class="innerOuter" style="padding:5% 10%;">
    <h2>사진게시판</h2>
    <br>
    <!-- 로그인 후 상태일 경우만 보여지는 글쓰기 버튼 -->
    <c:if test="${not empty loginUser}">
      <a class="btn btn-secondary" style="float:right;" href="enrollForm.th">글쓰기</a>
      <br>
    </c:if>

    <br>
    <table id="boardList" class="table table-hover" align="center">
      <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>첨부파일</th>
      </tr>
      </thead>
      <tbody>
      <div class="list-area">

            <c:forEach var="b" items="${list}">


              <div class="thumbnail" align="center" onclick="location.href = 'detail.th?bno=${b.boardNo}'">
                <img width="200px" height="150px" src="${b.changeName}" alt="썸네일이미지">
                <p>
                  <span>No. ${b.boardNo} ${b.boardTitle}</span><br>
                  조회수 : ${b.count}
                </p>
              </div>


            </c:forEach>


            <c:if test="${loginUser != null}">
              <div align="center">
                <a href="/enrollForm.th" class="btn btn-sm btn-primary">게시글 작성</a>
              </div>
            </c:if>

      </div>
      </tbody>
    </table>

    <br>

    <div id="pagingArea">
      <ul class="pagination">

        <c:choose>
          <c:when test="${ pi.currentPage eq 1 }">
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
          </c:when>
          <c:otherwise>
            <li class="page-item"><a class="page-link" href="list.bo?cpage=${pi.currentPage - 1}">Previous</a></li>
          </c:otherwise>
        </c:choose>

        <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
          <li class="page-item"><a class="page-link" href="list.bo?cpage=${p}">${p}</a></li>
        </c:forEach>

        <c:choose>
          <c:when test="${ pi.currentPage eq pi.maxPage }">
            <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
          </c:when>
          <c:otherwise>
            <li class="page-item"><a class="page-link" href="list.bo?cpage=${pi.currentPage + 1}">Next</a></li>
          </c:otherwise>
        </c:choose>

      </ul>
    </div>

    <br clear="both"><br>

    <form id="searchForm" action="" method="get" align="center">
      <div class="select">
        <select class="custom-select" name="condition">
          <option value="writer">작성자</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
      </div>
      <div class="text">
        <input type="text" class="form-control" name="keyword">
      </div>
      <button type="submit" class="searchBtn btn btn-secondary">검색</button>
    </form>
    <br><br>
  </div>
  <br><br>

</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
