package com.pilot.hospitalmanagement.service;

import com.pilot.hospitalmanagement.Po.Doc;

import java.util.List;

/**
 * @author Paul
 * @date 2021/1/6 22:43
 * @description
 */
public interface DocService {
    Doc addDoc(Doc doc);

    int deleteDoc(String id);

    List<Doc> findAllDoc();

    Doc findDocById(String id);

    int modifyDoc(Doc record);

    List<Doc> findDocByPid(String id);

    int finishDoc(String id);
}
