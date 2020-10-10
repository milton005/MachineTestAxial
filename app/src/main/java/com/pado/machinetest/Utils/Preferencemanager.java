package com.pado.machinetest.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencemanager {
    SharedPreferences.Editor editor;

    private SharedPreferences mSharedPreferences;
    private static Preferencemanager instance;

    public static Preferencemanager getUtils() {
        return instance;
    }

    public Preferencemanager(Context context) {
        mSharedPreferences = context.getSharedPreferences("PrefName", Context.MODE_PRIVATE);
        editor=mSharedPreferences.edit();
        instance=this;
    }

    public void savePref(String key, Object value) {
        delete(key);

        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            editor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-primitive preference");
        }

        editor.apply();
    }
    public void delete(String key) {
        if (mSharedPreferences.contains(key)) {
            editor.remove(key).commit();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getPref(String key) {
        return (T) mSharedPreferences.getAll().get(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T getPref(String key, T defValue) {
        T returnValue = (T) mSharedPreferences.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }
}