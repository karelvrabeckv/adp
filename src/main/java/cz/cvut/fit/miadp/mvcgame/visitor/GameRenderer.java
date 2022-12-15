package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
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
        this.gr.drawText(
                "Time: " + gameInfo.getTime( ) + " s",
                gameInfo.offsetPosition( 0 )
        );
        this.gr.drawText(
                "Score: " + gameInfo.getScore( ),
                gameInfo.offsetPosition( 1 )
        );
        this.gr.drawText(
                "Moving Strategy: " + gameInfo.getMovingStrategy( ).getName( ),
                gameInfo.offsetPosition( 2 )
        );
        this.gr.drawText(
                "Shooting Mode: " + gameInfo.getShootingMode( ).getName( ),
                gameInfo.offsetPosition( 3 )
        );
        this.gr.drawText(
                "Cannon Angle: " + gameInfo.getCannonAngle( ) + "°",
                gameInfo.offsetPosition( 4 )
        );
        this.gr.drawText(
                "Cannon Power: " + gameInfo.getCannonPower( ),
                gameInfo.offsetPosition( 5 )
        );
        this.gr.drawText(
                "Active Missiles: " + gameInfo.getActiveMissiles( ),
                gameInfo.offsetPosition( 6 )
        );
        this.gr.drawText(
                "Active Enemies: " + gameInfo.getActiveEnemies( ),
                gameInfo.offsetPosition( 7 )
        );
        this.gr.drawText(
                "Active Obstacles: " + gameInfo.getActiveObstacles( ),
                gameInfo.offsetPosition( 8 )
        );
        this.gr.drawText(
                "Active Bombs: " + gameInfo.getActiveBombs( ),
                gameInfo.offsetPosition( 9 )
        );
        this.gr.drawText(
                "Active Collisions: " + gameInfo.getActiveCollisions( ),
                gameInfo.offsetPosition( 10 )
        );
        this.gr.drawText(
                "Missiles Used: " + gameInfo.getUsedMissiles( ),
                gameInfo.offsetPosition( 11 )
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
