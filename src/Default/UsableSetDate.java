package Default;

import java.util.Calendar;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MADANI
 */
public final class UsableSetDate {

    public UsableSetDate(JComboBox dayCBX, JComboBox monthCBX, JComboBox yearCBX, String date) {
        String splitDate[] = date.split("-");
        Calendar cal = Calendar.getInstance();        
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(splitDate[2]));
        cal.set(Calendar.MONTH, Integer.parseInt(splitDate[1]) - 1);
        cal.set(Calendar.YEAR, Integer.parseInt(splitDate[0]));
        int day = -1;
        int month = -1;
        for (int i = 0; i < dayCBX.getItemCount(); i++) {
            day++;
            if ((cal.get(Calendar.DAY_OF_MONTH) + "").equals(dayCBX.getItemAt(i).toString())) {
                break;
            }
        }
        for (int i = 0; i < monthCBX.getItemCount(); i++) {
            month++;
            if (((cal.get(Calendar.MONTH) + 1) + "").equals(StaticAccess.getMonth(monthCBX.getItemAt(i).toString()))) {
                break;
            }
        }
        if (day == -1) {
            day = 0;
        }
        if (month == -1) {
            month = 0;
        }

        dayCBX.setSelectedIndex(day);
        monthCBX.setSelectedIndex(month);
        setYear(yearCBX, cal);
    }

    public UsableSetDate(JComboBox dayCBX, JComboBox monthCBX, JComboBox yearCBX) {
        Calendar cal = Calendar.getInstance();
        int day = -1;
        int month = -1;
        for (int i = 0; i < dayCBX.getItemCount(); i++) {
            day++;
            if ((cal.get(Calendar.DAY_OF_MONTH) + "").equals(dayCBX.getItemAt(i).toString())) {
                break;
            }
        }
        for (int i = 0; i < monthCBX.getItemCount(); i++) {
            month++;
            if (((cal.get(Calendar.MONTH) + 1) + "").equals(StaticAccess.getMonth(monthCBX.getItemAt(i).toString()))) {
                break;
            }
        }
        if (day == -1) {
            day = 0;
        }
        if (month == -1) {
            month = 0;
        }

        dayCBX.setSelectedIndex(day);
        monthCBX.setSelectedIndex(month);
        setYear(yearCBX, cal);
    }

    public void setYear(JComboBox yearCBX, Calendar cal) {

        int year = Integer.parseInt(yearCBX.getItemAt(yearCBX.getItemCount() - 1).toString());
        int currentYear = cal.get(Calendar.YEAR);
        if (year < currentYear) {
            for (int i = year + 1; i <= currentYear; i++) {
                yearCBX.addItem(StaticAccess.makeObj(i + ""));
            }
        }
        year = 0;
        for (int i = 1; i < yearCBX.getItemCount(); i++) {
            year++;
            if ((currentYear + "").equals(yearCBX.getItemAt(i).toString())) {
                break;
            }
        }
        yearCBX.setSelectedIndex(year);
    }

}
