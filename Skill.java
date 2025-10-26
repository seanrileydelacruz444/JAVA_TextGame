package game;

import java.util.Objects;

public class Skill{
    String name;
    int MPcost;
    public Skill(String name, int MPcost) {
        this.name = name;
        this.MPcost = MPcost;
    }

    public void use(Character user, Character target) {
        System.out.println(user.name + " used " + name + " on " + target.name + "!");
    }

    public static class Attack extends Skill{
        public Attack(){
            super("Attack", 0);
        }

        @Override
        public void use(Character user, Character target) {
            int damage = user.ATK - (target.DEF / 2);
            if(damage < 0) damage = 0;
            target.HP -= damage;
            if(target.HP < 0)  target.HP = 0;

            user.MP += 10;
            if(user.MP > 100)  user.MP = 100;

            System.out.println(user.name + " Attacked " + target.name + "!");
            System.out.println(user.name + " hit for ...." + damage + "!");
            System.out.println(target.name + "HP\t:" + target.HP);
            System.out.println(user.name + " gained MP! Current MP: " + user.MP);
            System.out.println(" ");
            System.out.println(" ");
        }

    }

    private String performSkill(Character c) {
        c.MP -= MPcost;
        return name;
    }

    public static class FloorPlan extends Skill{
         public FloorPlan(){super("FloorPlan", 80);}

        @Override
        public void use(Character user, Character target) {
            int damage = (user.ATK * 2) - (target.DEF / 2);
            if(damage < 0) damage = 0;
            target.HP -= damage;
            user.MP -= MPcost;
            if(target.HP < 0)  target.HP = 0;

            System.out.println(user.name + " used her skill against " + target.name + "!");
            System.out.println(user.name + " hit for ...." + damage + "!");
            System.out.println(target.name + "HP\t:" + target.HP);
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static class FirstAid extends Skill{
        public FirstAid(){
            super("FirstAidKit", 80);
        }

        @Override
        public void use(Character user, Character target) {
            int heal = user.HP / 4;
            target.HP += heal;
            user.MP -= MPcost;
            if(target.HP > target.maxHP) target.HP = target.maxHP;

            System.out.println(user.name + " used her heal on " + target.name + "!");
            System.out.println(user.name + " healed for ...." + heal + "!");
            System.out.println(target.name + "HP\t:" + target.HP);
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static class Transformation extends Skill{
        public Transformation(){
            super("Transformation", 80);
        }

        @Override
        public void use(Character user, Character target) {
            user.ATK *= 2;
            user.DEF += 40;
            user.MP -= MPcost;

            System.out.println(user.name + " transformed!!! infront of " + target.name + "!");
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static class HardHats extends Skill{
        public HardHats(){
            super("Hard_Hats", 80);
        }

        @Override
        public void use(Character user, Character target) {
            int damage = (user.ATK * 2) - (target.DEF / 2);
            if(damage < 0) damage = 0;
            target.HP -= damage;
            user.MP -= MPcost;
            if(target.HP < 0)  target.HP = 0;

            System.out.println(user.name + " used her skill against " + target.name + "!");
            System.out.println(user.name + " hit for ...." + damage + "!");
            System.out.println(target.name + "HP\t:" + target.HP);
            System.out.println(" ");
            System.out.println(" ");
        }
    }

    public static class ExistentialCrisis extends Skill{
        public ExistentialCrisis(){
            super("Existential_Crisis", 80);
        }

        @Override
        public void use(Character user, Character target) {
            int damage = (user.ATK * 2) - (target.DEF / 2);
            if(damage < 0) damage = 0;
            target.HP -= damage;
            user.MP -= MPcost;
            if(target.HP < 0)  target.HP = 0;

            System.out.println(user.name + " used her skill against " + target.name + "!");
            System.out.println(user.name + " hit for ...." + damage + "!");
            System.out.println(target.name + "HP\t:" + target.HP);
            System.out.println(" ");
            System.out.println(" ");
        }
    }

}
