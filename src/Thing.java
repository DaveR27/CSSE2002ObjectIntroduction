public class Thing {
    protected String shortDesc;
    protected String longDesc;
    /*
    @param shortDesc: A short name or description for Thing.
    @param longDesc: A more detailed description for the Thing.
     */
    Thing(String shortDesc){
        this.shortDesc = "No Description";
        this.longDesc = "No Description";
    }

    Thing(String shortDesc, String longDesc){
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;

    }

    public String getDescription(){
        return this.longDesc;
    }

    protected String getLong(){
        return this.longDesc;
    }

    protected String getShort(){
        return this.shortDesc;
    }

    /*
    Used to get the name used to represent the Thing object
     */
    public String getShortDescription(){
        return this.shortDesc;
    }

    /*
    Changes the long description of Thing
    @param s: String with a long description for Thing
     */
    protected void setLong(String s){
        this.longDesc = s;
    }

    /*
    Changes the short description of Thing
    @param s: String with a short description for Thing
     */
    protected void setShort(String s){
        this.shortDesc = s;
    }

}
