package infoglobo.com.br.infoglobo.view;

import android.arch.lifecycle.LifecycleFragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.databinding.NoticeImageBinding;
import infoglobo.com.br.infoglobo.databinding.NoticeImagesFragmentBinding;
import infoglobo.com.br.infoglobo.domain.model.Images;

/**
 * Created by Bruno Santiago on 13/09/17.
 */

public class NoticeImagesFragment extends LifecycleFragment {
    private NoticeImagesFragmentBinding binding;
    private static final String IMAGES = "images";
    private ArrayList<Images> images;
    private TextView[] dots;

    public NoticeImagesFragment() {
    }

    public static NoticeImagesFragment newInstance(ArrayList<Images> images) {
        NoticeImagesFragment fragment = new NoticeImagesFragment();

        Bundle b = new Bundle();
        b.putSerializable(IMAGES, images);

        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        images = (ArrayList<Images>) getArguments().getSerializable(IMAGES);
        dots = new TextView[images.size()];
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.notice_images_fragment, container, false);
        addBottomDots(0);
        binding.viewPager.setAdapter(new InfoViewPagerAdapter());
        binding.viewPager.setCurrentItem(0);
        viewPagerListener.onPageSelected(0);
        binding.viewPager.addOnPageChangeListener(viewPagerListener);
        return binding.getRoot();
    }

    protected void addBottomDots(final int current) {
        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getContext().getResources().getColor(R.color.light_black));
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setTextColor(Color.WHITE);
        }
    }ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    public class InfoViewPagerAdapter extends PagerAdapter {
        private NoticeImageBinding binding;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.notice_image, container, false);
            binding = DataBindingUtil.bind(view);
            container.addView(binding.getRoot());
            binding.setCapa(images.get(position));
            return binding.getRoot();
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
