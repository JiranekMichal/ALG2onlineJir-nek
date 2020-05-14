/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Michal Jiránek
 */
class RunnerFinish {
    private int number;
    private LocalTime finishTime;
    public static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public RunnerFinish(int number) {
        this.number = number;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }

    public int getNumber() {
        return number;
    }

    public String getFinishTimeString() {
        return finishTime.format(dtffinish);
    }
    
    
    
    
}
