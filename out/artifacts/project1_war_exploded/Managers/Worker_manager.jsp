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
            <c:forEach items="${requestScope.workers}" var="worker">
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
    </div>
<style>
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