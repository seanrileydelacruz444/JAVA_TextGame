package game;

public abstract class Skill
{
    public final String name;
    int MPcost;

    public Skill(String name, int MpCost)
    {
        this.name = name;
        this.MPcost = MpCost;
    }

    public void use(Character user, Character target)
    {
        if(user.HP <= 0)
        {
            System.out.println(user.name + " is down!");
            return;
        }

    }

    //ATTACK
    public static class Attack extends Skill
    {
        public Attack()
        {
            super("Attack", 0);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
            }
            catch(DeadException dead)
            {
                System.out.println(dead.getMessage());
                return;
            }

            int damage = user.ATK - (target.DEF / 2);
            takeDamage(target, damage);

            user.MP += 15;
            if(user.MP >= 100) user.MP = 100;
        }
    }

    //Skills for Dorothy
    public static class TSquare extends Skill
    {
        public TSquare()
        {
            super("TSquare", 20);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = user.ATK - (target.DEF / 2); // ignore enemy defense
            takeDamage(target, damage);
            user.MP -= MPcost;
        }
    }
    public static class SuccessfullFloorPlan extends Skill
    {
        public SuccessfullFloorPlan()
        {
            super("SuccessfullFloorPlan", 90);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage =  user.DEF / 2;
            takeDamage(target, damage);
            user.DEF += 50;
            user.MP -= MPcost;
        }
    }

    //Skills for Quinn
    public static class FirstAidKit extends Skill
    {
        public FirstAidKit(){
            super("FirstAidKit", 20);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int heal = user.maxHP / 4;
            target.HP += heal;
            user.MP -= MPcost;
            if(target.HP > target.maxHP) target.HP = target.maxHP;

        }
    }
    public static class SyringeRevive extends Skill
    {
        public SyringeRevive()
        {
            super("SyringeRevive", 90);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            user.maxHP += 50;
            user.HP = user.maxHP;
            target.maxHP += 50;
            target.HP = target.maxHP;

            user.MP -= MPcost;
        }
    }


    //Skills for Noah
    public static class CellPhone extends Skill
    {
        public CellPhone()
        {
            super("CellPhone", 20);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = (user.ATK / 2) + 20;
            takeDamage(target, damage);
            user.MP -= MPcost;
        }
    }
    public static class Transformation extends Skill
    {
        public Transformation(){
            super("Transformation", 90);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            user.ATK *= 2;
            user.DEF += 30;
            user.maxHP += 20;
            user.HP += 20;
            if(user.HP > user.maxHP) user.HP = user.maxHP;

            user.MP -= MPcost;
        }
    }

    //Skills for Darwin
    public static class InfoDump extends Skill
    {
        public InfoDump(){
            super("InfoDump", 90);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = (user.INT + 20) - (target.DEF / 2);
            takeDamage(target, damage);

            user.MP -= MPcost;
        }
    }
    public static class HardHats extends Skill
    {
        public HardHats(){ super("HardHats", 90); }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = user.INT;
            takeDamage(target, damage);

            user.DEF += 50;
            target.DEF -= 30;
            user.MP -= MPcost;
        }
    }

    //Skills for Ace
    public static class PsychologyBook extends Skill
    {
        public PsychologyBook(){
            super("PsychologyBook", 20);
        }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = user.WIS - (target.DEF / 2);
            takeDamage(target, damage);

            user.MP -= MPcost;
        }
    }
    public static class ExistentialCrisis extends Skill
    {
        public ExistentialCrisis(){ super("ExistentialCrisis", 90); }

        @Override
        public void use(Character user, Character target)
        {
            try
            {
                isDead(user);
                enoughMP(user);
            }
            catch(DeadException | enoughMpException e)
            {
                System.out.println(e.getMessage());
                return;
            }

            int damage = user.WIS * 2 - target.DEF;
            takeDamage(target, damage);
            user.MP -= MPcost;
        }
    }

    public void takeDamage(Character target, int damage)
    {
        target.HP -= damage;
        if(target.HP < 0) target.HP = 0;
    }

    public void isDead(Character user) throws DeadException {
        if(user.HP <= 0)
        {
            throw new DeadException(user.name + " is down!");
        }
    }

    public void enoughMP(Character user) throws enoughMpException
    {
        if(user.MP < MPcost)
        {
            throw new enoughMpException(user.name + " does not have enough MP for that!");
        }
    }

}
