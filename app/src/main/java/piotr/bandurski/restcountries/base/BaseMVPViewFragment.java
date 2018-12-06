package piotr.bandurski.restcountries.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import piotr.bandurski.restcountries.R;
import piotr.bandurski.restcountries.dependencyinjection.DependencyUtil;
import piotr.bandurski.restcountries.util.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

public abstract class BaseMVPViewFragment extends BaseFragment implements MvpView {

    public BaseMVPViewFragment(int layoutId) {
        super(layoutId);
    }

    @Inject
    SnackbarUtil snackbarUtil;

    @CallSuper
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //noinspection unchecked
        getPresenter().attachView(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().detachView();
    }

    @Override
    public void showError(@NonNull String error){
        showError(error, requireActivity().findViewById(android.R.id.content));
    }

    public void showError(String error, View view) {
        snackbarUtil.showMessage(view, error, ContextCompat.getColor(requireContext(), R.color.colorAccent));
    }

    protected abstract MvpPresenter getPresenter();

}
