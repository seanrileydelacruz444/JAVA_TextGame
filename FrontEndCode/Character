package game;

public abstract class Character
{
    public static final Skill BasicAttack = new Skill.Attack();

    public final String name;
    public int HP, MP, DEF, ATK, maxHP, maxMP, WIS, INT;
    public static int baseHP = 100, baseMP = 100, baseDEF = 50, baseATK = 50, baseWIS = 50, baseINT = 50;

    public Skill attack, skill1, Ultimate;


    public Character(String name, int HP, int MP, int DEF, int ATK, int WIS, int INT, Skill skill1, Skill Ultimate)
    {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
        this.DEF = DEF;
        this.ATK = ATK;
        this.WIS = WIS;
        this.INT = INT;
        maxHP = HP;
        maxMP = MP;

        this.attack = BasicAttack;
        this.skill1 = skill1;
        this.Ultimate = Ultimate;
    }

    public String getName()
    {
        return name;
    }

    public static class Dorothy extends Character
    {
        public Dorothy() {
            super("Dorothy", 150, baseMP, 100, baseATK, baseWIS, baseINT, new Skill.TSquare(), new Skill.SuccessfullFloorPlan());
        }

    }

    public static class Quinn extends Character
    {
        public Quinn()
        {
            super("Quinn", 200, baseMP, baseDEF, baseATK, baseWIS, baseINT, new Skill.FirstAidKit(), new Skill.SyringeRevive());
        }
    }

    public static class Noah extends Character
    {
        public Noah()
        {
            super("Noah", baseHP, baseMP, baseDEF, 100, baseWIS, baseINT, new Skill.CellPhone(), new Skill.Transformation());
        }
    }

    public static class Darwin extends Character
    {
        public Darwin()
        {
            super("Darwin", baseHP, baseMP, baseDEF, baseATK, baseWIS, 100, new Skill.InfoDump(), new Skill.HardHats());
        }
    }

    public static class Ace extends Character
    {
        public Ace()
        {
            super("Ace", baseHP, baseMP, baseDEF, baseATK, 100, baseINT, new Skill.PsychologyBook(), new Skill.ExistentialCrisis());
        }
    }

    public static class HomeworkMonster extends Character
    {
        public HomeworkMonster()
        {
            super("Homework_Monster", 200, 50, 40, 50, 50, 50, new Skill.CellPhone(), new Skill.InfoDump());
        }
    }

    public static class MidtermMonster extends Character
    {
        public MidtermMonster()
        {
            super("Midterm_Monster", 400,50,40,50,50,50, new Skill.CellPhone(), new Skill.InfoDump());
        }
    }

    public static class Finals_Monster extends Character
    {
        public Finals_Monster()
        {
            super("Finals_Monster", 600, 50, 50,60,60,60, new Skill.CellPhone(), new Skill.InfoDump());
        }
    }

    public static class FinalProject extends Character
    {
        public FinalProject()
        {
            super("The_Final_Project", 800, 50, 60, 60, 60, 60, new Skill.CellPhone(), new Skill.InfoDump());
        }
    }

}
