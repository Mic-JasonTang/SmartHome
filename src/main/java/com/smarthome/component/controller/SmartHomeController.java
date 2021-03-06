package com.smarthome.component.controller;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.component.service.api.SmartHomeService;
import com.smarthome.mybatis.dto.ChartData;
import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.SensorDataDTO;
import com.smarthome.mybatis.dto.ServiceResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 7/1/2017 10:00 PM.
 */
@RequestMapping("/smarthome")
@RestController
public class SmartHomeController {

    @Autowired
    private SmartHomeService smartHomeService;

    /**
     * 开门或者关门
     * @param status
     * 0 是关门 1 是关门
     * @return
     */
    @ApiOperation("开门/关门")
    @ApiImplicitParam(name = "status", value = "状态:0表示关,1表示开", required = true, dataType = "int")
    @RequestMapping(value = "/openOrClose", method = RequestMethod.POST)
    public ServiceResult<Msg> openOrCloseDoor(int status) {

        return smartHomeService.openOrCloseDoor(status);
    }

    /**
     * 获取门的状态
     * @return
     */
    @ApiOperation("获取门的状态")
    @RequestMapping(value = "/getStatus", method = RequestMethod.GET)
    public ServiceResult<ResponseMsg> openOrCloseDoor() {

        return smartHomeService.getDoorStatus();
    }
    /**
     * 获取最新的一个数据
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    @ApiOperation("获取最新温度湿度数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "temp_or_hum", value = "1表示温度,2表示湿度", required = true, dataType = "int"),
            @ApiImplicitParam(name = "roomOrder", value = "房间编号", required = true, dataType = "int")
        }
    )
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ServiceResult<SensorDataDTO> getLastestData(int temp_or_hum, int roomOrder) {

        return smartHomeService.getLastestData(temp_or_hum, roomOrder);
    }

    /**
     * 获取图形数据列表
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    @ApiOperation("获取最新温度湿度图表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "temp_or_hum", value = "1表示温度,2表示湿度", required = true, dataType = "int"),
            @ApiImplicitParam(name = "roomOrder", value = "房间编号", required = true, dataType = "int")
        }
    )
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServiceResult<List<ChartData>> getDataList(int temp_or_hum, int roomOrder) {

        return smartHomeService.getDataList(temp_or_hum, roomOrder);
    }

    /**
     * 检测是否有烟雾或者液化气
     * @return
     */
    @ApiOperation("检测是否有烟雾或者液化气")
    @RequestMapping(value = "/detect", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smoke_or_gas", value = "1表示烟雾,2表示液化气", required = true, dataType = "int"),
            @ApiImplicitParam(name = "roomOrder", value = "房间编号", required = true, dataType = "int")
        }
    )
    public ServiceResult<ResponseMsg> hasSmoke(int smoke_or_gas, int roomOrder) {

        return smartHomeService.hasSmokeOrGas(smoke_or_gas, roomOrder);
    }
}
