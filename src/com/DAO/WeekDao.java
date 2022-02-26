/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.pojos.Batch;
import com.pojos.Week;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface WeekDao {
    public List<Week> getAllWeeks();
    public Integer getWeekIdByWeek(String week);
    public Week getWeekById(Integer week_id);
    public Integer addWeek( Week week);
    public void updateWeek(Week week);
    public void deleteWeek(Integer week_id);
    
}
