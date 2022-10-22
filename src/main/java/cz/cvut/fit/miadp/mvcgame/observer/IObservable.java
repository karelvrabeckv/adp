package cz.cvut.fit.miadp.mvcgame.observer;

import cz.cvut.fit.miadp.mvcgame.model.Aspect;

public interface IObservable {

    public void registerObserver( IObserver obs, Aspect aspect );
    public void unregisterObserver( IObserver obs );
    public void notifyObservers( Aspect aspect );

}
