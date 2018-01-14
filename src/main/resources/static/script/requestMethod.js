/**
 * Created by shen on 2018/1/14.
 * HTTP请求方法GET,POST调用
 */
//获取点击提交事件 #获取id
//*******************************get request*********************************************
var btn = $("#submit");
btn.click(function () {
    // # 获取id=phonen的值
    var url = 'url=' + $('#url').val();
    var param = $('#param').val();

    console.log('p..', url, param);
    console.log(url);
    $.ajax({
        url: 'http://localhost:8081/girl/demo/gettest' + "?" + url + param,
        type: 'GET',
        //data:  url,
        dataType: 'json',
        success: function (data) {
//            对象转字符串
            console.log(data);
            var tt = JSON.stringify(data);
//            字符串转json
            var response = JSON.parse(tt);
            console.log(response);
            $("#show").append(tt);
//            打印json中的一个value
//            console.log(data.mts);
//            console.log(typeof data);
//                $("#show").append("<table frame='box'><tr><th>" + data.mts + "</th><th>" + data.carrier + "</th><th>" + data.province + "</th><th>" + data.catName + "</th><th>" + data.telString + "</th></tr></table>");
        }
    });
});

//*****************************post request********************************************
var btns = $("#submits");
btns.click(function () {
    var urls = $('#urls').val();
    var paramsV = $('#params').val();

    console.log('p..', urls, params);
    console.log(urls);

    $.post("http://localhost:8081/girl/demo/test"
        ,{url:urls,params:paramsV},
        function(data){
            //            对象转字符串
            console.log(data);
            var tt = JSON.stringify(data);
//            字符串转json
             var response = JSON.parse(tt);
             console.log(response);
             $("#show").append(tt);
    });
//     $.ajax({
//         url: 'http://localhost:8081/girl/demo/test' + "?" + urls,
//         type: 'POST',
//         data:  {"params":params},
//         dataType: 'json',
//         success: function (data) {
// //            对象转字符串
//             console.log(data);
//             var tt = JSON.stringify(data);
// //            字符串转json
//             var response = JSON.parse(tt);
//             console.log(response);
//             $("#show").append(tt);
//         }
//     });
});