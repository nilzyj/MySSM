<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css" />
</head>
<body>
所有数据：<br/>
<#--<#list message as m>
    <#if m??>
        name:${m.name}, age:${m.age}, sex:${m.sex}<br/>
    </#if>
</#list>-->
<input class="label-success" type="text" id="user">
<input class="label-success" type="text" id="password">
<button id="sub">submit</button><br/>
查询结果：<br/>
<#list data as q>
    <#if q??>
        name:${q.name},age:${q.age},sex:${q.sex}<br/>
    </#if>
</#list>
<script src="/assets/js/jquery-3.2.1.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8">
    var webBase = "${request.contextPath}";
    $("#sub").click(function () {
        var user = $("#user").val();
        var age = $("#password").val();
        $.post(webBase + "/hello.do", {
            name:user,
            age:age
        }, function (data) {
            console.log(data);
        });
    });
</script>
</body>
</html>
