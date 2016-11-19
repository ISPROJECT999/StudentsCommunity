/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.Authorization;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Training;
import models.Students;
import queries.TrainingQR;
import queries.StudentsQR;

/**
 *
 * @author Mohammed
 */
public class PanelTrainingBean {

    List<Training> training;
    Training selected;
    int studentid;
    private int trainId;
    private String title;
    private String desc;
    private String place;
    private Date trainDate;
    private int evaluate;

    /**
     * Creates a new instance of PanelTrainingBean
     */
    public PanelTrainingBean() {
    }

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        Authorization auth = (Authorization) request.getSession().getAttribute("auth");
        int type = auth.getUserOB().getUserType();

        if (type == 1) {
            Students s = StudentsQR.getById(auth.getUserOB().getUserId());

            studentid = s.getStudentId();

            training = TrainingQR.getByStudentId(s.getStudentId());
        }
    }

    public void delete(int id, int sid) {
        TrainingQR.delete(TrainingQR.getById(id));
        training = TrainingQR.getByStudentId(sid);
    }
    public List<String> complete(String q){
        System.out.println("###############################################333");
            List<Training> l=TrainingQR.getByPlace(q);
            List<String> list=new ArrayList<String>();
            for(int i=0;i<l.size();i++){
            
                list.add(l.get(i).getTrainPlace());
            
            }
            
            return list;
    }

    public void onLoad(String id) {
        if (id != null) {
            if (!id.equals("")) {
                trainId = Integer.parseInt(id);
                Training obj = TrainingQR.getById(trainId);
                title = obj.getTrainTitle();
                desc = obj.getTrainDesc();
                evaluate = obj.getEvaluation();
                place = obj.getTrainPlace();
                trainDate = obj.getTrainDate();
            }
        }

    }

    public void save() {

        Training obj;
        if (trainId != 0) {

            obj = TrainingQR.getById(trainId);

        } else {

            obj = new Training();

            Students s = StudentsQR.getById(studentid);

            obj.setStudents(s);

        }

        obj.setEvaluation(evaluate);
        obj.setTrainDate(trainDate);
        obj.setTrainDesc(desc);
        obj.setTrainPlace(place);
        obj.setTrainTitle(title);

        TrainingQR.flush(obj);

    }

    public List<Training> getAnnounc() {
        return training;
    }

    public void setAnnounc(List<Training> training) {
        this.training = training;
    }

    public Training getSelected() {
        return selected;
    }

    public void setSelected(Training selected) {
        this.selected = selected;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getAnnId() {
        return trainId;
    }

    public void setAnnId(int trainId) {
        this.trainId = trainId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Training> getTraining() {
        return training;
    }

    public void setTraining(List<Training> training) {
        this.training = training;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }
    
    
    

}
