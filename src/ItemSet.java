import java.util.ArrayList;
import java.util.Collections;

public class ItemSet {
    private ArrayList<String> itemSet;
    private Integer frequency;

    public ItemSet(ArrayList<String> itemSet, Integer frequency){
        this.itemSet = itemSet;
        this.frequency = frequency;
    }

    public ArrayList<String> getItemSet(){
        return this.itemSet;
    }

    public Integer getFrequency(){
        return this.frequency;
    }

    public String generateItemSetKey(){
        Collections.sort(itemSet, String.CASE_INSENSITIVE_ORDER);
        return itemSet.toString();
    }

    public boolean equals(ItemSet itemSet){
        return itemSet.generateItemSetKey().equals(this.generateItemSetKey()) &&
                itemSet.getFrequency().equals(this.getFrequency());
    }

    public String toString(){
        String output = "";
        Integer counter = 0;

        for(String item : itemSet){
            if(counter > 0 ){
                output += "," + item;
            } else {
                output += item;
            }
            counter++;
        }
        return output;
    }



}
