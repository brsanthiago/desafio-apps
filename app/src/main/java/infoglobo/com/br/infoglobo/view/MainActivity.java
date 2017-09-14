package infoglobo.com.br.infoglobo.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.adapters.InfoAdapter;
import infoglobo.com.br.infoglobo.adapters.RecyclerCallback;
import infoglobo.com.br.infoglobo.adapters.SimpleDividerItemDecoration;
import infoglobo.com.br.infoglobo.databinding.ActivityMainBinding;
import infoglobo.com.br.infoglobo.databinding.ItemNoticeBinding;
import infoglobo.com.br.infoglobo.domain.di.InfoFactory;
import infoglobo.com.br.infoglobo.domain.model.Notice;
import infoglobo.com.br.infoglobo.viewmodel.NoticesViewModel;

public class MainActivity extends BaseActivity {
    private NoticesViewModel noticesViewModel;
    private ActivityMainBinding binding;

    private InfoAdapter<Notice, ItemNoticeBinding> noticesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        noticesViewModel = ViewModelProviders.of(this, new InfoFactory(app())).get(NoticesViewModel.class);
        noticesViewModel.findNotices();
        loadNotices();
        bindTitle();
    }

    protected void loadNotices() {
        noticesViewModel.findAll().observe(this, new Observer<ArrayList<Notice>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Notice> notices) {
                if (!notices.isEmpty()) {
                    bindAdapter(notices);
                    bindCapa(notices.get(0));
                }
            }
        });
    }

    protected void bindAdapter(final ArrayList<Notice> notices) {
        noticesAdapter = new InfoAdapter<>(notices, R.layout.item_notice, new RecyclerCallback<Notice, ItemNoticeBinding>(){

            @Override
            public void bindData(Notice model, ItemNoticeBinding binder) {
                binder.setNotice(model);
            }
        });
        binding.contentNotices.recycleView.setNestedScrollingEnabled(false);
        binding.contentNotices.recycleView.setAdapter(noticesAdapter);
        binding.contentNotices.recycleView.addItemDecoration(new SimpleDividerItemDecoration(this));
    }
    protected void bindCapa(final Notice notice) {
        binding.setNotice(notice);
    }

    protected void bindTitle() {
        noticesViewModel.getProduto().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                if (!TextUtils.isEmpty(s)) {
                    binding.setProduto(s);
                } else {
                    binding.setProduto(getString(R.string.app_name));
                }
            }
        });
    }
}
