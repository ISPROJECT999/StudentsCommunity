/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import models.Training;
import queries.TrainingQR;

/**
 *
 * @author Yosef
 */
public class TrainingBean implements java.io.Serializable {

    List<Training> training;
    double eval;

    /**
     * Creates a new instance of TrainingBean
     */
    public TrainingBean() {
    }

    /**
     * Creates a new instance of AnnouncementsBean
     */
    @PostConstruct
    public void init() {
        training = TrainingQR.getAll();
        eval=2.5;

    }

    public List<Training> getTraining() {
        return training;
    }

    public void setTraining(List<Training> training) {
        this.training = training;
    }

    public double getEval() {
        return eval;
    }

    public void setEval(double eval) {
        this.eval = eval;
    }

    
    
}
