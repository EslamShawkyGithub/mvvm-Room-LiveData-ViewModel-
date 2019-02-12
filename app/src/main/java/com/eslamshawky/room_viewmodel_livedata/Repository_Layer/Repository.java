package com.eslamshawky.room_viewmodel_livedata.Repository_Layer;

import android.arch.lifecycle.LiveData;

import com.eslamshawky.room_viewmodel_livedata.Entites.Item;

import java.util.List;

public interface Repository {

    void addItem(Item item);

    void deleteItem(Item item);

    LiveData<List<Item>> getItems();
}