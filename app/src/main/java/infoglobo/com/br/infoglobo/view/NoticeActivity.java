package infoglobo.com.br.infoglobo.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.databinding.ActivityNoticeBinding;
import infoglobo.com.br.infoglobo.domain.di.InfoFactory;
import infoglobo.com.br.infoglobo.domain.model.Notice;
import infoglobo.com.br.infoglobo.viewmodel.NoticeViewModel;
import infoglobo.com.br.infoglobo.viewmodel.NoticesViewModel;

public class NoticeActivity extends BaseActivity implements View.OnClickListener {
    private NoticeViewModel noticeViewModel;
    private ActivityNoticeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notice);
        noticeViewModel = ViewModelProviders.of(this, new InfoFactory(app())).get(NoticeViewModel.class);
        noticeViewModel.transformToView(getIntent().getStringExtra("notice"));
        initialize();
    }

    protected void initialize() {
        noticeViewModel.transformNotice().observe(this, new Observer<Notice>() {
            @Override
            public void onChanged(@Nullable Notice notice) {
                if (notice != null) {
                    binding.setNotice(notice);
                    binding.contentIncluded.setNotice(notice);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content_capas, NoticeImagesFragment.newInstance(notice.getImagens()));
                    transaction.commit();
                    binding.toolbar.setNavigationOnClickListener(NoticeActivity.this);
                    binding.fabBrowser.setOnClickListener(NoticeActivity.this);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.fabBrowser.getId()) {
            openInBrowser();
        } else {
            finish();
        }
    }

    private void openInBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(binding.getNotice().getUrl()));
        startActivity(intent);
    }
}
