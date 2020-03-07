package com.github.bazukaa.nakshatra.portfolio.ui.setup.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.bazukaa.nakshatra.portfolio.R;
import com.github.bazukaa.nakshatra.portfolio.ui.main.mytimeline.util.Timeline;
import com.github.bazukaa.nakshatra.portfolio.ui.main.util.ImageSliderItem;

import java.util.ArrayList;
import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {
    private Context mContext;
    private List<Timeline> mTimelines = new ArrayList<>();
    private OnItemClickListener listener;

    public TimelineAdapter(Context mContext, List<Timeline> mTimelines) {
        this.mContext = mContext;
        this.mTimelines = mTimelines;
    }

    @NonNull
    @Override
    public TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_card, parent, false);
        TimelineViewHolder holder = new TimelineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineViewHolder holder, int position) {
        Timeline currentTimeline = mTimelines.get(position);

        List<ImageSliderItem> imageSliderItems = currentTimeline.getSliderItems();
        ImageSliderItem requiredItem = imageSliderItems.get(0);

        holder.timelineText.setText(currentTimeline.getTitle());
        Glide.with(holder.itemView)
                .load(requiredItem.getImageUrl())
                .fitCenter()
                .into(holder.timelineImage);
    }

    @Override
    public int getItemCount() {
        return mTimelines.size();
    }

    public class TimelineViewHolder extends RecyclerView.ViewHolder {
        ImageView timelineImage;
        TextView timelineText;
        public TimelineViewHolder(@NonNull View itemView) {
            super(itemView);
            timelineImage = itemView.findViewById(R.id.card_timeline_img_timeline);
            timelineText = itemView.findViewById(R.id.card_timeline_tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(mTimelines.get(position));
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Timeline timeline);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
