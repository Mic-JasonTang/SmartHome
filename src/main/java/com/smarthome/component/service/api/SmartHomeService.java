package com.smarthome.component.service.api;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.SensorDataDTO;
import com.smarthome.mybatis.dto.ServiceResult;

import java.util.List;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 4:47 PM.
 * 智能家居类的服务
 */
public interface SmartHomeService {

    /**
     * 开门或者关门
     * @param status
     * 0 是关门 1 是关门
     * @return
     */
    public ServiceResult<Msg> openOrCloseDoor(int status);

    /**
     * 获取最新的一个数据
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    public ServiceResult<SensorDataDTO> getLastestData(int temp_or_hum);

    /**
     * 获取图形数据列表
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    public ServiceResult<List<SensorDataDTO>> getDataList(int temp_or_hum);

    /**
     * 检测是否有烟雾
     * @return
     */
    public ServiceResult<ResponseMsg> hasSmoke();
}
