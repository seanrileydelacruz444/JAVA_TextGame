package game;

import java.util.List;

public class TurnSystem
{
    private List<Character> players;
    private Character Monster;
    private int chosen = 0;
    private boolean YourTurn = true;

    int turn = 1;
    Character Active;
    public static Skill BasicAttack = new Skill.Attack();

    public TurnSystem(List<Character> players, Character Monster)
    {
        this.players = players;
        this.Monster = Monster;
        this.Active = players.get(chosen);
    }

    //Main spine ani, checks if it's your turn or not
    public void nextTurn()
    {
        YourTurn = !YourTurn;

        if(YourTurn == true)
        {
            System.out.println("Your turn! Round " + turn);
        }
        else
        {
            System.out.println("Enemy turn! Round " + turn);
            EnemyAction(Monster);
            turn++;

            YourTurn = !YourTurn;
        }


    }

    public void ActionChosen(Character attacker, Character target, Skill skillChosen)
    {
        if(YourTurn == false)
        {
            return;
        }

        this.Active = attacker;
        skillChosen.use(attacker, target);

        if(hasEnded()) return;

        nextTurn();
    }

    public void EnemyAction(Character Monster)
    {
        Skill attack = Monster.attack;
        attack.use(Monster, Active);

        hasEnded();
    }

    public boolean hasEnded()
    {
        if(Monster.HP <= 0)
            return true;

        boolean playersDead = true;
        for(Character player : players)
        {
            if(player.HP > 0)
            {
                playersDead = false;
                break;
            }
        }

        if(playersDead)
        {
            System.out.println("Game Over!");
            if (listener != null) listener.onGameOver();
            return true;
        }

        return false;
    }


    public boolean isYourTurn()
    {
        return YourTurn;
    }

    public interface GameOverListener {
        void onGameOver();
    }

    private GameOverListener listener;

    public void setGameOverListener(GameOverListener listener) {
        this.listener = listener;
    }

}
