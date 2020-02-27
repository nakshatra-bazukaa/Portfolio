package com.github.bazukaa.nakshatra.portfolio.ui.main.projects.util;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.bazukaa.nakshatra.portfolio.R;
import com.github.bazukaa.nakshatra.portfolio.ui.main.util.ImageSlider;
import com.github.bazukaa.nakshatra.portfolio.ui.main.util.ImageSliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private Context mContext;
    private List<Project> projects = new ArrayList<>();

    public ProjectsAdapter(Context mContext, List<Project> projects) {
        this.mContext = mContext;
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_card, parent, false);
        ProjectViewHolder holder = new ProjectViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project currentProject = projects.get(position);
        List<ImageSliderItem> currentImages = currentProject.getProjectImages();

        holder.titleTextView.setText(currentProject.getTitle());
        holder.descriptionTextView.setText(currentProject.getDescription());
        holder.durationTextView.setText(currentProject.getStart() + " - " + currentProject.getEnd());

        ImageSlider adapter = new ImageSlider(mContext, currentImages);
        holder.imageSlider.setSliderAdapter(adapter);
        //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        holder.imageSlider.setIndicatorAnimation(IndicatorAnimations.NONE);
        holder.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        holder.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        holder.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        holder.imageSlider.setScrollTimeInSec(4); //set scroll delay in seconds :
        holder.imageSlider.startAutoCycle();
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView;
        SliderView imageSlider;
        TextView descriptionTextView;
        TextView durationTextView;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.card_project_tv_project_title);
            imageSlider = itemView.findViewById(R.id.card_project_imageSlider);
            descriptionTextView = itemView.findViewById(R.id.card_project_tv_description);
            durationTextView = itemView.findViewById(R.id.card_project_tv_duration);
        }
    }
}
