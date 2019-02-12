package com.eslamshawky.room_viewmodel_livedata.Repository_Layer;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.Update;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.eslamshawky.room_viewmodel_livedata.DatabaseStore.ItemDatabase;
import com.eslamshawky.room_viewmodel_livedata.Entites.Item;

import java.util.List;

public class RepositoryImpl implements Repository {

    // Single tone to all classes connect with one Repsitory
    private static RepositoryImpl repository = new RepositoryImpl();
   // object from ItemDatabse to execute all operation in Database
    private ItemDatabase itemDB;

    private final String TAG = this.getClass().getName();

    // operations constants
    private static final int INSERT_OPERATION = 0;
    private static final int DELETE_OPERATION = 1;

    // constructor
    private RepositoryImpl(){
        initDB();
    }

    // add public static accessor to singletone object
    public static Repository getInstance(){
        return repository;
    }

    /* method to craete Database by using Builder when builder is method in
    Room datadbase and need to  3 inputs (context,class database , database name)
   */
    private void initDB() {
        Log.e(TAG, "_DataBaseInit");
        itemDB = Room.databaseBuilder(MyApplication.getAppContext(),
                ItemDatabase.class, "ItemDatabase").build();
    }
    @Override
    public void addItem(Item item) {
        Log.e(TAG, "_ItemIsAddedToDB");
        new DataBaseOperation(item,INSERT_OPERATION).execute();

    }

    @Override
    public void deleteItem(Item item) {
        Log.e(TAG, "_ItemIsDeletedFromDB");
        itemDB.itemDao().delete(item);

    }

    @Override
    public LiveData<List<Item>> getItems() {
        Log.e(TAG, "_GetItemsFromDB");
        return itemDB.itemDao().getItems();
    }

    // Async
    class DataBaseOperation extends AsyncTask<Void,Void,Void> {

        public Item item;
        public int operation;

        public DataBaseOperation(Item item, int operation){
            this.item = item;
            this.operation = operation;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Log.e(TAG, "_doInBackgroundInvoked");
            // INSERT operation
            if (operation == INSERT_OPERATION) itemDB.itemDao().insert(item);
            // else delete ...
            if (operation == DELETE_OPERATION) itemDB.itemDao().delete(item);
            return null;
        }

    }
}
