package com.github.bazukaa.nakshatra.portfolio.ui.setup.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.bazukaa.nakshatra.portfolio.R;

import java.util.ArrayList;
import java.util.List;

public class SetupProjectAdapter extends RecyclerView.Adapter<SetupProjectAdapter.SetupProjectViewHolder> {

    private Context mContext;
    private List<Project> mProjects = new ArrayList<>();
    private OnItemClickListener listener;


    public SetupProjectAdapter(Context mContext, List<Project> mProjects) {
        this.mContext = mContext;
        this.mProjects = mProjects;
    }

    @NonNull
    @Override
    public SetupProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setup_project_card, parent, false);
        SetupProjectViewHolder holder = new SetupProjectViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SetupProjectViewHolder holder, int position) {
        Project currentProject = mProjects.get(position);

        holder.projectNameTv.setText(currentProject.getTitle());
        holder.projectDescriptionTv.setText(currentProject.getDescription());
        String duration = currentProject.getStart() + " - " + currentProject.getEnd();
        holder.projectDurationTv.setText(duration);

    }

    @Override
    public int getItemCount() { return mProjects.size(); }

    public class SetupProjectViewHolder extends RecyclerView.ViewHolder{

        TextView projectNameTv;
        TextView projectDescriptionTv;
        TextView projectDurationTv;

        public SetupProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            projectNameTv = itemView.findViewById(R.id.card_setup_project_tv_title);
            projectDescriptionTv = itemView.findViewById(R.id.card_setup_project_tv_description);
            projectDurationTv = itemView.findViewById(R.id.card_setup_project_tv_duration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(mProjects.get(position));
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(Project project);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

}
