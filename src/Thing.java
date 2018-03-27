public class Thing {
    protected String shortDesc;
    protected String longDesc;
    /*
    @param shortDesc: A short name or description for Thing.
    @param longDesc: A more detailed description for the Thing.
     */

    Thing(String shortDesc, String longDesc){

        //TODO Shorter way to do this.
        this.shortDesc = shortDesc.replaceAll("\n", "*");
        this.shortDesc = this.shortDesc.replaceAll("\r", "*");
        this.shortDesc = this.shortDesc.replaceAll(";", "*");
        this.longDesc = longDesc.replaceAll("\n", "*");
        this.longDesc = this.longDesc.replaceAll("\r", "*");
        this.longDesc = this.longDesc.replaceAll(";", "*");

    }

    /*
    Returns the longDesc which can be modified by subclasses

    Long description Note: not to be used for saving or encoding due possible extra
    info being included.

    @return String this.longDesc
     */
    public String getDescription(){
        return this.longDesc;
    }

    /*
    Protected method that allows subclasses to get the raw value of the
    longDesc

    @return String this.longDesc
     */
    protected String getLong(){
        return this.longDesc;
    }

    /*
    Protected method that allows subclasses to read the raw value of the
    shortDesc

    @return String this.shortDesc
     */
    protected String getShort(){
        return this.shortDesc;
    }

    /*
    Returns the shortDesc of Thing so that subclasses can modify it.

    short description Note: This name is used to represent the Thing in text and
    to choose it in dialogs.

    @return String this.shortDesc
     */
    public String getShortDescription(){
        return this.shortDesc;
    }

    /*
    Changes the long description of Thing

    @param String s: String with a long description for Thing
     */
    protected void setLong(String s){
        this.longDesc = s;
    }

    /*
    Changes the short description of Thing

    @param String s: String with a short description for Thing
     */
    protected void setShort(String s){
        this.shortDesc = s;
    }

}
