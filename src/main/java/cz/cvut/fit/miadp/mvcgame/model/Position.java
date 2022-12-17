package cz.cvut.fit.miadp.mvcgame.model;

public class Position {

    private int dimX = 0;
	private int dimY = 0;
	
	public Position( ) { }

	public Position( Position position ) {
		dimX = position.dimX;
		dimY = position.dimY;
	}

	public Position( int posX, int posY ) {
		this.dimX = posX;
		this.dimY = posY;
	}

	public int getX( ) {
		return dimX;
	}
    
    public int getY( ) {
		return dimY;
	}
    
    public void setY( int y ) {
		this.dimY = y;
	}
    
    public void setX( int x ) {
		this.dimX = x;
	}

	public void add( Vector vector ) {
		this.setX( this.getX( ) + vector.getDX( ) );
		this.setY( this.getY( ) + vector.getDY( ) );
	}

	public Position clone( ) {
		return new Position( this );
	}
	
}
