public class Critter extends Thing implements Lootable, Mob {

    private int health;
    private double value;
    private int maxHealth;

    Critter(String shortDesc, String longDesc, double value, int health){
        super(shortDesc,longDesc);

        this.health = health;
        this.value = value;
        this.maxHealth = this.health;
    }

    public String getDescription(){
        if(isAlive() == false){
            return this.longDesc + "(fainted)";
        }
        else {
            return this.longDesc;
        }
    }

    public void takeDamage(int d){
        this.health -= d;
    }

    public int getDamage(){
        return 2;
    }

    public boolean canLoot(Thing looter){
        if (looter instanceof Explorer && this.health<=0){
            return true;
        }
        else{
            return false;
        }
    }
    //TODO: use getDamage() to take the health off the mob you will be fighting
    public void fight(Mob mob){
        mob.takeDamage(getDamage());
    }

    public boolean wantsToFight(Mob mob){
        if(mob instanceof Explorer){
            return true;
        }
        else {
            return false;
        }
    }

    public double getValue(){
        return this.value;
    }

    public boolean isAlive(){
        if(this.health>0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setAlive(boolean b){
        if(b == true){
            this.health = this.maxHealth;
        }
        if(b == false){
            this.health = 0;
        }
    }

    public int getHealth(){
        return this.health;
    }

}
