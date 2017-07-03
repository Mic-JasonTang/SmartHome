package com.smarthome.component.service;

import com.smarthome.common.msgenum.Msg;
import com.smarthome.component.service.api.SmartHomeService;
import com.smarthome.component.service.api.UserService;
import com.smarthome.mybatis.dto.ChartData;
import com.smarthome.mybatis.dto.ResponseMsg;
import com.smarthome.mybatis.dto.SensorDataDTO;
import com.smarthome.mybatis.dto.ServiceResult;
import com.smarthome.mybatis.qo.UserQo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * smarthome
 * <p>
 * Created by JasonTang on 6/27/2017 9:49 PM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SmartHomeServiceImplTest {

    @Autowired
    private SmartHomeService smartHomeService;

    @Autowired
    private UserService userService;

    @Before
    public void init() {
        ServiceResult<ResponseMsg> serviceResult = userService.login(new UserQo("admin@smarthome.com", "admin"));
        System.out.println(serviceResult.getData());
    }

    @Test
    public void openOrCloseDoor() throws Exception {
        ServiceResult<Msg> serviceResult = smartHomeService.openOrCloseDoor(3);
        System.out.println(serviceResult);
    }

    @Test
    public void getLastestData() throws Exception {
        ServiceResult<SensorDataDTO> serviceResult = smartHomeService.getLastestData(2);
        System.out.println(serviceResult);
    }

    @Test
    public void getDataList() throws Exception {

        ServiceResult<List<ChartData>> serviceResult = smartHomeService.getDataList(2);
        System.out.println(serviceResult);
    }

    @Test
    public void hasSmoke() throws Exception {
        ServiceResult<ResponseMsg> serviceResult = smartHomeService.hasSmoke();
        System.out.println(serviceResult);
    }

}