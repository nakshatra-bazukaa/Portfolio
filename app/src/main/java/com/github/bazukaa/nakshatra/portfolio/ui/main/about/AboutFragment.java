package com.github.bazukaa.nakshatra.portfolio.ui.main.about;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.bazukaa.nakshatra.portfolio.R;
import com.github.bazukaa.nakshatra.portfolio.ui.main.MainActivity;
import com.github.bazukaa.nakshatra.portfolio.viewmodel.AboutViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutFragment extends Fragment {

    //To handle the seeMyWork button click
    OnSeeMyWorkClickListener mCallback;
    public interface OnSeeMyWorkClickListener{
        void onSeeMyWorkClicked();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnSeeMyWorkClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "must Implement OnSeeMyWorkClickListener");
        }
    }

    private AboutViewModel mViewModel;

    @BindView(R.id.frag_about_tv_philosophy)
    TextView philosophyTextView;
    @BindView(R.id.frag_about_btn_github)
    Button githubButton;
    @BindView(R.id.frag_about_btn_linkedin)
    Button linkedinButton;
    @BindView(R.id.frag_about_btn_instagram)
    Button instagramButton;
    @BindView(R.id.frag_about_btn_facebook)
    Button facebookButton;
    @BindView(R.id.frag_about_btn_work)
    Button seeMyWorkButton;

    private String githubUrl = "https://github.com/nakshatra-bazukaa";
    private String linkedinUrl = "https://www.linkedin.com/in/nakshatra-gupta-0199b9181/";
    private String instagramUrl = "https://www.instagram.com/nakshatra_bazukaa/";
    private String facebookUrl = "https://www.facebook.com/nakshatra.gupta.90";




    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View aboutFragmentView = inflater.inflate(R.layout.about_fragment, container, false);

        ButterKnife.bind(this, aboutFragmentView);

        philosophyTextView.setMovementMethod(new ScrollingMovementMethod());

        //To handle seeMyWorkButton Click
        seeMyWorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onSeeMyWorkClicked();
            }
        });

        return aboutFragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AboutViewModel.class);
        // TODO: Use the ViewModel
    }

    @OnClick(R.id.frag_about_btn_github)
    public void onGithubButtonClicked(View view){
        Intent githubIntent = new Intent(Intent.ACTION_VIEW);
        githubIntent.setData(Uri.parse(githubUrl));
        startActivity(githubIntent);
    }

    @OnClick(R.id.frag_about_btn_linkedin)
    public void onLinkedinButtonClicked(View view){
        Intent linkedinIntent = new Intent(Intent.ACTION_VIEW);
        linkedinIntent.setData(Uri.parse(linkedinUrl));
        startActivity(linkedinIntent);
    }

    @OnClick(R.id.frag_about_btn_instagram)
    public void onInstagramButtonClicked(View view){
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW);
        instagramIntent.setData(Uri.parse(instagramUrl));
        startActivity(instagramIntent);
    }

    @OnClick(R.id.frag_about_btn_facebook)
    public void onFacebookButtonClicked(View view){
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        facebookIntent.setData(Uri.parse(facebookUrl));
        startActivity(facebookIntent);
    }
}
