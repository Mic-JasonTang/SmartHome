/**
 * Created by JasonTang on 7/1/2017.
 */
var chart1 = null; // 定义全局变量
var chart2 = null; // 定义全局变量
$(function () {
    $("#hall").parent().click(function () {
        $(this).addClass("blue");
        $(this).parent().addClass("active");
        $("#chart_roomOrder").val("101010");
        if ($("#hall").hasClass("invisible")) {
            $("#hall").removeClass("invisible");
        }
        if (!$("#room").hasClass("invisible")) {
            $("#room").addClass("invisible");
            $("#room").parent().removeClass("blue");
            $("#room").parent().parent().removeClass("active");
        }
        if (!$("#kitchen").hasClass("invisible")) {
            $("#kitchen").addClass("invisible");
            $("#kitchen").parent().removeClass("blue");
            $("#kitchen").parent().parent().removeClass("active");
        }
        $("#chart_target").text("大厅");
        redraw1();
        getChart1();
        redraw2();
        getChart2();
    })
    $("#room").parent().click(function () {
        $(this).addClass("blue");
        $(this).parent().addClass("active");
        $("#chart_roomOrder").val("101011");
        if ($("#room").hasClass("invisible")) {
            $("#room").removeClass("invisible");
        }
        if (!$("#hall").hasClass("invisible")) {
            $("#hall").addClass("invisible");
            $("#hall").parent().removeClass("blue");
            $("#hall").parent().parent().removeClass("active");
        }
        if (!$("#kitchen").hasClass("invisible")) {
            $("#kitchen").addClass("invisible");
            $("#kitchen").parent().removeClass("blue");
            $("#kitchen").parent().parent().removeClass("active");
        }
        $("#chart_target").text("卧室");
        redraw1();
        getChart1();
        redraw2();
        getChart2();
    })
    $("#kitchen").parent().click(function () {
        $(this).addClass("blue");
        $(this).parent().addClass("active");
        $("#chart_roomOrder").val("101012");
        if ($("#kitchen").hasClass("invisible")) {
            $("#kitchen").removeClass("invisible");
        }
        if (!$("#room").hasClass("invisible")) {
            $("#room").addClass("invisible");
            $("#room").parent().removeClass("blue");
            $("#room").parent().parent().removeClass("active");
        }
        if (!$("#hall").hasClass("invisible")) {
            $("#hall").addClass("invisible");
            $("#hall").parent().removeClass("blue");
            $("#hall").parent().parent().removeClass("active");
        }
        $("#chart_target").text("厨房");
        redraw1();
        getChart1();
        redraw2();
        getChart2();
    })
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
    $("#light_kitchen").bootstrapSwitch({
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

    // 卧室烟雾
    detect(1, 101011,1);
    // 厨房烟雾
    detect(2, 101012,1);
    // 厨房液化气
    detect(3, 101012,2);
    // 大厅 温湿度
    getLastestData(1, 101010, 1);
    getLastestData(1, 101010, 2);
    // 卧室 温湿度
    getLastestData(2, 101011, 1);
    getLastestData(2, 101011, 2);
    // 厨房 温湿度
    getLastestData(3, 101012, 1);
    getLastestData(3, 101012, 2);
    // 烟雾探测 2s
    setInterval(function () {
        // 卧室烟雾
        detect(1, 101011,1);
        // 厨房烟雾
        detect(2, 101012,1);
        // 厨房液化气
        detect(3, 101012,2);
    }, 2000);

    // 温度湿度实时数据，5s
    setInterval(function () {
        // 大厅 温湿度
        getLastestData(1, 101010, 1);
        getLastestData(1, 101010, 2);
        // 卧室 温湿度
        getLastestData(2, 101011, 1);
        getLastestData(2, 101011, 2);
        // 厨房 温湿度
        getLastestData(3, 101012, 1);
        getLastestData(3, 101012, 2);
    }, 5000);

    // 温度湿度 图形数据10s
    setInterval(function () {
        redraw1();
        getChart1();
    },10000);
    setInterval(function () {
        redraw2();
        getChart2();
    },13000);
    //图形数据
    chart1 = new Highcharts.Chart({
        chart: {
            renderTo: 'container1',
            type: 'line',
            events: {
                load: getChart1() // 图表加载完毕后执行的回调函数
            }
        },
        title: {
            text: '温度变化图'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '温度(℃)'
            },
            min: 0
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true          // 开启数据标签
                },
                enableMouseTracking: false // 关闭鼠标跟踪，对应的提示框、点击事件会失效
            }
        },
        series: [{
            name: '温度',
            data: []
        }]
    });
    //图形数据
    chart2 = new Highcharts.Chart({
        chart: {
            renderTo: 'container2',
            type: 'line',
            events: {
                load: getChart2() // 图表加载完毕后执行的回调函数
            }
        },
        title: {
            text: '湿度变化图'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '湿度(%)'
            },
            min: 0
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true          // 开启数据标签
                },
                enableMouseTracking: false // 关闭鼠标跟踪，对应的提示框、点击事件会失效
            }
        },
        series: [{
            name: '湿度',
            data: []
        }]
    });
});

/**
 * 获取大门的状态
 */
function getDoorStatus() {
    var sucFunc = function (responseData) {
        if (responseData.success) {
            $("#target").text("大门");
            if (responseData.data.msg == "n") {
                alert(1);
                $("#door").bootstrapSwitch("toggleState");
                $("#status").text("已自动关闭");
                $("#tip").show();
                setTimeout(function () {
                    $("#tip").hide();
                }, 2000);
            }
        }
    }
    common_ajax(null, getDoorStatus_uri, "GET", sucFunc, null, null);
}

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
                setTimeout(function () {
                    getDoorStatus();
                    $("#target").text("大门");
                    $("#door").bootstrapSwitch("toggleState");
                    $("#status").text("已自动关闭");
                    $("#tip").show();
                    setTimeout(function () {
                        $("#tip").hide();
                    }, 2000);
                }, 6000);
            } else {
                $("#status").text("已关闭成功");
            }
            $("#tip").show();
            setTimeout(function () {
                $("#tip").hide();
            }, 2000);
        }
    }
    var data = {
        "status" : status
    }
    common_ajax(null, openOrCloseDoor_uri, "POST", sucFunc, data, null);
}

/**
 * 检测烟雾或者液化气
 */
function detect(id, roomOrder, smoke_or_gas) {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            if (id == 1) {
                if (responseData.data.msg == 'y') {
                    $("#smoke_status_room").text("有");
                    $("#smoke_infobox_room").removeClass("infobox-green");
                    $("#smoke_infobox_room").addClass("infobox-red");
                    if(!($("#smoke_icon_room").hasClass("rotate"))) {
                        $("#smoke_icon_room").addClass("rotate");
                    }
                }
                if (responseData.data.msg == 'n') {
                    $("#smoke_status_room").text("无");
                    $("#smoke_infobox_room").removeClass("infobox-red");
                    $("#smoke_infobox_room").addClass("infobox-green");
                    $("#smoke_icon_room").removeClass("rotate");
                }
            }
            if (id == 2) {
                if (responseData.data.msg == 'y') {
                    $("#smoke_status_kitchen").text("有");
                    $("#smoke_infobox_kitchen").removeClass("infobox-green");
                    $("#smoke_infobox_kitchen").addClass("infobox-red");
                    if(!($("#smoke_icon_kitchen").hasClass("rotate"))) {
                        $("#smoke_icon_kitchen").addClass("rotate");
                    }
                }
                if (responseData.data.msg == 'n') {
                    $("#smoke_status_kitchen").text("无");
                    $("#smoke_infobox_kitchen").removeClass("infobox-red");
                    $("#smoke_infobox_kitchen").addClass("infobox-green");
                    $("#smoke_icon_kitchen").removeClass("rotate");
                }
            }
            if (id == 3) {
                if (responseData.data.msg == 'y') {
                    $("#gas_status_kitchen").text("有");
                    $("#gas_infobox_kitchen").removeClass("infobox-green");
                    $("#gas_infobox_kitchen").addClass("infobox-red");
                    if(!($("#gas_icon_kitchen").hasClass("rotate"))) {
                        $("#gas_icon_kitchen").addClass("rotate");
                    }
                }
                if (responseData.data.msg == 'n') {
                    $("#gas_status_kitchen").text("无");
                    $("#gas_infobox_kitchen").removeClass("infobox-red");
                    $("#gas_infobox_kitchen").addClass("infobox-green");
                    $("#gas_icon_kitchen").removeClass("rotate");
                }
            }
        }
    }
    var data = {
        "smoke_or_gas" : smoke_or_gas,
        "roomOrder" : roomOrder
    }
    common_ajax(null, detect_uri, "GET", sucFunc, data, null);
}

/**
 * 获取最新温度信息
 * @param temp_or_hum
 */
function getLastestData(id, roomOrder, temp_or_hum) {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var data = responseData.data;
            if (id == 1) {
                if (temp_or_hum == 1) {
                    $("#temp_value_hall").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#temp_change_value_hall").text("+" + changeData);
                        $("#temp-status_hall").removeClass("icon-arrow-down");
                        $("#temp-status_hall").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#temp_change_value_hall").text(changeData);
                        $("#temp-status_hall").removeClass("icon-arrow-up");
                        $("#temp-status_hall").addClass("icon-arrow-down");
                    } else {
                        $("#temp_change_value_hall").text(changeData);
                        $("#hum-status_hall").removeClass("icon-arrow-up");
                        $("#hum-status_hall").removeClass("icon-arrow-down");
                    }
                }
                if (temp_or_hum == 2) {
                    $("#hum_value_hall").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#hum_change_value_hall").text("+" + changeData);
                        $("#hum-status_hall").removeClass("icon-arrow-down");
                        $("#hum-status_hall").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#hum_change_value_hall").text(changeData);
                        $("#hum-status_hall").removeClass("icon-arrow-up");
                        $("#hum-status_hall").addClass("icon-arrow-down");
                    } else {
                        $("#hum_change_value_hall").text(changeData);
                        $("#hum-status_hall").removeClass("icon-arrow-up");
                        $("#hum-status_hall").removeClass("icon-arrow-down");
                    }
                }
            }
            if (id == 2) {
                if (temp_or_hum == 1) {
                    $("#temp_value_room").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#temp_change_value_room").text("+" + changeData);
                        $("#temp-status_room").removeClass("icon-arrow-down");
                        $("#temp-status_room").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#temp_change_value_room").text(changeData);
                        $("#temp-status_room").removeClass("icon-arrow-up");
                        $("#temp-status_room").addClass("icon-arrow-down");
                    } else {
                        $("#temp_change_value_room").text(changeData);
                        $("#hum-status_room").removeClass("icon-arrow-up");
                        $("#hum-status_room").removeClass("icon-arrow-down");
                    }
                }
                if (temp_or_hum == 2) {
                    $("#hum_value_room").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#hum_change_value_room").text("+" + changeData);
                        $("#hum-status_room").removeClass("icon-arrow-down");
                        $("#hum-status_room").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#hum_change_value_room").text(changeData);
                        $("#hum-status_room").removeClass("icon-arrow-up");
                        $("#hum-status_room").addClass("icon-arrow-down");
                    } else {
                        $("#hum_change_value_room").text(changeData);
                        $("#hum-status_room").removeClass("icon-arrow-up");
                        $("#hum-status_room").removeClass("icon-arrow-down");
                    }
                }
            }
            if (id == 3) {
                if (temp_or_hum == 1) {
                    $("#temp_value_kitchen").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#temp_change_value_kitchen").text("+" + changeData);
                        $("#temp-status_kitchen").removeClass("icon-arrow-down");
                        $("#temp-status_kitchen").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#temp_change_value_kitchen").text(changeData);
                        $("#temp-status_kitchen").removeClass("icon-arrow-up");
                        $("#temp-status_kitchen").addClass("icon-arrow-down");
                    } else {
                        $("#temp_change_value_kitchen").text(changeData);
                        $("#hum-status_kitchen").removeClass("icon-arrow-up");
                        $("#hum-status_kitchen").removeClass("icon-arrow-down");
                    }
                }
                if (temp_or_hum == 2) {
                    $("#hum_value_kitchen").text(data.curData);
                    var changeData = data.changeData;
                    if (changeData > 0) {
                        $("#hum_change_value_kitchen").text("+" + changeData);
                        $("#hum-status_kitchen").removeClass("icon-arrow-down");
                        $("#hum-status_kitchen").addClass("icon-arrow-up");
                    } else if (changeData < 0) {
                        $("#hum_change_value_kitchen").text(changeData);
                        $("#hum-status_kitchen").removeClass("icon-arrow-up");
                        $("#hum-status_kitchen").addClass("icon-arrow-down");
                    } else {
                        $("#hum_change_value_kitchen").text(changeData);
                        $("#hum-status_kitchen").removeClass("icon-arrow-up");
                        $("#hum-status_kitchen").removeClass("icon-arrow-down");
                    }
                }
            }
        }
    }
    var data = {
        "roomOrder" : roomOrder,
        "temp_or_hum" : temp_or_hum
    }
    common_ajax(null, getLastestData_uri, "GET", sucFunc, data, null);
}

/**
 * 获取温度湿度图形数据
 * @param temp_or_hum
 */
function getChart1() {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var series = chart1.series[0];
            for (var i = responseData.data.length - 1; i >= 0; i --) {
                series.addPoint(responseData.data[i], true, false);
            }
        }
    }
    var data = {
        "roomOrder" : $("#chart_roomOrder").val(),
        "temp_or_hum" : 1
    }
    common_ajax(null, getListData_uri, "GET", sucFunc, data, null);
}
/**
 * 获取温度湿度图形数据
 * @param temp_or_hum
 */
function getChart2() {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var series = chart2.series[0];
            for (var i = responseData.data.length - 1; i >= 0; i --) {
                series.addPoint(responseData.data[i], true, false);
            }
        }
    }
    var data = {
        "roomOrder" : $("#chart_roomOrder").val(),
        "temp_or_hum" : 2
    }
    common_ajax(null, getListData_uri, "GET", sucFunc, data, null);
}

function redraw1(){
    var series1=chart1.series;
    while(series1.length > 0) {
        series1[0].remove(false);
    }
    chart1.addSeries({
        name: "温度",
        data: []
    }, false);
    chart1.redraw();
}
function redraw2(){
    var series2=chart2.series;
    while(series2.length > 0) {
        series2[0].remove(false);
    }
    chart2.addSeries({
        name: "湿度",
        data: []
    }, false);
    chart2.redraw();
}