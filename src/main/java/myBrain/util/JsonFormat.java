package myBrain.util;

import java.util.ArrayList;

/**
 *
 * @author Ayahito0223
 */
public class JsonFormat {
    private int number;
    private String title; 
    private ArrayList<String> urls = new ArrayList<>();
    private ArrayList<String> tags = new ArrayList<>();
    private String result;
    private String other;
    
    public JsonFormat(String title, ArrayList<String> urls, ArrayList<String> tags, String result, String other){
        this.number = -1;
        this.title = title;
        this.urls = urls;
        this.tags = tags;
        this.result = result;
        this.other = other;
    }
    
    public boolean checkStr(){
        if(title.isEmpty()){
            return false;
        }else if(tags.size() == 0){
            return false;
        }else if(result.isEmpty()){
            return false;
        }
        return true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public String getTitle(){
        return this.title;
    }
    public ArrayList<String> getUrls(){
        return this.urls;
    }
    public ArrayList<String> getTags(){
        return this.tags;
    }
    public String getResult(){
        return this.result;
    }
    public String getOther(){
        return this.other;
    }
}
