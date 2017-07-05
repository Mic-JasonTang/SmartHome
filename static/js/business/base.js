/**
 * Created by JasonTang on 6/23/2017.
 */

/**
 * 获取URL
 * @type {string}
 */
var url = document.URL;
var domain = url.match(/http[s]?:\/\/(.*?)([:\/]|$)/);
/**
 * 获取域名
 */
var BASE_URL = domain[0] + "10240/smarthome";
/**
 * 超时时间设置为20s
 * @type {number}
 */
var TIMEOUT = 20000;

var login_uri = "/user/login";
var reg_uri = "/user/signup";
var check_tel_email_uri = "/user/check/";
var get_logined_user_uri = "/user"
var logout_uri = "/user";
var get_user_uri = "/user/get/";
var update_uri = "/user"

var openOrCloseDoor_uri = "/smarthome/openOrClose";
var detect_uri = "/smarthome/detect";
var getLastestData_uri = "/smarthome/get";
var getListData_uri = "/smarthome/list";
/**
 * 通用的Ajax
 * @param form 表单对象
 * @param uri 请求的uri
 * @param method 请求的方式
 * @param successFunc 毁掉函数
 * @param data 请求数据
 * @param ansy 是否异步
 */
function common_ajax(form, uri, method, successFunc, data, ansy) {
    var formdata;
    if (data == null && form != null) {
        formdata = form.serialize();
    } else {
        formdata = data;
    }
    if(ansy == null || ansy == undefined) {
        ansy = true;
    }
    // 打印请求地址
    console.log(BASE_URL+uri);

    $.ajax({
        type: method,
        url: BASE_URL + uri,
        timeout: TIMEOUT,
        data: formdata,
        ansy: ansy,
        xhrFields:{withCredentials:true}, //携带cookie,解决跨域问题
        success:successFunc,
        error:function(){
            swal({
                title: "Sorry!",
                text: "服务器繁忙, 请稍后再试",
                timer: 2000,
                type: "error"
            });
        }
    });
}
/**
 * 将timestamp转为 day
 * @param time
 * @returns {string}
 */
function timeStamp2String (time){
    if (time == null) {
        return "";
    }
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1;
    month = month < 10 ? "0" + month : month;
    var day = datetime.getDate();
    day = day < 10 ? "0" + day : day;
    return year + "-" + month + "-" + day;
};
/**
 * 将String的日期转为timestamp
 * @param strdate
 * @returns {*}
 * @constructor
 */
function String2TimeStamp(strdate) {
    if (strdate == null) {
        return "";
    }
    var d = new Date(strdate);
    var timestamp=Math.round(d.getTime());
    return timestamp;
}
/**
 * cookie操作
 * @type {{set: cookie.set, setms: cookie.setms, get: cookie.get, delete: cookie.delete}}
 */
var cookie = {
    set:function(key,val,time){//设置cookie方法
        var date=new Date(); //获取当前时间
        var expiresDays=time*24*3600*1000;  //将date设置为n天以后的时间
        date.setTime(date.getTime()+expiresDays); //格式化为cookie识别的时间
        document.cookie=key + "=" + val +";expires="+date.toGMTString();  //设置cookie
    },
    setms:function(key,val,time){//设置cookie方法
        var date=new Date(); //获取当前时间
        var expiresDays=time;  //将date设置为ms
        date.setTime(date.getTime()+expiresDays); //格式化为cookie识别的时间
        document.cookie=key + "=" + val +";expires="+date.toGMTString();  //设置cookie
    },
    get:function(key) {//获取cookie方法
        /*获取cookie参数*/
        var getCookie = document.cookie.replace(/[ ]/g, "");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arrCookie = getCookie.split(";");  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        for (var i = 0; i < arrCookie.length; i++) {   //使用for循环查找cookie中的tips变量
            var arr = arrCookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            var result;
            if (key == arr[0]) {  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                result = arr[1];   //将cookie的值赋给变量tips
                break;   //终止for循环遍历
            }
        }
        return result;
    },
    delete:function(key){ //删除cookie方法
        var date = new Date(); //获取当前时间
        date.setTime(date.getTime()-10000); //将date设置为过去的时间
        document.cookie = key + "=v; expires =" +date.toGMTString();//设置cookie
    }
};