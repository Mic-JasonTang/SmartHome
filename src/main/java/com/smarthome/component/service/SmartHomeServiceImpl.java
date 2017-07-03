package com.smarthome.component.service;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.common.util.SmartHomeUtil;
import com.smarthome.common.util.TimeUtil;
import com.smarthome.component.service.api.SmartHomeService;
import com.smarthome.component.service.api.UserService;
import com.smarthome.config.SensorConfig;
import com.smarthome.mybatis.dto.*;
import com.smarthome.mybatis.mapper.*;
import com.smarthome.mybatis.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 5:04 PM.
 * 控制、获取 传感器数据
 */
@Service("smartHomeService")
public class SmartHomeServiceImpl implements SmartHomeService{

    private static final int LENGTH = 20;
    @Autowired
    private SensorConfig sensorConfig;

    @Autowired
    private SensorDataMapper sensorDataMapper;

    //1. 查询用户Id
    @Autowired
    private UserService userService;

    //2. 根据用户Id查询公寓Id
    @Autowired
    private ApartmentUserMapper apartmentUserMapper;

    //3. 根据公寓Id查询 楼宇-公寓Id
    @Autowired
    private BuildingApartmentMapper buildingApartmentMapper;

    //4. 根据楼宇-公寓Id 查询 楼宇-公寓-房间Id
    @Autowired
    private BuildingApartmentRoomMapper buildingApartmentRoomMapper;

    //5. 根据楼宇-公寓-房间Id 查询 房间 Order(编号)
    @Autowired
    private RoomMapper roomMapper;

    /**
     * 获取开门关门的信息
     * @param status
     * 0 是关门 1 是关门
     * @return
     */
    @Override
    public ServiceResult<Msg> openOrCloseDoor(int status) {
        ServiceResult<Msg> serviceResult = new ServiceResult<>();
        ServiceResult<UserDTO> userDTOServiceResult = userService.getLoginedUser();
        // 如果请求没有成功,表示没有登录
        if (!userDTOServiceResult.getSuccess()) {
            serviceResult.setMsg(userDTOServiceResult.getMsg());
            return serviceResult;
        }
        if (status != 1 && status != 0) {
            serviceResult.setMsg("参数错误");
            return serviceResult;
        }
        // 获取用户id
        int userId = userDTOServiceResult.getData().getUserId();
        ApartmentUser apartmentUser = apartmentUserMapper.selectByUserId(userId);
        if (apartmentUser == null) {
            serviceResult.setMsg("该用户还未购买房子");
            return serviceResult;
        }
        // 获取公寓Id
        int apartmentId = apartmentUser.getApartmentId();
        // 获取 楼宇-公寓Id
        BuildingApartment buildingApartment = buildingApartmentMapper.selectByAparamentId(apartmentId);
        if (buildingApartment == null) {
            serviceResult.setMsg("该用户还未购买房子");
            return serviceResult;
        }
        int baId = buildingApartment.getBaId();
        /**
         ==>  Preparing: select barId, baId, roomId from building_apartment_room where baId = ?
         ==> Parameters: 1(Integer)
         <==    Columns: barId, baId, roomId
         <==        Row: 1, 1, 1000
         <==        Row: 2, 1, 1001
         <==        Row: 3, 1, 1002
         <==        Row: 4, 1, 1003
         <==      Total: 4
         */
        // 获取 房间Id
        List<BuildingApartmentRoom> buildingApartmentRoomList = buildingApartmentRoomMapper.selectByBuildingApartmentId(baId);
        if (buildingApartmentRoomList.size() == 0) {
            serviceResult.setMsg("该用户还未购买房子");
            return serviceResult;
        }
        for (BuildingApartmentRoom bar : buildingApartmentRoomList) {
            int roomId = bar.getRoomId();
            // 获取 房间编号
            Room room = roomMapper.selectByPrimaryKey(roomId);
            if (room == null) {
                serviceResult.setMsg("该用户还未购买房子");
                return serviceResult;
            }
            int roomOrder = room.getRoomOrder();
            if (SmartHomeUtil.isDoor(roomOrder+"")) {
                SensorData sensorData = new SensorData();
                sensorData.setSensorId(sensorConfig.getDoorId());
                sensorData.setRoomOrder(roomOrder);
                sensorData.setSensorValue(status + "");
                sensorDataMapper.insert(sensorData);
                if (status == 1) {
                    serviceResult.setMsg("开门成功");
                } else {
                    serviceResult.setMsg("关门成功");
                }
                serviceResult.setSuccess(true);
                serviceResult.setData(Msg.OK);
                return serviceResult;
            }
        }
        serviceResult.setMsg("该用户房间还没有安装智能门锁");
        return serviceResult;
    }

    /**
     *
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    @Override
    public ServiceResult<SensorDataDTO> getLastestData(int temp_or_hum) {
        ServiceResult<SensorDataDTO> serviceResult = new ServiceResult<>();
        ServiceResult<UserDTO> userDTOServiceResult = userService.getLoginedUser();
        // 如果请求没有成功,表示没有登录
        if (!userDTOServiceResult.getSuccess()) {
            serviceResult.setMsg(userDTOServiceResult.getMsg());
            return serviceResult;
        }
        if (temp_or_hum != 1 && temp_or_hum != 2) {
            serviceResult.setMsg("参数错误");
            return serviceResult;
        }
        int sensorId;
        //温度
        if (temp_or_hum == 1) {
            sensorId = sensorConfig.getTemperatureId();
        } else {
        // 湿度
            sensorId = sensorConfig.getHumidityId();
        }
        List<SensorData> sensorDataList = sensorDataMapper.selectListBySensorId(sensorId, LENGTH);
        if (sensorDataList.size() == 0) {
            serviceResult.setMsg("没有找到记录");
            return serviceResult;
        }
        SensorData sensorData1 = sensorDataList.get(0);
        SensorData sensorData2 = null;
        SensorDataDTO sensorDataDTO = null;
        if (sensorDataList.size() > 1) {
            sensorData2 = sensorDataList.get(1);
        }
        sensorDataDTO = new SensorDataDTO(Integer.parseInt(sensorData1.getSensorValue()),
                sensorData2 == null ? null : (Integer.parseInt(sensorData1.getSensorValue()) - Integer.parseInt(sensorData2.getSensorValue())),
                TimeUtil.formatTime(sensorData1.getLogtime()));
        serviceResult.setData(sensorDataDTO);
        serviceResult.setSuccess(true);
        return serviceResult;
    }

    /**
     *
     * @param temp_or_hum 温度或者湿度
     *                    1 表示温度  2 表示 湿度
     * @return
     */
    @Override
    public ServiceResult<List<ChartData>> getDataList(int temp_or_hum) {
        ServiceResult<List<ChartData>> serviceResult = new ServiceResult<>();
        ServiceResult<UserDTO> userDTOServiceResult = userService.getLoginedUser();
        // 如果请求没有成功,表示没有登录
        if (!userDTOServiceResult.getSuccess()) {
            serviceResult.setMsg(userDTOServiceResult.getMsg());
            return serviceResult;
        }
        if (temp_or_hum != 1 && temp_or_hum != 2) {
            serviceResult.setMsg("参数错误");
            return serviceResult;
        }
        int sensorId;
        //温度
        if (temp_or_hum == 1) {
            sensorId = sensorConfig.getTemperatureId();
        } else {
        // 湿度
            sensorId = sensorConfig.getHumidityId();
        }
        List<SensorData> sensorDataList = sensorDataMapper.selectListBySensorId(sensorId, LENGTH);
        if (sensorDataList.size() == 0) {
            serviceResult.setMsg("没有找到记录");
            return serviceResult;
        }
        List<ChartData> chartDataList = new ArrayList<>(20);
        for (SensorData sensorData : sensorDataList) {
            ChartData chartData = new ChartData(TimeUtil.formatTime(sensorData.getLogtime()), Integer.parseInt(sensorData.getSensorValue()));
            chartDataList.add(chartData);
        }
        serviceResult.setData(chartDataList);
        serviceResult.setSuccess(true);
        return serviceResult;
    }

    @Override
    public ServiceResult<ResponseMsg> hasSmoke() {
        ServiceResult<ResponseMsg> serviceResult = new ServiceResult<>();
        ServiceResult<UserDTO> userDTOServiceResult = userService.getLoginedUser();
        // 如果请求没有成功,表示没有登录
        if (!userDTOServiceResult.getSuccess()) {
            serviceResult.setMsg(userDTOServiceResult.getMsg());
            return serviceResult;
        }
        int sensorId = sensorConfig.getSmokeId();
        List<SensorData> sensorData = sensorDataMapper.selectListBySensorId(sensorId, 1);
        if (sensorData.size() == 0) {
            serviceResult.setMsg("没有数据");
            return serviceResult;
        }
        if (sensorData.get(0).getSensorValue().equals("0")) {
            serviceResult.setData(new ResponseMsg(Msg.NO));
        } else {
            serviceResult.setData(new ResponseMsg(Msg.YES));
        }
        serviceResult.setSuccess(true);
        return serviceResult;
    }
}
