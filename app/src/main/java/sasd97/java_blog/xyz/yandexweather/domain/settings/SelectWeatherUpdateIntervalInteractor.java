package sasd97.java_blog.xyz.yandexweather.domain.settings;

/**
 * Created by alexander on 16/07/2017.
 */

public interface SelectWeatherUpdateIntervalInteractor {
    void saveUpdateInterval(int minutes);
    int getUpdateInterval();
}