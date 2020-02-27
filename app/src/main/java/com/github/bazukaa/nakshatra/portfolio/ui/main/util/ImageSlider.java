package com.github.bazukaa.nakshatra.portfolio.ui.main.util;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.bazukaa.nakshatra.portfolio.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ImageSlider extends SliderViewAdapter<ImageSlider.SliderAdapterViewHolder> {
    private Context mContext;
    private List<ImageSliderItem> mImageSliderItems = new ArrayList<>();

    public ImageSlider(Context mContext, List<ImageSliderItem> mImageSliderItems) {
        this.mContext = mContext;
        this.mImageSliderItems = mImageSliderItems;
    }

    public void renewItems(List<ImageSliderItem> imageSliderItems) {
        this.mImageSliderItems = imageSliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mImageSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(ImageSliderItem imageSliderItem) {
        this.mImageSliderItems.add(imageSliderItem);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        ImageSliderItem imageSliderItem = mImageSliderItems.get(position);

        viewHolder.textViewDescription.setText(imageSliderItem.getImageDescription());
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(imageSliderItem.getImageUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return mImageSliderItems.size();
    }

    class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
