<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        Object co = session.getAttribute("co");
    %>
    <title>Title</title>
    <script src="<%=path%>/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(document).ready(
            function () {
                var ps = document.getElementsByTagName("b");
                for (var i = 0; i < ps.length; i++ ) {
                    var s = ps[i].innerText + '';
                    if (s.indexOf("CO")!==-1)
                    {
                        // console.log("111111")
                        s = s.replace(/CO/g,'').trim();
                    }
                    if (s.indexOf("一氧化碳")!==-1)
                    {
                        // console.log("2222222")
                        s = s.replace(/一氧化碳/g,'').trim();
                    }
                    ps[i].innerText = s;
                }
            }
        )
        function select(object) {
            var name = object.name;
            $.post('/coal/data_select',
                {"type":"co","name":name},
                function (data) {
                    // console.log(data['TimeList'][0])
                    parent.document.getElementById("max").innerHTML = "<span style='font-size: 10px;color: white'>最大值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['max']+"</b>"
                    parent.document.getElementById("min").innerHTML = "<span style='font-size: 10px;color: white'>最小值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['min']+"</b>"
                    parent.document.getElementById("avg").innerHTML = "<span style='font-size: 10px;color: white'>平均值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['average']+"</b>"
                    var min = data['TimeList'][0].replace(/\s/g,'T')
                    var max = data['TimeList'][data['TimeList'].length-1].replace(/\s/g,'T')
                    console.log(min)
                    parent.document.getElementById("start_date").value = min
                    parent.document.getElementById("start_date").min = min
                    parent.document.getElementById("end_date").min = min
                    parent.document.getElementById("end_date").value = max
                    parent.document.getElementById("end_date").max = max
                    parent.document.getElementById("start_date").max = max

                })
        }
    </script>
    <style>
        ::-webkit-scrollbar {width:5px;height:5px;position:absolute}
        ::-webkit-scrollbar-thumb {background-color:#5bc0de}
        ::-webkit-scrollbar-track {background-color:#ddd}
        .btn{
            /*font-size: 10px;*/
            border-radius: 8px;
            float: right;
        }
    </style>
</head>
<body>
<table style="width: 100%">
    <c:forEach var="item" items="<%=co%>">
        <tr>
            <td style="vertical-align: middle">
                <b style="color: white;height: 25px;font-family: 仿宋">
                        ${item}

                </b>
                <button class="btn" name="${item}" onclick="select(this)">选择</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
