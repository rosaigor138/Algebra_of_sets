package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Set {
    private ArrayList<Integer> data= new ArrayList<>();
    private String label;
    private Map<String,List> set;
    public Set(List<Integer> data, String label){

        for (int i = 0;i < data.size(); i++){
        this.data.add(data.indexOf(i));
        }

    }

    public ArrayList<Integer> getData() {
        return data;
    }
}
