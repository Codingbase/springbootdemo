$(function () {
    $.ajax({
        type: "GET",
        dataType: " json",
        url: "http://www.layui.com/demo/table/user",
        success: function (msg) {
            // console.log(msg);
            var str = "";
            var data = msg.data;
            for (i in data) {
                // console.log("list:" + data[i].username);
                //把数据组合在一起
                str += "<tr class=\"info\">" +
                    "<td>" + data[i].id + "</td>" +
                    "<td>" + data[i].username + "</td>" +
                    "<td>" + data[i].sex + "</td>" +
                    "<td>" + data[i].city + "</td>" +
                    "<td>" + data[i].sign + "</td>" +
                    "<td>" + data[i].experience + "</td>" +
                    "<td>" + data[i].logins + "</td>" +
                    "<td>" + data[i].wealth + "</td>" +
                    "<td>" + data[i].classify + "</td>" +
                    "<td>" + data[i].score + "</td>" +
                    "</tr>"
            }
            // 获取到tbody-result这个id
            var tbody = window.document.getElementById("tbody-result");
            tbody.innerHTML = str;
        },
        error: function () {
            console.log("error!!!")
        }

    })
});
//
//     var tbody=window.document.getElementById("tbody-result");
// });
// });
//     $('#btSearch').click(function () {
//         var checkDate = $('#checkDate').val();
//         var orderNo = $('#orderNo').val();
//         var sortFiled = $('#sortFiled').val();
//         var hotelSeq = $('#hotelSeq').val();

// if (msg.ret) {
//     var str = "";
//     var data = msg.data;
//
//     for (i in data) {
//         str += "<tr>" +
//             "<td>" + data[i].hotel_seq + "</td>" +
//             "<td>" + data[i].hotel_name + "</td>" +
//             "<td>" + data[i].order_no + "</td>" +
//             "<td>" + data[i].user_phone + "</td>" +
//             "<td>" + data[i].create_time + "</td>" +
//             "<td>" + data[i].user_id + "</td>" +
//             "<td>" + data[i].cellid + "</td>" +
//             "<td>" + data[i].gps_city + "</td>" +
//             "<td>" + data[i].cell_city + "</td>" +
//             "<td>" + data[i].distance + "</td>" +
//             "</tr>";
//     }
//     tbody.innerHTML = str;
// }
