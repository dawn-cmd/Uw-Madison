public class Item {
    private String description;
    private int expirationDate;

    public Item(String description, int expirationDate) {
        if (description == null || description.trim().equals("") || expirationDate < 0) {
            throw new IllegalArgumentException("expirationDate is negative (less than zero) or description is null or blank");
        }
        this.description = description;
        this.expirationDate = expirationDate;
    }

    public String getDescription() {return this.description;}

    public void setDescription(String description) {
        if (description == null || description.equals("")) {
            throw new IllegalArgumentException("description is null or blank");
        }
        this.description = description;
    }

    public int getExpirationDate() {return expirationDate;}

    public String toString() {return this.description + ": " + this.expirationDate;}

    public boolean equals(Object other) {
        try {
            if (other == this) {return true;}
            if (!(other instanceof Item)) {return false;}
            Item item = (Item) other;
            return this.description.equals(item.getDescription());
        }
        catch (Exception e) {
            return false;
        }
    }
}
