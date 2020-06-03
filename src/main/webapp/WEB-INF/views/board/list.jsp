<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>



        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
            <!-- /.row -->
        <!--add-->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"> Board List Page </div>

                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>#번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                    <th>수정일</th>
                                </tr>
                            </thead>

                            <c:forEach items="${list}" var="board">

                                <tr>
                                    <td><c:out value="${board.bno}"></c:out></td>
                                    <td><c:out value="${board.title}"></c:out></td>
                                    <td><c:out value="${board.writer}"></c:out></td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                </tr>

                            </c:forEach>
                        </table>
                    </div>

                </div>
            </div>
        </div>

        <!-- /.row -->
<%@include file="../includes/footer.jsp"%>