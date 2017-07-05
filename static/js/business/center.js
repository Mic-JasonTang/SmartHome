/**
 * Created by JasonTang on 6/24/2017.
 */
$(function () {
    var tab,index=0;
    $(function() {
        tab=$(".main_desktop").KandyTabs({
            del:true,
            scroll:true,
            trigger:'click',
            custom:function(b,c,i){
                $("p",c).fadeOut();
                c.eq(i).find("p").slideDown(1500);
                index=i;
            }
        });
    });
    /**
     * 首先获取亲人的GPS设备信息
     * 然后显示定位
     */
    $("#gps_a").click(function () {
        getGPSList(null);
        //parent.addTab('gps.html','GPS定位');
    });
    $("#vedio_a").click(function () {
        getVedioList(null);
        //parent.addTab('heart-rate.html','医疗保障')
    });
    $("#heartrate_a").click(function () {
        getHeartRateList(null);
        //parent.addTab('vedio.html','视频监控')
    });
});
/**
 * 获取GPS人员信息
 */
function getGPSList(data) {
    swal({
        title:
        "<h4 style='padding-bottom: 20px;'>GPS定位</h4>" +
        "<div class='form-group'>" +
            "<select name='userId' id='userId' class='form-control'>" +
                "<option value=''>请选择人员</option>" +
                "<option value='111'>妈妈</option>" +
                "<option  value='112'>爸爸</option> " +
                "<option  value='112'>爸爸</option> " +
                "<option  value='112'>爸爸</option> " +
            "</slect>" +
        "</div>"
        ,
        text:
            "<div class='form-group'>" +
                "<select name='timeId' id='timeId' class='form-control'>" +
                    "<option value=''>请选择时间</option>" +
                    "<option value='2017年6月24日21:13:24'>2017年6月24日21:13:24</option>" +
                    "<option value='2017年6月24日22:13:24'>2017年6月24日22:13:24</option> " +
                    "<option value='2017年6月24日23:13:24'>2017年6月24日23:13:24</option> " +
                "</slect>" +
            "</div>"
        ,
        showCancelButton: true,
        cancelButtonText: "取消",
        closeOnConfirm: false,
        animation: "slide-from-top",
        imageUrl: "images/icon_6.png",
        html: true
    },
    function(isConfirm){
        if (isConfirm) {
            $userId = $("#userId").val();
            $timeId = $("#timeId").val();
            console.log(($userId != null && $userId != '') && ($timeId != null && $timeId != ''));
            if(($userId != null && $userId != '') && ($timeId != null && $timeId != '')) {
                parent.addTab('gps.html','GPS定位');
                swal.close();
            } else {
                swal.showInputError("请选择");
            }
        }
    });
}

/**
 * 获取 心率列表
 */
function getHeartRateList(data) {
    swal({
            title: '请选择人员',
            text: "<div class='form-group'>" +
            "<select name='userId' id='userId' class='form-control'>" +
            "<option value=''>请选择人员</option>" +
            "<option value='112'>妈妈</option>" +
            "<option value='112'>爸爸</option>" +
            "<option value='112'>爷爷</option>" +
            "<option value='112'>奶奶</option>" +
            "</slect>" +
            "</div>"
            ,
            showCancelButton: true,
            cancelButtonText: "取消",
            closeOnConfirm: false,
            animation: "slide-from-top",
            imageUrl: "images/icon_17.png",
            html: true
        },
        function (isConfirm) {
            if (isConfirm) {
                var $userId = $("#userId").val();
                if(($userId != null && $userId != '')) {
                    parent.addTab('heart-rate.html','医疗保障');
                    swal.close();
                } else {
                    swal.showInputError("请选择");
                }
            }
        });
}

/**
 * 获取 视频列表
 */
function getVedioList(data) {
    swal({
            title: '请选择人员',
            text: "<div class='form-group'>" +
            "<select name='num' id='num' class='form-control'>" +
            "<option value=''>请选择房间</option>" +
            "<option value='1'>1号房间</option>" +
            "<option value='2'>2号房间</option> " +
            "<option value='3'>3号房间</option> " +
            "<option value='4'>4号房间</option> " +
            "<option value='5'>5号房间</option> " +
            "</slect>" +
            "</div>"
            ,
            showCancelButton: true,
            cancelButtonText: "取消",
            closeOnConfirm: false,
            imageUrl: "images/icon_22.png",
            html: true
        },
        function (isConfirm) {
            if (isConfirm) {
                var $num = $("#num").val();
                if(($num != null && $num != '')) {
                    parent.addTab('vedio.html','视频监控');
                    swal.close();
                } else {
                    swal.showInputError("请选择");
                }
            }
        });
}