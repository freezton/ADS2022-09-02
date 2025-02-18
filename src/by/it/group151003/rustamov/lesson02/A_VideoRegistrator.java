package by.it.group151003.rustamov.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
        List<Double> result = new ArrayList<>();
        Arrays.sort(events);
        result.add(events[0]);
        double eventClose = events[0] + workDuration;

        for (int i = 1; i < events.length; i++)
            if (events[i] > eventClose) {
                result.add(events[i]);
                eventClose = events[i] + workDuration;
            }

        return result;
    }
}
