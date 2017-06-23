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
var BASE_URL = domain[0] + "10240/smarthome/";
/**
 * 超时时间设置为10s
 * @type {number}
 */
var TIMEOUT = 10000;

var login_uri = "/user/login";
var reg_uri = "/user";
var check_tel_email_uri = "/user/check";
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