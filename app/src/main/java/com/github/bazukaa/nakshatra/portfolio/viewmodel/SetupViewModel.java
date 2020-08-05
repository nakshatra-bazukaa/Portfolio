package com.github.bazukaa.nakshatra.portfolio.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.bazukaa.nakshatra.portfolio.repository.UserRepository;
import com.github.bazukaa.nakshatra.portfolio.db.entity.User;
import com.github.bazukaa.nakshatra.portfolio.viewmodelhelper.SetupViewModelHelper;

import java.util.List;

public class SetupViewModel extends AndroidViewModel implements SetupViewModelHelper {
    private UserRepository userRepository;
    private LiveData<List<User>> users;

    public SetupViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository(application);
        users = userRepository.getUser();
    }

    public void insert(User user) {userRepository.insert(user);}

    public void update(User user) {userRepository.update(user);}

    public void delete(User user) {userRepository.delete(user);}

    public LiveData<List<User>> getUsers() {return users;}
}
