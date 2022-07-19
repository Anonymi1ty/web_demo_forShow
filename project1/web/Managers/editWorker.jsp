<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h3>Warehouse Monitoring System</h3>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3>Add New Worker</h3>
                                    </div>
                                    <div class="card-body">

                                        <form action="/workerServlet" method="post">
                                            <input type="hidden" name="action" value="update">
                                            <div class="form-group">
                                                <label for="Worker_id">Worker Id</label>
                                                <input type="text" class="form-control" name="id" value="${requestScope.worker.id}" id="Worker_id" readonly>
                                            </div>
                                            <div class="form-group">
                                                <label for="Worker_name">Worker Name</label>
                                                <input type="text" class="form-control" name="workerName" value="${requestScope.worker.workerName}" id="Worker_name" placeholder="Enter Worker Name">
                                            </div>
                                            <div class="form-group">
                                                <label for="Worker_quantity">Worker PhoneNumber</label>
                                                <input type="text" class="form-control" name="phoneNumber" value="${requestScope.worker.phoneNumber}" id="Worker_quantity" placeholder="Enter Worker PhoneNumber">
                                            </div>
                                            <button type="submit" class="btn btn-primary">Edit Worker</button>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <style>
        .btn-primary{
            margin-top: 20px;
        }
        a{
            color: black;
        }
    </style>
</body>
</html>