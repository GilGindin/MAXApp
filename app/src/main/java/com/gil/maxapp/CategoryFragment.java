package com.gil.maxapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gil.maxapp.Adapter.RecyclerViewAdapter;
import com.gil.maxapp.Model.DataListCat;
import com.gil.maxapp.Model.DataListObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private static final String TAG = "CategoryFragment";
    RecyclerView recyclerview_first, recyclerview_second, recyclerview_third, recyclerview_fourth, recyclerview_five;
    TextView textview1 , textview2 , textview3 , textview4 , textview5;
    private String json;

    static CategoryFragment instance;

    public static CategoryFragment getInstance() {
        if (instance == null) {
            instance = new CategoryFragment();
        }
        return instance;
    }

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_category, container, false);

        initialViews(v);

        loadJson();

        loadJSONfromAsset();

        loadJsonFromAssetCategory();

        initialRecyclerView();



        return v;
    }


    private void initialViews(View v) {
        recyclerview_first = v.findViewById(R.id.recyclerview_first);
        recyclerview_second = v.findViewById(R.id.recyclerview_second);
        recyclerview_third = v.findViewById(R.id.recyclerview_third);
        recyclerview_fourth = v.findViewById(R.id.recyclerview_fourth);
        recyclerview_five = v.findViewById(R.id.recyclerview_five);

        textview1 = v.findViewById(R.id.textview1);
        textview1.setText("קטגוריה 1");

        textview2 = v.findViewById(R.id.textview2);
        textview2.setText("קטגוריה 2");

        textview3 = v.findViewById(R.id.textview3);
        textview3.setText("קטגוריה 3");

    }

    private void initialRecyclerView() {

        recyclerview_first.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_first.setHasFixedSize(true);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(loadJSONfromAsset(), getContext());
        recyclerview_first.setAdapter(recyclerViewAdapter);

        recyclerview_second.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        recyclerview_second.setHasFixedSize(true);
        recyclerview_second.setAdapter(recyclerViewAdapter);

        recyclerview_third.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));
        recyclerview_third.setHasFixedSize(true);
        recyclerview_third.setAdapter(recyclerViewAdapter);

    }

    private String loadJson() {

        try {
            InputStream inputStream = getActivity().getAssets().open("jsonObject.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Log.d(TAG, "loadJSONfromAsset: -------------" + json.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;

        }
        return json;
    }

    private ArrayList<DataListObject> loadJSONfromAsset() {

        ArrayList<DataListObject> myList = new ArrayList<>();

//        String json = null;
//
//        try {
//            InputStream inputStream = getActivity().getAssets().open("jsonObject.json");
//            int size = inputStream.available();
//            byte[] buffer = new byte[size];
//            inputStream.read(buffer);
//            inputStream.close();
//            json = new String(buffer, "UTF-8");
//            Log.d(TAG, "loadJSONfromAsset: -------------" + json.toString());
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//
//        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONObject inside_obj = obj.getJSONObject("DataObject");
            JSONArray m_array = inside_obj.getJSONArray("DataListObject ");

            for (int i = 0; i < m_array.length(); i++) {
                JSONObject inside_obg = m_array.getJSONObject(i);
                DataListObject myObject = new DataListObject();
//                int castId = myObject.getMyCategoriesList().get(i).getCatId();
//                myObject.setCatId(castId);
                myObject.setTitle(inside_obg.getString("Title"));
                myObject.setSTitle(inside_obg.getString("STitle"));
                myObject.setImag(inside_obg.getString("Imag"));
                myObject.setId(inside_obg.getInt("Id"));

                myList.add(myObject);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return myList;
    }

    private ArrayList<DataListCat> loadJsonFromAssetCategory() {

        ArrayList<DataListCat> myCatList = new ArrayList<>();

        String json = null;

        try {
            InputStream inputStream = getActivity().getAssets().open("jsonObject.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;

        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONObject inside_obj = obj.getJSONObject("DataObject");
            JSONArray ms_array = inside_obj.getJSONArray("DataListCat");

            for (int i = 0; i <ms_array.length() ; i++) {
                JSONObject ins_obj = ms_array.getJSONObject(i);
                DataListCat my_in_object = new DataListCat();
                my_in_object.setCatId(ins_obj.getInt("CatId"));
                Log.d(TAG, "loadJsonFromAssetCategory: ---------"+my_in_object.getCatId());
                my_in_object.setCTitle(ins_obj.getString("CTitle"));

            }

        }catch (JSONException ex){
            ex.printStackTrace();
        }
        return myCatList;
    }


}
