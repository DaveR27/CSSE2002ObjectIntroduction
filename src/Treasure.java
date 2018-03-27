public class Treasure extends Thing implements Lootable{

    private double value;

    Treasure(String shortDesc, double value){
        super(shortDesc);
        this.value = value;
    }

    public boolean canLoot(Thing looter){
        return looter instanceof Explorer;
    }

    public double getValue(){
        return this.value;
    }

}
