package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;

import java.util.ArrayList;
import java.util.List;

public class Vector {
	private List<Integer> components = new ArrayList<Integer>( );

	public Vector( ) {

	}

	public Vector( int... components ) {
		for ( int i = 0; i < MvcGameConfig.NUM_OF_DIMS; i++ ) {
			this.components.add( components[i] );
		}
	}

	public int getComponent( int i ) {
		return this.components.get( i );
	}

	public void setComponent( int i, int component ) {
		this.components.set( i, component );
	}

	public void add( Vector vector ) {
		for ( int i = 0; i < MvcGameConfig.NUM_OF_DIMS; i++ ) {
			this.setComponent( i, this.getComponent( i ) + vector.getComponent( i ) );
		}
	}
}
