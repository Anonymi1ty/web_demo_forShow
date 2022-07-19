<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Worker_manager</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
</head>
<body>
    <div class="main">
        <table width="90%" class="table">
            <caption>
                <h2>
                    成员信息表</h2>
            </caption>
            <thead>
                <tr>
                    <td>id</td>
                    <td>姓名</td>
                    <td>手机号</td>
                    <td colspan="2">操作</td>
                </tr>
            </thead>
            <c:forEach items="${requestScope.page.items}" var="worker">
                <tr>
                    <td>${worker.id}</td>
                    <td>${worker.workerName}</td>
                    <td>${worker.phoneNumber}</td>
                    <td><a href="/workerServlet?action=getWorker&id=${worker.id}">修改</a></td>
                    <td><a class="deleteClass" href="/workerServlet?action=delete&id=${worker.id}">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4"></td>
                <td><a href="/Managers/addWorker.html">添加员工</a></td>
            </tr>
        </table>

        <div class="page-icon">
            <c:if test="${requestScope.page.pageNo>1}">
                <a href="/workerServlet?action=page&pageNo=${requestScope.page.pageNo-1}&pageSize=5">上一页</a>
            </c:if>
            <%--页码输出--%>
            <c:choose>
                <%--当小于五页数据--%>
                <c:when test="${requestScope.page.pageTotal<=5}">
                    <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            <span class="page-current">${i}</span>
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="/workerServlet?action=page&pageNo=${i}&pageSize=5">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--当大于五页数据--%>
                <c:when test="${requestScope.page.pageTotal>5}">
                    <c:choose>
                        <%--小情况1：当前页码为前面3个，只显示1-5--%>
                        <c:when test="${requestScope.page.pageNo<=3}">
                            <c:forEach begin="1" end="5" var="i">
                                <c:if test="${i==requestScope.page.pageNo}">
                                    <span class="page-current">${requestScope.page.pageNo}</span>
                                </c:if>
                                <c:if test="${i!=requestScope.page.pageNo}">
                                    <a href="/workerServlet?action=page&pageNo=${i}&pageSize=5">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <%--小情况2：当前页码为后面3个，只显示后五个--%>
                        <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                            <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                                <c:if test="${i==requestScope.page.pageNo}">
                                    <span class="page-current">${requestScope.page.pageNo}</span>
                                </c:if>
                                <c:if test="${i!=requestScope.page.pageNo}">
                                    <a href="/workerServlet?action=page&pageNo=${i}&pageSize=5">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <%--小情况3：当前页码为中介页，只显示后五个--%>
                        <c:otherwise>
                            <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                                <c:if test="${i==requestScope.page.pageNo}">
                                    <span class="page-current">${requestScope.page.pageNo}</span>
                                </c:if>
                                <c:if test="${i!=requestScope.page.pageNo}">
                                    <a href="/workerServlet?action=page&pageNo=${i}&pageSize=5">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
            <%--下一页--%>
            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
                <a class="page-next" href="/workerServlet?action=page&pageNo=${requestScope.page.pageNo+1}&pageSize=5">下一页<i></i></a>
            </c:if>
            <br>
            <span class="page-disabled" id="info">总共${requestScope.page.pageTotalCount}条记录</span>
        </div>
    </div>

<style>
    #info{
        display: block;
        border:none;
        margin-top: 30px;
    }
    table
    {
        border-collapse: collapse;
        margin: 0 auto;
        text-align: center;
    }
    table td, table th
    {
        border: 1px solid #cad9ea;
        color: #666;
        height: 30px;
    }
    table thead th
    {
        background-color: #CCE8EB;
        width: 100px;
    }
    table tr:nth-child(odd)
    {
        background: #fff;
    }
    table tr:nth-child(even)
    {
        background: #F5FAFA;
    }
    .page-icon{
        margin:20px 0 0 0;/*设置距离顶部20像素*/
        font-size:0;/*修复行内元素之间空隙间隔*/
        text-align:center;/*设置内容居中显示*/
    }

    /*设置共有的的样式布局，主要是进行代码优化，提高运行效率*/
    .page-icon a,.page-disabled,.page-next{
        border:1px solid #ccc;
        border-radius:3px;
        padding:4px 10px 5px;
        font-size:14PX;/*修复行内元素之间空隙间隔*/
        margin-right:10px;
    }

    /*对 a 标签进行样式布局 */
    .page-icon a{
        text-decoration:none;/*取消链接的下划线*/
        color:#005aa0;
    }

    .page-current{
        color:#ff6600;
        padding:4px 10px 5px;
        font-size:14PX;/*修复行内元素之间空隙间隔*/
    }

    .page-disabled{
        color:#ccc;
    }

    .page-next i,.page-disabled i{
        cursor:pointer;/*设置鼠标经过时的显示状态，这里设置的是显示状态为小手状态*/
        display:inline-block;/*设置显示的方式为行内块元素*/
        width:5px;
        height:9px;
        background-image:url(http://img.mukewang.com/547fdbc60001bab900880700.gif);/*获取图标的背景链接*/
    }
    .page-disabled i{
        background-position:-80px -608px;
        margin-right:3px;
    }

    .page-next i{
        background-position:-62px -608px;
        margin-left:3px;
    }
</style>

<script type="text/javascript">
    //页面加载完成之后
    $(function(){
        //给删除的按钮绑定事件
        $("a.deleteClass").click(function (){
            /**
             * confirm 是确认提交窗口
             * 有两个按钮，一个确认(ture)一个取消(false)
             */
            return confirm("确定要移除【"+$(this).parent().parent().find("td:nth-of-type(2)").text()+"】");//当前元素的 父类的父类的第二个 的文本内容
        })
    })
</script>
</body>
</html>