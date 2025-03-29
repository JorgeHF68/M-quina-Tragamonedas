public class Main {
    public static void main(String[] args) {
        SlotMachine slotMachine = new SlotMachine(3);
        GUIView view = new GUIView();
        GameController controller = new GameController(slotMachine, view);
    }
}
