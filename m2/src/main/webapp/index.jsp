<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <!--跨域问题-->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<input type="button" id="button" value="跨域"/>
<input type="button" id="button2" value="跨域2"/>
<input type="button" id="button3" value="跨域3"/>
<input type="button" id="button4" value="跨域的本质"/>
<input type="button" id="button5" value="JsonP方式跨域4"/>

<div id="script_div"></div>
<script type="text/javascript">
    $("#button").click(function(){
        $.ajax({url: "http://localhost:8081/hello", success: function(result){
                // $("#div1").html(result);
                console.log(result);
            }});
    });

    $("#button2").click(function(){
        $.ajax({url: "http://localhost:8081/hello2", success: function(result){
                // $("#div1").html(result);
                console.log(result);
            }});
    });

    $("#button3").click(function(){
        $.ajax({url: "http://127.0.0.1:8082/api/hello3", success: function(result){
                console.log(result);
            }});
    });

    $("#button4").click(function(){
        //127.0.0.1 与localhost不一样，这样也算跨域
        //跨域的本质是:
        //协议//域名//端口,任意一个不一致都是跨域
        $.ajax({url: "http://localhost:8082/hello4", success: function(result){
                console.log(result);
            }});
       // eval(html);
    });

    $("#button5").click(function(){
        console.log("待封装");
    });

    //前面的属于正向跨域实现方式，还可以实现反向代理的跨域方式
    //使用nginx代理，由nginx反向查找服务器屏蔽客户端浏览器同源策略带来的跨域
    //问题，有点类似hello3 proxy 正向服务器的代理方式，但是nginx属于反向代理
    //由服务器之间互相通信屏蔽了跨域问题

    function myFun (data){
        console.log(data);
    }
</script>

<!--jsonp的方式只能支持get请求, 然后返回的字符串是一个调用了本地myFun的拼接字符串-->
<script src="http://localhost:8081/hello5"></script>
</body>
</html>
