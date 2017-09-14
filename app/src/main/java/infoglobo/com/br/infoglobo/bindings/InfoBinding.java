package infoglobo.com.br.infoglobo.bindings;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import infoglobo.com.br.infoglobo.R;
import infoglobo.com.br.infoglobo.utils.CircleTransform;

/**
 * Created by Bruno Santiago on 11/09/17.
 */
public class InfoBinding {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            new Picasso.Builder(imageView.getContext())
                    .build()
                    .load(url)
                    .error(R.drawable.info_globo)
                    .into(imageView);
        }
    }
    @BindingAdapter("circularImage")
    public static void loadCircularImage(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            new Picasso.Builder(imageView.getContext())
                    .build()
                    .load(url)
                    .transform(new CircleTransform())
                    .error(R.drawable.info_globo)
                    .into(imageView);
        }
    }
}
