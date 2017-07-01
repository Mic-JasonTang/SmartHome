/**
 * Created by JasonTang on 7/1/2017.
 */
$(function () {
    $("#door").bootstrapSwitch({
        onText: "开门",
        offText: "关门",
        onColor: "success",
        offColor: "danger",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("0");
                // 关门
                openOrCloseDoor(0);
            } else {
                // 开门
                $(this).val("1");
                openOrCloseDoor(1);
            }
        }
    });
    $("#yanwu").bootstrapSwitch({
        onText: "启动",
        offText: "停止",
        onColor: "success",
        offColor: "danger",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("0");
            }
        }
    });
    $("#keting").bootstrapSwitch({
        onText: "开灯",
        offText: "关灯",
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("0");
            }
        }
    });
    $("#zhuwo").bootstrapSwitch({
        onText: "开灯",
        offText: "关灯",
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("0");
            }
        }
    });
    $("#ciwo").bootstrapSwitch({
        onText: "开灯",
        offText: "关灯",
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("0");
            }
        }
    });
    $("#kitchen").bootstrapSwitch({
        onText: "开灯",
        offText: "关灯",
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $(this).val("1");
            } else {
                $(this).val("0");
            }
        }
    });

});

/**
 * 开门或者关门
 * @param status
 */
function openOrCloseDoor(status) {
    
    var sucFunc = function (responseData) {
        if (responseData.success) {
            $("#target").text("大门");
            if (status == 1) {
                $("#status").text("已开启成功");
            } else {
                $("#status").text("已关闭成功");
            }
            $("#tip").show();
            setTimeout(function () {
                $("#tip").hide();
            }, 2000);
        } else {
            swal({
                title: "Sorry!",
                text: responseData.msg,
                timer: 2000,
                type: "error"
            });
        }
    }
    var data = {
        "status" : status
    }
    common_ajax(null, openOrCloseDoor_uri, "POST", sucFunc, data, null);
}