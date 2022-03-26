package service;

import model.Daily;
import model.ObjectJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Service {

    /**
     * Определяет день с минимальной разницей между ощущаемой и фактической температурой ночью.
     *
     * @param objectJson - объект Java
     * @return строка с данными для печати в консоль
     */
    public static String giveDayMinDifferentTemp (ObjectJson objectJson) {
        List<Daily> listDataWeather = objectJson.getDaily();
        double different = Double.MAX_VALUE;
        Long dateUnix = 0L;
        for (Daily modelList : listDataWeather) {
            Double tempNight = modelList.getTemp().getNight();
            Double feelsLikeNight = modelList.getFeelsLike().getNight();
            double dif = feelsLikeNight - tempNight;
            if (dif < different) {
                different = dif;
                dateUnix = modelList.getDt();
            }
        }
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        return "Минимальная разница " + different + " \"ощущаемой\" и фактической температуры ночью будет "
                + formater.format(new Date(dateUnix * 1000)) + ".";
    }

    /**
     * Определяет максимальную продолжительность светового дня за ближайшие 5 дней.
     *
     * @param objectJson - объект Java
     * @return строка с данными для печати в консоль
     */
    public static String giveMaxDayLengthFiveDay (ObjectJson objectJson) {
        List<Daily> listDataWeather = objectJson.getDaily();
        int dayLength = 0;
        Long dateUnix = 0L;
        for (int i = 0; i < 5; i++) {
            Daily daily = listDataWeather.get(i);
            Integer sunrise = daily.getSunrise();
            Integer sunset = daily.getSunset();
            int len = sunset - sunrise;
            if (len > dayLength) {
                dayLength = len;
                dateUnix = daily.getDt();
            }
        }
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        return "Максимальная продолжительность светового дня " + dayLength + " секунд будет "
                + formater.format(new Date(dateUnix * 1000)) + ".";
    }
}