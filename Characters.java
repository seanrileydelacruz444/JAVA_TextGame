package game;
import java.util.List;
import java.util.ArrayList;

import static game.Skill.*;

public abstract class Character {

    int level, HP, MP, ATK, DEF, SPD, INT, WIS;
    final String name;
    Skill UltimateSkill;

    public Character(String name, int level, int HP, int MP, int ATK, int DEF, int SPD, int INT, int WIS, Skill UltimateSkill) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.MP = MP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPD = SPD;
        this.INT = INT;
        this.WIS = WIS;

        this.UltimateSkill = UltimateSkill;

    }

    public String chosenCharacter(){
        return " ";
    }

    public abstract String useUltimateSkill();

    public static  class Dorothy extends Character{
        public Dorothy(){
            super("Dorothy", 1, 150, 100, 50, 100, 50, 40, 40, new FloorPlan());
        }

        @Override
        public String chosenCharacter() {
            return "Dorothy";
        }

        @Override

        public String useUltimateSkill() {
            return "Dorothy used her skill!";
        }
    }

    public static class Quinn extends Character{
        public Quinn(){
            super("Quinn", 1, 150, 100, 50, 50, 50, 40, 40, new FirstAid());
        }

        @Override
        public String chosenCharacter() {
            return "Quinn";
        }

        @Override
        public String useUltimateSkill() {
            return "Quinn used her skill!";
        }
    }

    public static class Noah extends Character{
        public Noah(){
            super("Noah", 1, 100, 100, 80, 80, 150, 40, 40, new Transformation());
        }

        @Override
        public String chosenCharacter() {
            return "Noah";
        }

        @Override
        public String useUltimateSkill() {
            return "Noah used her skill!";
        }
    }

    public static class Darwin extends Character{
        public Darwin(){
            super("Darwin", 1, 100, 100, 50, 80, 50, 80, 40, new HardHats());
        }

        @Override
        public String chosenCharacter() {
            return "Darwin";
        }

        @Override
        public String useUltimateSkill() {
            return "Darwin used her skill!";
        }
    }

    public static class Ace extends Character{
        public Ace(){
            super("Ace", 1, 100, 100, 50, 80, 50, 40, 80, new ExistentialCrisis());
        }

        @Override
        public String chosenCharacter() {
            return "Ace";
        }

        @Override
        public String useUltimateSkill() {
            return "Ace used her skill!";
        }
    }

    public static class Monster extends Character{
        public Monster(){
            super("Monster", 1, 1000, 100, 80, 20, 50, 30, 30, new ExistentialCrisis());
        }

        @Override
        public String chosenCharacter() {
            return "Monster";
        }

        @Override
        public String useUltimateSkill() {
            return "Monster used its skill!";
        }
    }

}
