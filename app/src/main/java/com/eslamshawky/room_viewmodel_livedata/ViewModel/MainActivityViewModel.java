package com.eslamshawky.room_viewmodel_livedata.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.eslamshawky.room_viewmodel_livedata.Entites.Item;
import com.eslamshawky.room_viewmodel_livedata.Repository_Layer.RepositoryImpl;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final String TAG = this.getClass().getName();

    private LiveData<List<Item>> listItems;

    public LiveData<List<Item>> getListItems() {
        if (listItems == null){
            Log.e(TAG, "_ListItemsIsNULL");
            listItems = new MutableLiveData<List<Item>>();
            loadItemsFromRepository();
        }
        Log.e(TAG, "_ReturningFromViewModel");
        return listItems;
    }

    private void loadItemsFromRepository() {
        Log.e(TAG, "_LoadFromDB");
        listItems = RepositoryImpl.getInstance().getItems();
    }
}
