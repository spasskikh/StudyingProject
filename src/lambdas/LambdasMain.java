package lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasMain {

    public static void main(String[] args) {

        String[] colors = {"green", "brown", "black", "blue", "pink", "grey"};

        Player player1 = new Player("John", 100);
        Player player2 = new Player("Mike", 80);
        Player player3 = new Player("Ed", 85);
        Player player4 = new Player("Steve", 90);

        Player[] players = {player1, player2, player3, player4};

        Arrays.sort(colors, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
            }
        });

        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.getScore()-p2.getScore();
            }
        });

        Arrays.sort(colors, (String s1, String s2) -> s2.compareTo(s1));

        Arrays.sort(players, (p1, p2) -> {
                    if ((p2.getScore() - p1.getScore()) != 0) {
                        return p2.getScore() - p1.getScore();
                    } else {
                        return p1.getName().compareTo(p2.getName());
                    }
                }
        );

        System.out.println(Arrays.toString(colors));
        System.out.println(Arrays.toString(players));


    }

    private static class Player {

        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
