/**
 * Created by JasonTang on 7/1/2017.
 */
var chart1 = null; // 定义全局变量
var chart2 = null; // 定义全局变量
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

    detect();
    getLastestData(1);
    getLastestData(2);

    // 烟雾探测 2s
    setInterval(function () {
        detect();
    }, 2000);

    // 温度湿度实时数据，5s
    setInterval(function () {
        getLastestData(1);
        getLastestData(2);
    }, 5000);

    // 温度湿度 图形数据10s
    setInterval(function () {
        redraw1();
        getChart1(1);
    },10000);
    setInterval(function () {
        redraw2();
        getChart2(2);
    },13000);
    //图形数据
    chart1 = new Highcharts.Chart({
        chart: {
            renderTo: 'container1',
            type: 'line',
            events: {
                load: getChart1(1) // 图表加载完毕后执行的回调函数
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
                load: getChart2(2) // 图表加载完毕后执行的回调函数
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
        }
    }
    var data = {
        "status" : status
    }
    common_ajax(null, openOrCloseDoor_uri, "POST", sucFunc, data, null);
}

/**
 * 检测烟雾
 */
function detect() {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            if (responseData.data.msg == 'y') {
                $("#smoke_status").text("有");
                $("#smoke_infobox").removeClass("infobox-green");
                $("#smoke_infobox").addClass("infobox-red");
                if(!($("#smoke_icon").hasClass("rotate"))) {
                    $("#smoke_icon").addClass("rotate");
                }
            }
            if (responseData.data.msg == 'n') {
                $("#smoke_status").text("无");
                $("#smoke_infobox").removeClass("infobox-red");
                $("#smoke_infobox").addClass("infobox-green");
                $("#smoke_icon").removeClass("rotate");
            }
        }
    }

    common_ajax(null, detect_uri, "GET", sucFunc, null, null);
}

function getLastestData(temp_or_hum) {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var data = responseData.data;
            if (temp_or_hum == 1) {
                $("#temp_value").text(data.curData);
                var changeData = data.changeData;
                if (changeData > 0) {
                    $("#temp_change_value").text("+" + changeData);
                    $("#temp-status").removeClass("icon-arrow-down");
                    $("#temp-status").addClass("icon-arrow-up");
                } else if (changeData < 0) {
                    $("#temp_change_value").text(changeData);
                    $("#temp-status").removeClass("icon-arrow-up");
                    $("#temp-status").addClass("icon-arrow-down");
                } else {
                    $("#temp_change_value").text(changeData);
                    $("#hum-status").removeClass("icon-arrow-up");
                    $("#hum-status").removeClass("icon-arrow-down");
                }
            }
            if (temp_or_hum == 2) {
                $("#hum_value").text(data.curData);
                var changeData = data.changeData;
                if (changeData > 0) {
                    $("#hum_change_value").text("+" + changeData);
                    $("#hum-status").removeClass("icon-arrow-down");
                    $("#hum-status").addClass("icon-arrow-up");
                } else if (changeData < 0) {
                    $("#hum_change_value").text(changeData);
                    $("#hum-status").removeClass("icon-arrow-up");
                    $("#hum-status").addClass("icon-arrow-down");
                } else {
                    $("#hum_change_value").text(changeData);
                    $("#hum-status").removeClass("icon-arrow-up");
                    $("#hum-status").removeClass("icon-arrow-down");
                }
            }
        }
    }
    var data = {
        "temp_or_hum" : temp_or_hum
    }
    common_ajax(null, getLastestData_uri, "GET", sucFunc, data, null);
}

/**
 * 获取温度湿度图形数据
 * @param temp_or_hum
 */
function getChart1(temp_or_hum) {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var series = chart1.series[0];
            for (var i = responseData.data.length - 1; i >= 0; i --) {
                series.addPoint(responseData.data[i], true, false);
            }
        }
    }
    var data = {
        "temp_or_hum" : temp_or_hum
    }
    common_ajax(null, getListData_uri, "GET", sucFunc, data, null);
}
/**
 * 获取温度湿度图形数据
 * @param temp_or_hum
 */
function getChart2(temp_or_hum) {

    var sucFunc = function (responseData) {
        if (responseData.success) {
            var series = chart2.series[0];
            for (var i = responseData.data.length - 1; i >= 0; i --) {
                series.addPoint(responseData.data[i], true, false);
            }
        }
    }
    var data = {
        "temp_or_hum" : temp_or_hum
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