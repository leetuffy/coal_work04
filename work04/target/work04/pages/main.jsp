<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path =request.getContextPath();
%>
<html>
<head>
    <title>煤矿大数据界面</title>
    <link  href="<%=path%>/css/comon0.css" rel="stylesheet">
    <script src="<%=path%>/js/jquery-3.5.1.js"></script>
    <style type="text/css">
        .left_div{
            height: 335px;
        }
    </style>
</head>
<body>


    <div class="head">
    <h1>大数据可视化展板通用模板</h1>
    <div class="weather"><span id="showTime"></span></div>

    <script>
        var t = null;
        t = setTimeout(time,1000);//開始运行
        function time()
        {
            clearTimeout(t);//清除定时器
            dt = new Date();
            var y=dt.getFullYear();
            var mt=dt.getMonth()+1;
            var day=dt.getDate();
            var h=dt.getHours();//获取时
            var m=dt.getMinutes();//获取分
            var s=dt.getSeconds();//获取秒
            document.getElementById("showTime").innerHTML = y+"年"+mt+"月"+day+"日-"+h+"时"+m+"分"+s+"秒";
            t = setTimeout(time,1000); //设定定时器，循环运行
        }

    </script>

        <div class="mainbox">
            <ul class="clearfix">
                <li>
                    <div class="boxall left_div" >
                        <div class="alltitle">一氧化碳</div>
                        <div class="allnav" id="echart1">
                            <iframe src="/coal/co" scrolling="yes" frameborder="0" style="width: 100%;height: 100%;"></iframe>
                        </div>
                        <div class="boxfoot"></div>
                    </div>
                    <div class="boxall left_div" >
                        <div class="alltitle">瓦斯</div>
                        <div class="allnav" id="echart2">
                            <iframe src="/coal/wasi" scrolling="yes" frameborder="0" style="width: 100%;height: 100%;"></iframe>
                        </div>
                        <div class="boxfoot"></div>
                    </div>
<%--                    <div class="boxall" style="height: 3.2rem">--%>
<%--                        <div style="height:100%; width: 100%;">--%>
<%--                            <div class="sy" id="fb1"></div>--%>
<%--                            <div class="sy" id="fb2"></div>--%>
<%--                            <div class="sy" id="fb3"></div>--%>
<%--                        </div>--%>
<%--                        <div class="boxfoot">--%>

<%--                        </div>--%>
<%--                    </div>--%>
                </li>
                <li>
                    <div class="bar">
                        <div class="barbox">
                            <ul class="clearfix">
                                <li class="pulll_left counter">
                                    <p style="color: white;font-size: 20px">起始时间</p>
                                    <input style="font-size: 10px" type="datetime-local" id="start_date">
                                </li>
                                <li class="pulll_left counter">
                                    <p style="color: white;font-size: 20px">终止时间</p>
                                    <input style="font-size: 10px" type="datetime-local" id="end_date">
                                </li>
                            </ul>
                        </div>
                        <div class="barbox2">
                            <ul class="clearfix">
                                <li class="pulll_left" style="width: 33%;" id="max">最大值 </li>
                                <li class="pulll_left" style="width: 33%;" id="min">最小值</li>
                                <li class="pulll_left" style="width: 33%;" id="avg">平均值</li>
                            </ul>
                        </div>
                    </div>
                    <div class="map">
                        <div class="map1"><img src="<%=path%>/images/lbx.png"></div>
                        <div class="map2"><img src="<%=path%>/images/jt.png"></div>
                        <div class="map3"><img src="<%=path%>/images/map.png"></div>
                        <div class="map4" id="map_1"></div>
                    </div>
                </li>
                <li>
                    <div class="boxall" style="height:222px">
                        <div class="alltitle">模块标题样式</div>
                        <div class="allnav" id="echart4"></div>
                        <div class="boxfoot"></div>
                    </div>
                    <div class="boxall" style="height: 222px">
                        <div class="alltitle">模块标题样式</div>
                        <div class="allnav" id="echart5"></div>
                        <div class="boxfoot"></div>
                    </div>
                    <div class="boxall" style="height: 222px">
                        <div class="alltitle">模块标题样式</div>
                        <div class="allnav" id="echart6"></div>
                        <div class="boxfoot"></div>
                    </div>
                </li>
            </ul>
        </div>

</div>
</body>
</html>
