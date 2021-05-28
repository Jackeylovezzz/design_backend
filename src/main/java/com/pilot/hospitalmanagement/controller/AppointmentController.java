package com.pilot.hospitalmanagement.controller;

import com.pilot.hospitalmanagement.Po.Appointment;
import com.pilot.hospitalmanagement.Po.Doctor;
import com.pilot.hospitalmanagement.Po.Room;
import com.pilot.hospitalmanagement.service.AppointService;
import com.pilot.hospitalmanagement.service.impl.AppointServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/appoint")
public class AppointmentController {
    @Autowired
    AppointServiceImpl appointService;

    // 查找所有科室
    @GetMapping("/queryAllDept")
    public Resbody queryAllDept() {
        try {
            List<Room> depts = appointService.getAllDept();
            if (null == depts) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(depts, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @PostMapping("/makeAppointment")
    // 预约生成条码
    public Resbody makeAppointment(@RequestParam Map<String, String> params) {
        try {
            Appointment appointment = new Appointment();
            appointment.setAType(params.get("type"));
            appointment.setPID(params.get("userID"));
            if ("expert".equals(appointment.getAType())) {
                appointment.setDID(params.get("choice"));
            } else {
                appointment.setRID(params.get("choice"));
            }
            String strDateFormat = "yyyy-MM-dd";
            System.out.println(params.get("date"));
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            appointment.setATime((sdf.parse(params.get("date"))));
            int res = appointService.addAppointment(appointment);
            if (res == 0) {
                return ResbodyUtil.error(res, "预约失败");
            } else {
                return ResbodyUtil.success("预约成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @GetMapping("/cancelAppointment/{appointId}")
    public Resbody cancelAppointment(@PathVariable("appointId") String appointId) {
        try {
            int res = appointService.deleteAppointmentById(appointId);
            if (res == 0) {
                return ResbodyUtil.error(res, "删除失败");
            } else {
                return ResbodyUtil.success("删除成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 用户当前所有预约
    @GetMapping("/queryAppointment/{userId}")
    public Resbody queryAppointment(@PathVariable("userId") String userId) {
        try {
            Map<String, String> appoints = appointService.findAppointmentByUserId(userId);
            if (null == appoints) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(appoints, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 科室所有预约信息
    @GetMapping("/queryDeptAppointment/{deptId}/{date}")
    public Resbody queryDeptAppointment(@PathVariable("deptId") String deptId, @PathVariable("date") String date) {
        try {
            List<Appointment> appoints = appointService.findAppointmentByDeptId(deptId, date);
            if (null == appoints) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(appoints, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 获取一个科室所有专家列表
    @GetMapping("/queryAllExpert/{deptId}")
    public Resbody queryAllExpert(@PathVariable("deptId") String deptId) {
        try {
            List<Doctor> doctors = appointService.getAllExpertByDept(deptId);
            if (null == doctors) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(doctors, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 获取某个预约的详细信息
    @GetMapping("/queryTheAppointment/{appointId}")
    public Resbody queryTheAppointment(@PathVariable("appointId") String appointId) {
        try {
            Appointment appointment = appointService.findAppointmentByAppointId(appointId);
            if (null == appointment) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(appointment, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 获取某个专家的预约信息
    @GetMapping("/queryExpert/{doctorId}/{date}")
    public Resbody queryExpert(@PathVariable("doctorId") String doctorId, @PathVariable("date") String date) {
        try {
            List<Appointment> appointment = appointService.findAppointmentByDoctorId(doctorId, date);
            if (null == appointment) {
                return ResbodyUtil.error(0, "查找失败");
            } else {
                return ResbodyUtil.success(appointment, "查找成功");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

    // 修改医师或者科室的时间
    @PostMapping("/changeAppointmentTime")
    public Resbody changeAppointmentTime(@RequestBody Map<String, String> params) {
        try {
            String type = params.get("type");
            String id = params.get("id");
            String appointmentTime = params.get("appointmentTime");
            int cnt = appointService.changeAppointmentTime(id, type, appointmentTime);
            if (cnt == 1) {
                return ResbodyUtil.success("修改成功");
            } else {
                return ResbodyUtil.success("修改失败");
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }
    }

}
