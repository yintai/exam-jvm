package entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Custom")
public class Custom {

    private long id;
    private String name;
    
    public Custom() {  
        super();  
    } 
    public Custom(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }
    @XmlElement
	public void setId(long id){
		this.id=id;
	}

    public String getName() {
        return name;
    }

    @XmlElement
	public void setName(String name){
		this.name=name;
	}

}
