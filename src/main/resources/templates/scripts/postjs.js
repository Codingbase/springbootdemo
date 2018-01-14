$.ajax({
    //请求方式为get
    type: "GET",
    //json文件位置
    url: "http://127.0.0.1:8081/girl/girls",
    //返回数据格式为json
    dataType: "json",
    //请求成功完成后要执行的方法
    success: function (data) {
        //使用$.each方法遍历返回的数据date,插入到id为#result中
        console.log(data);
        for (var i=0;i<data.length;i++) {
            var id = data[i].id;
            var cup = data[i].cupSize;
            var age = data[i].age;
            $("#test").append("<tr><td>"+id+cup+age+"</td></tr>");
        }

    }
});
