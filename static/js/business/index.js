/**
 * Created by JasonTang on 6/23/2017.
 */
var tab, index = 0;
$(function () {

    // 获取已登录用户信息
    var getSucFunc = function (responseData) {
        if (responseData.success) {
            var username = responseData.data.userName;
            var userTel = responseData.data.userTel;
            if (username == null) {
                username = "未设置用户名";
            } else {
                username = "欢迎 " + username;
            }
            $("#userTel").val(userTel);
            $("#userName").text(username);
        } else {
            swal({
                title: "Sorry!",
                text: responseData.msg,
                timer: 2000,
                type: "error"
            }, function () {
                window.location.href = "login.html";
            });
        }
    }
    getLoginedInfo();

    function getLoginedInfo() {
        common_ajax(null, get_logined_user_uri, "GET", getSucFunc, null, null);
    }

    tab = $("#slide").KandyTabs({
        del: true,
        scroll: true,
        trigger: 'click',
        custom: function (b, c, i) {
            $("p", c).fadeOut();
            c.eq(i).find("p").slideDown(1500);
            index = i;
        },
        done: function (btn, cont, tab) {
            $("#slide .tabbtn").each(function (i) {
                if ($(this).text().indexOf("我的桌面") > -1)//如果当前选项卡是我的桌面
                {
                    $(this).css({
                        "background": "#027be4",
                        "border-bottom": "1px solid #027be4",
                        "font-weight": "bold",
                        "color": "#ffffff"
                    });//修改选项景色
                    $(this).find('.tabdel').text("");//	去除关闭按钮
                }
            });
            setIframeH();//前台设定IFRAME高度 最好在在登录时把高度获取存放到session供其他IFRAME使用
        }
    });

   var logoutSucFunc =  function (responseData) {
        if (responseData.success) {
            swal({
                title: "Good Job!",
                text: "您已经注销成功",
                type: "success",
                showConfirmButton: false,
                timer: 1500
            }, function () {
                window.location.href = "login.html";
            });
        } else {
            swal({
                title: "Sorry!",
                text: responseData.msg,
                timer: 2000,
                type: "error"
            });
        }
    };

    $("#logout").click(function () {
            swal({
                    title: "是否注销?",
                    text: "即将注销账户",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "注销",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    closeOnCancel: true,
                    showLoaderOnConfirm: true
                },
                function (isConfirm) {
                    if (isConfirm) {
                        setTimeout(function () {
                            common_ajax(null, logout_uri, "DELETE", logoutSucFunc, null, null);
                        }, 1200);
                    }
                })
        }
    )

    $("#refresh").click(function () {
        getLoginedInfo();
    });
});

