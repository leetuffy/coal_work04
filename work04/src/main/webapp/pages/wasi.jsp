<%@ page import="java.util.Set" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        Object wasi = session.getAttribute("wasi");
    %>
    <title>Title</title>
    <script src="<%=path%>/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" language="JavaScript">
            function change_text() {
                var ps = document.getElementsByTagName("b");
                for (var i = 0; i < ps.length; i++) {
                    var s = ps.item(i).innerText + '';
                    // break
                    if (s.indexOf("CH4")!==-1)
                    {
                        s = s.replace(/CH4/g,'').trim();
                    }

                    if (s.indexOf("瓦斯")!==-1)
                    {
                        s = s.replace(/瓦斯/g,'').trim();
                    }

                    ps.item(i).innerText = s
                }
            }
        function select(object) {
            var name = object.name;
            $.post('/coal/data_select',
                {"type":"wasi","name":name},
            function (data) {
                console.log(data)
                parent.document.getElementById("max").innerHTML = "<span style='font-size: 10px;color: white'>最大值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['max']+"</b>"
                parent.document.getElementById("min").innerHTML = "<span style='font-size: 10px;color: white'>最小值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['min']+"</b>"
                parent.document.getElementById("avg").innerHTML = "<span style='font-size: 10px;color: white'>平均值:</span><b style='padding-left: 20px;font-size: 10px;color: white'>"+data['average']+"</b>"
            })
        }
    </script>
    <style>
        /*body{*/
        /*    height: 400px;*/
        /*}*/
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
<body onload="change_text()">
<%--    ${wasi.get(0)}--%>
<table style="width: 100%">
    <c:forEach var="item" items="<%=wasi%>">
        <tr>
            <td style="vertical-align: middle">
                <b style="color: white;height: 25px;font-family: 仿宋" >
                        ${item}
<%--                            <button class="btn" name="${item}" onclick="select(this)"></button>--%>
                </b>
                <button class="btn" name="${item}" onclick="select(this)">选择</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
