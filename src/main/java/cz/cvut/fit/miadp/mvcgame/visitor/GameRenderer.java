package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.gameObjects.*;

public class GameRenderer implements IVisitor {

    private IGameGraphics gr;

    public void setGraphicContext( IGameGraphics gr ) {
        this.gr = gr;
    }

    @Override
    public void visitCannon( AbsCannon cannon ) {
        this.gr.drawImage( "images/cannon.png", cannon.getPosition( ) );
    }

    @Override
    public void visitMissile( AbsMissile missile ) {
        this.gr.drawImage( "images/missile.png", missile.getPosition( ) );
    }

    @Override
    public void visitEnemy( AbsEnemy enemy ) {
        if ( enemy.getType() == 0 ) {
            this.gr.drawImage( "images/enemy1.png", enemy.getPosition( ) );
        }
        else if ( enemy.getType() == 1 ) {
            this.gr.drawImage( "images/enemy2.png", enemy.getPosition( ) );
        }
    }

    @Override
    public void visitCollision( AbsCollision collision ) {
        this.gr.drawImage( "images/collision.png", collision.getPosition( ) );
    }

    @Override
    public void visitGameInfo( AbsGameInfo gameInfo ) {
        int multiplier = 0;

        this.gr.drawText(
                "Difficulty: " + gameInfo.getDifficultyName( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Time: " + gameInfo.getTime( ) + " / " + gameInfo.getMaxTime( ) + " s",
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Score: " + gameInfo.getScore( ) + " / " + gameInfo.getScoreToReach( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Moving Strategy: " + gameInfo.getMovingStrategy( ).getName( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Shooting Mode: " + gameInfo.getShootingMode( ).getName( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Cannon Angle: " + gameInfo.getCannonAngle( ) + "°",
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Cannon Power: " + gameInfo.getCannonPower( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Active Missiles: " + gameInfo.getActiveMissiles( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Active Enemies: " + gameInfo.getActiveEnemies( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Active Obstacles: " + gameInfo.getActiveObstacles( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Active Bombs: " + gameInfo.getActiveBombs( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Active Collisions: " + gameInfo.getActiveCollisions( ),
                gameInfo.offsetPosition( multiplier++ )
        );
        this.gr.drawText(
                "Missiles Used: " + gameInfo.getUsedMissiles( ) + " / " + gameInfo.getTotalMissiles( ),
                gameInfo.offsetPosition( multiplier++ )
        );
    }

    @Override
    public void visitObstacle( AbsObstacle obstacle ) {
        this.gr.drawImage( "images/obstacle.png", obstacle.getPosition( ) );
    }

    @Override
    public void visitBomb( AbsBomb bomb ) {
        this.gr.drawImage( "images/bomb.png", bomb.getPosition( ) );
    }

}
