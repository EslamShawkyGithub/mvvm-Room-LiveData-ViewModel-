package com.eslamshawky.room_viewmodel_livedata.DatabaseStore;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.eslamshawky.room_viewmodel_livedata.DAOInterface.ItemDao;
import com.eslamshawky.room_viewmodel_livedata.Entites.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    public abstract ItemDao itemDao ();
}
