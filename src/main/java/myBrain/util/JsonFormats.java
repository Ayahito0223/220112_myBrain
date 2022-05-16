package myBrain.util;

import java.util.ArrayList;

/**
 *
 * @author Ayahito0223
 */
public class JsonFormats {

    private int dataSize = 0;
    private ArrayList<JsonFormat> datas = new ArrayList<>();

    public void updateNumber() {
        for(int i = 0; i < datas.size(); i++){
            datas.get(i).setNumber(i);
        }
        dataSize = datas.size();
    }

    public void clear() {
        datas.clear();
        dataSize = 0;
    }

    public void add(JsonFormat data) {
        data.setNumber(dataSize);
        dataSize += 1;
        datas.add(data);
    }

    public void set(int index, JsonFormat data) {
        data.setNumber(index);
        datas.set(index, data);
    }

    public JsonFormat get(int index) {
        return datas.get(index);
    }

    public void remove(int index) {
        datas.remove(index);
        dataSize -= 1;
        for (int i = 0; i < dataSize; i++) {
            datas.get(i).setNumber(i);
        }
    }

    public ArrayList<JsonFormat> getDatas() {
        return datas;
    }
}
