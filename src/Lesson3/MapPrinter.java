package Lesson3;

public class MapPrinter {
    public MapPrinter() {
    }

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                sb.append(String.format("%5d", anInt));
            }
            sb.append("\n");
        }
        sb.append("\n".repeat(3));

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int[] ints : map) {
            for (int anInt : ints) {
                switch (anInt) {
                    case 0 -> sb.append("▓▓");
                    case -1 -> sb.append("░░");
                    case 1 -> sb.append("K");
                    default -> sb.append("  ");
                }
            }
            sb.append("\n");
        }
        sb.append("\n".repeat(3));
        return sb.toString();
    }
}
