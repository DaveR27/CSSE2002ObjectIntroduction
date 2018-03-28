public class Thing {
    protected String shortDesc;
    protected String longDesc;

    /**
     * Creates a Thing Object.
     *
     * Note: \n, \r and semi-colons in the parameters will be replaced by "*".
     *
     * @param shortDesc A short name or description for Thing.
     * @param longDesc A more detailed description for the Thing.
     */
    Thing(String shortDesc, String longDesc){

        this.shortDesc = shortDesc.replaceAll("\n", "*");
        this.shortDesc = this.shortDesc.replaceAll("\r", "*");
        this.shortDesc = this.shortDesc.replaceAll(";", "*");
        this.longDesc = longDesc.replaceAll("\n", "*");
        this.longDesc = this.longDesc.replaceAll("\r", "*");
        this.longDesc = this.longDesc.replaceAll(";", "*");

    }

    /**
     * Gets the longDesc which can be modified by subclasses
     *
     * Long description Note: not to be used for saving or encoding due
     * possible extra info being included.
     *
     * @return The longDesc of the Thing
     */
    public String getDescription(){
        return this.longDesc;
    }

    /**
     * Protected method that allows subclasses to get the raw value of the
     * longDesc.
     *
     * @return The raw longDesc value.
     */
    protected String getLong(){
        return this.longDesc;
    }

    /**
     * Protected method that allows subclasses to read the raw value of the
     * shortDesc.
     *
     * @return The raw shortDesc value.
     */
    protected String getShort(){
        return this.shortDesc;
    }

    /**
     * Returns the shortDesc of Thing so that subclasses can modify it.
     *
     * short description Note: This name is used to represent the Thing in text
     * and to choose it in dialogs.
     *
     * @return Name that represents the Thing within the game.
     */
    public String getShortDescription(){
        return this.shortDesc;
    }

    /**
     * Changes the long description of Thing, removes all "\n", "\r" and ";",
     * then replaces them with "*".
     *
     * @param s String with a new long description for Thing
     */
    protected void setLong(String s){
        this.longDesc = s.replaceAll("\n", "*");
        this.longDesc = this.longDesc.replaceAll("\r", "*");
        this.longDesc = this.longDesc.replaceAll(";", "*");
    }

    /**
     * Changes the short description of Thing, removes all "\n", "\r" and ";",
     * then replaces them with "*".
     *
     * @param s String with a short description for Thing.
     */
    protected void setShort(String s){
        this.shortDesc = s.replaceAll("\n", "*");
        this.shortDesc = this.shortDesc.replaceAll("\r", "*");
        this.shortDesc = this.shortDesc.replaceAll(";", "*");
    }

}
