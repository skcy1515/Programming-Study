package tamagotchiGame;

public abstract class usable {
    protected Item item;
    protected Tamagotchi tamagotchi;

    public usable (Item item, Tamagotchi tamagotchi) {
        this.item = item;
        this.tamagotchi = tamagotchi;
    }
    public abstract boolean use();
}
