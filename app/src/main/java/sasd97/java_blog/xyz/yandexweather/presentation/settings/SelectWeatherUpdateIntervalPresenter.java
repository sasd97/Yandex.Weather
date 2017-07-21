package sasd97.java_blog.xyz.yandexweather.presentation.settings;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import sasd97.java_blog.xyz.yandexweather.background.UpdateWeatherJob;
import sasd97.java_blog.xyz.yandexweather.di.scopes.MainScope;
import sasd97.java_blog.xyz.yandexweather.domain.settings.SelectWeatherUpdateIntervalInteractor;

/**
 * Created by alexander on 16/07/2017.
 */

@MainScope
@InjectViewState
public class SelectWeatherUpdateIntervalPresenter extends MvpPresenter<SelectWeatherUpdateIntervalView> {

    private SelectWeatherUpdateIntervalInteractor interactor;

    @Inject
    public SelectWeatherUpdateIntervalPresenter(@NonNull SelectWeatherUpdateIntervalInteractor interactor) {
        this.interactor = interactor;
    }

    public int getCurrentIntervalValue() {
        return interactor.getUpdateInterval();
    }

    public void saveCurrentIntervalValue(int minutes) {
        interactor.saveUpdateInterval(minutes);
        UpdateWeatherJob.scheduleJob(getCurrentIntervalValue());
    }
}
