package infoglobo.com.br.infoglobo.view;

import android.arch.lifecycle.LifecycleActivity;

import infoglobo.com.br.infoglobo.InfoApp;

/**
 * Created by Bruno Santiago on 11/09/17.
 */

public abstract class BaseActivity extends LifecycleActivity {
    protected InfoApp app() {
        return (InfoApp) getApplication();
    }
}
