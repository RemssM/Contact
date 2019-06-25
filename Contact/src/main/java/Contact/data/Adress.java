package Contact.data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Adress {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String adress;

    protected Adress() {}

    public Adress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, Adress='%s']",
                id, adress);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
    
    
    
}
