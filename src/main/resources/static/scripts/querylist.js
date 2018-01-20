//跳转页面函数
function jump() {
    window.location.href="http://localhost:8081/girl/req";
}
//ajax请求方法需要先使用function这个方法 在里面写$.ajax
// 通过绑定按钮查询结果并展示出来
$(function () {
    $("#mybutton").find(".btn").click(function () {
        $.ajax({
            //请求方式为get  //
            type: "GET",
            //json文件位置
            url: "http://127.0.0.1:8081/girl/girls",
            //返回数据格式为json
            dataType: "json",
            //请求成功完成后要执行的方法
            success: function (data) {
                //使用$.each方法遍历返回的数据date,插入到id为#result中
                console.log(data);
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var api = data[i].api;
                    var age = data[i].age;
                    var money = data[i].money;
                    $("#test").append("<tr><td>" + id + api + age + money+"</td></tr>");
                }

            }
        });
    });
});
