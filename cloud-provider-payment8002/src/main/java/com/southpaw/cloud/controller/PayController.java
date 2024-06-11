package com.southpaw.cloud.controller;

import com.southpaw.cloud.beans.dto.PayDTO;
import com.southpaw.cloud.beans.entities.Pay;
import com.southpaw.cloud.beans.response.ResultData;
import com.southpaw.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PayController {
    @Resource
    PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        System.out.println("开始调用真实按照ID查流水服务8002");
        if (id == -4) {
            throw new RuntimeException("id不能为负数");
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${southpaw.info}") String southpawInfo) {
        return "southpawInfo: " + southpawInfo + "\t" + "port: " + port;
    }

}