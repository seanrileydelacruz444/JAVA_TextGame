package game;

import java.util.Objects;

public class Characters {

    int level, HP, MP, ATK, DEF, SPD, INT, WIS;
    String name;
    String skill1, skill2, Ultimate;

    public Characters(String name) {
        this.name = name;

        if (Objects.equals(name, "Dorothy")) {
            level = 1;
            HP = 150;
            MP = 100;
            ATK = 20;
            DEF = 80;
            SPD = 10;
            INT = 20;
            WIS = 20;

            skill1 = "T_SQUARE";
            skill2 = "COMPASS";
            Ultimate = "SUCCESSFUL_FLOOR_PLAN";
        }
        else if (Objects.equals(name, "Quinn")) {
            level = 1;
            HP = 200;
            MP = 100;
            ATK = 20;
            DEF = 30;
            SPD = 10;
            INT = 20;
            WIS = 20;

            skill1 = "BANDAID";
            skill2 = "SPRAY_BOTTLE";
            Ultimate = "FIRST_AID_KIT";
        }
        else if (Objects.equals(name, "Noah")) {
            level = 1;
            HP = 150;
            MP = 100;
            ATK = 80;
            DEF = 30;
            SPD = 50;
            INT = 20;
            WIS = 20;

            skill1 = "CELLPHONE";
            skill2 = "CALL_VIRUS";
            Ultimate = "TRANSFORMATION";
        }
        else if (Objects.equals(name, "Darwin")) {
            level = 1;
            HP = 150;
            MP = 100;
            ATK = 80;
            DEF = 30;
            SPD = 10;
            INT = 50;
            WIS = 20;

            skill1 = "SURVEY_CAMERA";
            skill2 = "HEAVY_CALCULATIONS";
            Ultimate = "HARD_HATS";
        }
        else if (Objects.equals(name, "Ace")) {
            level = 1;
            HP = 150;
            MP = 100;
            ATK = 80;
            DEF = 30;
            SPD = 10;
            INT = 50;
            WIS = 20;

            skill1 = "PSYCHOLOGY_BOOK";
            skill2 = "UNO_REVERSE_CARD";
            Ultimate = "EXISTENTIAL_CRISIS";
        }
    }

    public String useSkill(int skill) {
        String skillName;
        switch (skill) {
            case 1 -> skillName = skill1;
            case 2 -> skillName = skill2;
            case 3 -> skillName = Ultimate;
            default -> {
                return name + " tried to use an invalid skill!";
            }
        }
        return performSkill(skillName);
    }

    private String performSkill(String skillName) {
        String message = name + " used " + skillName + ". ";

        switch (skillName) {
            case "T_SQUARE" -> {
                MP -= 10;
                message += "MP -10";
            }
            case "COMPASS" -> {
                MP -= 20;
                DEF += 10;
                message += "MP -20, DEF +10";
            }
            case "SUCCESSFUL_FLOOR_PLAN" -> {
                MP = Math.min(MP + 20, 100);
                message += "MP +20";
            }
            default -> message += "No effect (skill not implemented yet).";
        }

        if (MP < 0) MP = 0;

        message += " | Current MP: " + MP + ", DEF: " + DEF;
        return message;
    }
}
