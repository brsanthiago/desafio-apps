package infoglobo.com.br.infoglobo.adapters;

import android.databinding.ViewDataBinding;

/**
 * Created by Bruno Santiago on 13/09/17.
 */

public interface RecyclerCallback<T, VM extends ViewDataBinding> {
    void bindData(T model, VM binder);
}
