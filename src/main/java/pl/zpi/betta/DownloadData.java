package pl.zpi.betta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class DownloadData {

    private Map<String, Float> value = new LinkedHashMap<String, Float>();

    public DownloadData(String url)  {

        Reader reader = null;
        try {
            reader = new InputStreamReader(new URL(url).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        DataObject obj = gson.fromJson(reader, DataObject.class);
        setValue(obj);
    }
    public Map<String, Float> getValue() {
        return value;
    }

    public void setValue(DataObject obj) {
        String [] split = obj.rates.toString().split(" - ");
        String s = "";
        for(int i = 0; i<split.length;i++)
            s += split[i];
        String[] split1 = s.split(",");

        for (int i = 0; i < split1.length  ; i++) {
            value.put(split1[i].substring(1,11), Float.parseFloat(split1[i].substring(11,17)));
        }
        this.value = value;
    }

}

