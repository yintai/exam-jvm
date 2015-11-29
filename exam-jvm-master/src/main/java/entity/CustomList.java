package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CustomList") 
public class CustomList {


    @XmlElement(name = "Custom")
    private ArrayList<Custom> customList;  

  
    public void setCustomList(ArrayList<Custom> customList) {  
        this.customList = customList;
    }
  
    public ArrayList<Custom> getCustomList() {  
        return customList;  
    } 
    
}
