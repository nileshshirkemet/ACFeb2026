package models;

public record Supplier(String name, String item, int quantity) {
    
    public Supplier(String line) {
        String[] segments = line.split(",");
        this(segments[0], segments[1], Integer.parseInt(segments[2]));
    }
}
