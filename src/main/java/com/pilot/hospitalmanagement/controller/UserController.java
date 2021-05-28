package com.pilot.hospitalmanagement.controller;

import com.pilot.hospitalmanagement.Po.Doc;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.Po.User;
import com.pilot.hospitalmanagement.service.UserService;
import com.pilot.hospitalmanagement.service.impl.DoctorServiceImpl;
import com.pilot.hospitalmanagement.service.impl.PatientServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Paul
 * @date 2021/1/5 8:56
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name = "doctor")
    UserService doctorService;
    @Resource(name = "administrator")
    UserService adminService;
    @Resource(name = "cashier")
    UserService cashierService;
    @Resource(name = "pharmacist")
    UserService pharmacistService;

    //参数包括 id 密码 以及type()
    @PostMapping("/login")
    public Resbody login(@RequestParam Map<String,Object> params, HttpServletRequest request){
        String type  = (String) params.get("type");
        String userId = (String) params.get("userID");
        String userCode = (String) params.get("userCode");
        System.out.println(userCode);
        System.out.println(userId);
        System.out.println(type);
        if ("administrator".equals(type)) {
            return loginUtil(adminService,userId,userCode,request);
        }else if("doctor".equals(type)){
            return loginUtil(doctorService,userId,userCode,request);
        }else if("cashier".equals(type)){
            return loginUtil(cashierService,userId,userCode,request);
        }else if("pharmacist".equals(type)){
            return loginUtil(pharmacistService,userId,userCode,request);
        }
        return null;


    }
    private Resbody loginUtil(UserService service, String userId,String userCode,HttpServletRequest request){
        try{
            User res = service.findUserById(userId);
            if(null == res) {
                return ResbodyUtil.error(0,"查无此人");
            }else{
                if(userCode.equals(res.getUserCode())){

                    request.getSession().setAttribute("user",res.getUserName());
                    return ResbodyUtil.success(res,"登录成功");

                }else{
                    return  ResbodyUtil.error(0,"密码错误");
                }
            }
        }catch (Exception e){
            return  ResbodyUtil.error(0,e.toString());
        }

    }




}
