/**
 * Created by JasonTang on 6/24/2017.
 */
$(function () {
    // 获取已登录用户信息
    var getSucFunc = function (responseData) {
        if (responseData.success) {
            var user = responseData.data;
            console.log(responseData);
            $("#userId").val(user.userId);
            $("#userName").val(user.userName);
            if(user.userSex == "男") {
                $("#sex1").parent().addClass("checked").attr("checked","checked");
            }
            if(user.userSex == "女") {
                $("#sex2").parent().addClass("checked").attr("checked","checked");
            }
            $("#userEmail").val(user.userEmail);
            $("#userTel").val(user.userTel);
            $("#userBirth").val(user.userBirth);
            $("#userIDCard").val(user.userIDCard);
        } else {
            swal({
                title: "Sorry!",
                text: responseData.msg,
                timer: 2000,
                type: "error"
            });
        }
    }
    var userTel = $(window.parent.document).find('#userTel')[0].value;
    get_user_uri += userTel;
    common_ajax(null, get_user_uri, "GET", getSucFunc, null, null);

    /**
     * 更新回调
     * @param responseData
     */
    var updateSucFunc = function (responseData) {
        if (responseData.success) {
            swal({
                title: "Good Job!",
                text: "信息更新成功",
                timer: 2000,
                type: "success"
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

    /**
     * 更新
     * @param form
     */
    function update(form) {
        common_ajax(form, update_uri, "POST", updateSucFunc, null, null);
    }
    /**
     * 更新信息
     * @type {jQuery}
     */
    var form = $("#update-form").Validform({
            tiptype: 3,
            beforeSubmit: function (curform) {
                console.log(curform[0]);
                update(curform);
                return false;
            }
        }
    );

    $('input[type=radio]').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
    });
})