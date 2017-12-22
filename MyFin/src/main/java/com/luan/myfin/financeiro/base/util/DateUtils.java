package com.luan.myfin.financeiro.base.util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtils {

    public static Date fistDayOfCurrentMonth() {
        LocalDate fistDayOfMonth = today().withDayOfMonth(1);

        return Date.valueOf(fistDayOfMonth);
    }

    public static Date fistDayOfMonth(Date date) {
        LocalDate fistDayOfMonth = date.toLocalDate().withDayOfMonth(1);

        return Date.valueOf(fistDayOfMonth);
    }

    public static Date lastDayOfMonth(Date date) {
        LocalDate fistDayOfMonth = date.toLocalDate().withDayOfMonth(date.toLocalDate().lengthOfMonth());

        return Date.valueOf(fistDayOfMonth);
    }

    public static Date lastDayOfCurrentMonth() {
        LocalDate lastDayOfMonth = today().withDayOfMonth(today().lengthOfMonth());

        return Date.valueOf(lastDayOfMonth);
    }

    public static LocalDate today() {
        Date date = new Date(System.currentTimeMillis());
        return date.toLocalDate();
    }
}
