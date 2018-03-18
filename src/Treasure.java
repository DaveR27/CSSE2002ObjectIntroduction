public class Treasure extends Thing implements Lootable{

    private double value;

    Treasure(String shortDesc, double value){
        super(shortDesc);
        this.value = value;
    }

    public boolean canLoot(Thing looter){
        if(looter instanceof Explorer){
            return true;
        }
        else{
            return false;
        }
    }

    public double getValue(){
        return this.value;
    }

}
