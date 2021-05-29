package com.pilot.hospitalmanagement.controller;

import com.pilot.hospitalmanagement.Po.Patient;
import com.pilot.hospitalmanagement.service.PatientService;
import com.pilot.hospitalmanagement.service.impl.PatientServiceImpl;
import com.pilot.hospitalmanagement.utils.Resbody;
import com.pilot.hospitalmanagement.utils.ResbodyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author Paul
 */
@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/login")
    public Resbody login(Patient patient, HttpServletRequest request) {
        try {
            Patient u = patientService.loadPatientById(patient.getUserID());
            if (null == u) {
                return ResbodyUtil.error(2, "查无此人");
            } else {
                if (u.getUserCode().equals(patient.getUserCode())) {

                    request.getSession().setAttribute("user", u.getUserName());
                    return ResbodyUtil.success(u, "登录成功");

                } else {
                    return ResbodyUtil.error(0, "密码错误");
                }
            }
        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());

        }

    }

    @PostMapping("/register")
    public Resbody register(Patient patient) {
        try {
            System.out.println(patient.toString());
            int resCode = patientService.register(patient);
            System.out.println(resCode);
            if (resCode == 1) {
                return ResbodyUtil.success("注册成功");
            } else if (resCode == 2) {
                return ResbodyUtil.error(2, "用户已注册");
            } else {
                return ResbodyUtil.error(0, "注册失败");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    @GetMapping("/logout")
    public Resbody logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return ResbodyUtil.success("退出登录");
    }

    @PostMapping("/modify")
    public Resbody modify(Patient patient) {
        try {
            int res = patientService.modify(patient);
            if (res == 1) {
                return ResbodyUtil.success("修改成功");
            } else {
                return ResbodyUtil.error(0, "修改失敗");
            }

        } catch (Exception e) {
            return ResbodyUtil.error(0, e.toString());
        }

    }

    // 上传文件
    @PostMapping("/uploadwork")
    public String uploadWork(HttpServletRequest request,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            // String path = null;
            String type = fileName.indexOf(".") != -1
                    ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
                    : null;
            if (type != null) {
                if ("DOCX".equals(type.toUpperCase()) || "DOC".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = user + "_" + fileName;

                    // 设置存放图片文件的路径
                    String fullpath = "D:\\大学课程\\毕业设计\\20174303黄伟业毕业设计\\AcademicManagement\\HospitalManagement-master\\resources";
                    fullpath += trueFileName;
                    File dest = new File(fullpath);
                    // 判断文件父目录是否存在
                    if (!dest.getParentFile().exists()) {
                        dest.getParentFile().mkdir();
                    }

                    file.transferTo(dest);

                    return trueFileName;
                } else {
                    return "error";
                }
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
}
