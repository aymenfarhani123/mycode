public class Addresse {
    private int streetNum;
    private String description;


    public Addresse(){}

    public Addresse(int streetNum,String description){
        this.streetNum=streetNum;
        this.description=description;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
