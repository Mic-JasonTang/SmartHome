/**
 * Created by JasonTang on 6/18/2017.
 */
$(function () {
   var url = "http://api.map.baidu.com/geocoder";
   var data = {
       location: "34.239838,108.968186",
       coord_type: "gcj02",
       output: "html",
       src: "地图调用API"
   };
   $.form(url, data, 'get').submit();
});