/**
 * Created by JasonTang on 6/23/2017.
 */
$(function () {
    /**
     * 登录 注册 切换
     */
    $("#showLogin").click(function () {
        $("#login-div").show();
        if(!$(this).hasClass("active")) {
            $(this).addClass("active");
        }
        $("#slide_bar").removeClass("slide-bar1")
        $("#reg-div").hide();
    });
    $("#showReg").click(function () {
        $("#reg-div").show();
        if(!$(this).hasClass("active")) {
            $(this).addClass("active");
        }
        $("#slide_bar").addClass("slide-bar1")
        $("#login-div").hide();
    });

    /**
     * 登录成功回调函数
     * @param responseData
     */
    function login(form) {
        var loginSucFunc = function(responseData){
            if(responseData.success){
                location.href="index.html";
            } else {
                swal({
                    title: "Sorry!",
                    text: responseData.msg,
                    timer: 2000,
                    type: "error"
                });
            }
        };
        common_ajax(form, login_uri, "POST", loginSucFunc, null, null);
    }

    /**
     * 注册
     * @param form
     */
    function reg(form) {
        var regSucFunc = function (responseData) {
            if(responseData.success){
                swal({
                    title: "Good Job!",
                    text: "注册成功",
                    timer: 2000,
                    type: "success"
                });
                //设置延时2s之后执行下面函数
                setTimeout(function(){
                    $("#showLogin").click();
                    form[0].reset();
                },2000);
            } else {
                swal({
                    title: "Sorry!",
                    text: responseData.msg,
                    timer: 2000,
                    type: "error"
                });
            }
        }
        common_ajax(form, reg_uri, "PUT", regSucFunc, null, null);
    }

    /**
     * 校验手机号
     */
    $("#phone").change(function () {
        var checkSucFunc = function (responseData) {
            if(!responseData.success){
                swal({
                    title: "Sorry!",
                    text: responseData.msg,
                    timer: 2000,
                    type: "error"
                });
            }
        }
        var check_tel_uri = check_tel_email_uri + $("#phone").val();
        common_ajax(null, check_tel_uri, "GET", checkSucFunc, null, null);
    });

    /**
     * 校验邮箱
     */
    $("#email").change(function () {
        var checkSucFunc = function (responseData) {
            if(!responseData.success){
                swal({
                    title: "Sorry!",
                    text: responseData.msg,
                    timer: 2000,
                    type: "error"
                });
            }
        }
        var check_tel_uri = check_tel_email_uri + "/" + $("#email").val();
        common_ajax(null, check_tel_uri, "GET", checkSucFunc, null, null);
    });

    // 登录
    $("#login-form").Validform({
        tiptype: 3,
        postonce: true,
        beforeSubmit:function(curform){
            login(curform);
            return false;
        },
    });
    // 注册
    $("#reg-form").Validform({
        tiptype: 3,
        postonce: true,
        beforeSubmit:function(curform){
            reg(curform);
            return false;
        },
    });
    $("#remember-me").click(function(){
        var n = document.getElementById("remember-me").checked;
        if(n){
            $(".zt").show();
        }else{
            $(".zt").hide();
        }
    });
})