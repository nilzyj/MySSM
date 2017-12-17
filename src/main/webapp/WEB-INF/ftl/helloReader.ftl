<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${request.contextPath}/assets/css/bootstrap.min.css" />
</head>
<body>
<#list message as m>
    <#if m??>
        name:${m.name}, age:${m.age}, sex:${m.sex}<br/>
    </#if>
</#list>
<input class="label-success" aria-label="user" type="input" id="user">
<input class="label-success" aria-label="password" type="input" id="password">
<a onclick="sub()">submit</a><br/>
<#list query as q>
    <#if q??>
    name:${q.name}, age:${q.age}, sex:${q.sex}<br/>
    </#if>
</#list>
<script src="${request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/assets/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
    function sub() {
        var user = $("#user").val();
        var password = $("#password").val();
        $.post("${request.contextPath}" + "/hello.do", {
          name:user,
          password:password
        }, function (data) {
            var res = eval("'" + data + "'");
            alert(res.name);
        });

    }
</script>
</body>
</html>
